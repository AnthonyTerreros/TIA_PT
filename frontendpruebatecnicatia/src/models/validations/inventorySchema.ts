import { z } from "zod";

export const inventorySchema = z.object({
  inventory: z.array(
    z.object({
      productId: z.number({ required_error: "El producto es obligatorio" }),
      shopId: z.number(),
      stock: z.number().min(1, "El stock debe ser mayor a 0"),
    })
  ),
});

export type InventoryFormData = z.infer<typeof inventorySchema>;
