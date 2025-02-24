import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { FieldError, UseFormSetValue } from "react-hook-form";

interface CustomInputProps {
  label: string;
  name: string;
  register: any;
  error?: FieldError;
  type?: string;
  setValue?: UseFormSetValue<any>;
}

export function CustomInput({
  label,
  name,
  register,
  error,
  setValue,
  type = "text",
}: CustomInputProps) {
  return (
    <div className="flex flex-col space-y-1">
      <Label htmlFor={name}>{label}</Label>
      <Input
        id={name}
        type={type}
        {...register(name, { valueAsNumber: type === "number" })}
        onChange={(e) => {
          if (type === "number" && setValue) {
            const value = e.target.value === "" ? "" : Number(e.target.value);
            setValue(name, value);
          }
        }}
      />
      {error && <span className="text-red-500 text-sm">{error.message}</span>}
    </div>
  );
}
