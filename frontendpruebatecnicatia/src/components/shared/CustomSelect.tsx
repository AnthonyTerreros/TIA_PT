import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { Label } from "@/components/ui/label";
import { FieldError, UseFormSetValue } from "react-hook-form";

interface CustomSelectProps {
  label: string;
  name: string;
  options: { value: number | string; label: string }[];
  error?: FieldError;
  setValue: UseFormSetValue<any>;
  getId?: boolean;
}

export function CustomSelect({
  label,
  name,
  options,
  error,
  setValue,
  getId = true,
}: CustomSelectProps) {
  return (
    <div className="flex flex-col space-y-1">
      <Label>{label}</Label>
      <Select
        onValueChange={(value) => setValue(name, getId ? Number(value) : value)}
      >
        <SelectTrigger>
          <SelectValue placeholder="Selecciona un producto" />
        </SelectTrigger>
        <SelectContent>
          {options.map((option, idx) => (
            <SelectItem key={`${option.value}-${idx}`} value={String(option.value)}>
              {option.label}
            </SelectItem>
          ))}
        </SelectContent>
      </Select>
      {error && <span className="text-red-500 text-sm">{error.message}</span>}
    </div>
  );
}
