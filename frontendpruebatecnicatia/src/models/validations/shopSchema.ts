import { z } from "zod";

export const shopSchema = z.object({
  name: z.string().min(3, "Debe tener al menos 3 caracteres alfanumericos"),
  address: z.string().min(3, "Debe tener al menos 3 caracteres alfanumericos"),
  contact: z.string().min(3, "Debe tener al menos 3 caracteres alfanumericos"),
  phone: z.string().min(3, "Debe tener al menos 3 caracteres alfanumericos"),
  isActive: z.boolean(),
  openingTime: z.string(),
  closingTime: z.string(),
});

export type ShopFormData = z.infer<typeof shopSchema>;
