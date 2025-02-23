import { z } from "zod";

export const shopSchema = z.object({
  name: z.string(),
  address: z.string(),
  contact: z.string(),
  phone: z.string(),
  isActive: z.boolean(),
  openingTime: z.string(),
  closingTime: z.string(),
});

export type ShopFormData = z.infer<typeof shopSchema>;
