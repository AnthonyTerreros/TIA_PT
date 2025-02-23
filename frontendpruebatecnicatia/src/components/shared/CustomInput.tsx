import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { FieldError } from "react-hook-form";

interface CustomInputProps {
  label: string;
  name: string;
  register: any;
  error?: FieldError;
  type?: string | number;
}

export function CustomInput({
  label,
  name,
  register,
  error,
  type = "text",
}: CustomInputProps) {
  return (
    <div className="flex flex-col space-y-1">
      <Label htmlFor={name}>{label}</Label>
      <Input id={name} type={type} {...register(name)} />
      {error && <span className="text-red-500 text-sm">{error.message}</span>}
    </div>
  );
}
