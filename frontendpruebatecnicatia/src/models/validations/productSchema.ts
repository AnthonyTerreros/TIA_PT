import { z } from "zod";

export const productSchema = z.object({
  name: z.string().min(4, "Escribe al menos 4 letras"),
  price: z
    .number({ invalid_type_error: "el precio debe ser un numero" })
    .positive("el precio debe ser mayor a 0"),
  sku: z.string().min(4, "Escribe al menos 4 letras"),
  category: z.string(),
  description: z.string().optional(),
  state: z.number(),
});

export type ProductFormData = z.infer<typeof productSchema>;
