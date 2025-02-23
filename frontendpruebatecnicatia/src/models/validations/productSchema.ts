import { z } from "zod";

export const productSchema = z.object({
  name: z.string(),
  price: z
    .number({ invalid_type_error: "el precio debe ser un numero" })
    .positive("el precio debe ser mayor a 0"),
  SKU: z.string(),
  category: z.string(),
  description: z.string().optional(),
  state: z.number(),
});

export type ProductFormData = z.infer<typeof productSchema>;
