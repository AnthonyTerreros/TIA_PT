import { z } from "zod";

export const inventorySchema = z.object({
  inventory: z
    .array(
      z.object({
        productId: z.number({ required_error: "El producto es obligatorio" }),
        shopId: z.number(),
        stock: z.number().min(1, "El stock debe ser mayor a 0"),
      })
    )
    .refine(
      (items) => {
        const uniquePairs = new Set(
          items.map((item) => `${item.productId}-${item.shopId}`)
        );
        return uniquePairs.size === items.length;
      },
      {
        message:
          "No puedes agregar el mismo producto en la misma tienda más de una vez.",
        path: ["inventory"],
      }
    ),
});

export type InventoryFormData = z.infer<typeof inventorySchema>;
