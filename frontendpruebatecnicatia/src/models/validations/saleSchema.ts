import { z } from "zod";

export const saleSchema = z.object({
  shopId: z.number().min(1, "Seleccione una tienda"),
  paymentMethod: z.enum(["card", "cash"]),
  saleDetails: z
    .array(
      z.object({
        productId: z.number().min(1, "Seleccione un producto"),
        quantity: z.number().min(1, "Debe ser al menos 1"),
      })
    )
    .refine(
      (items) => {
        const uniqueProducts = new Set(items.map((item) => item.productId));
        return uniqueProducts.size === items.length;
      },
      {
        message:
          "No puedes agregar el mismo producto más de una vez en la venta.",
        path: ["saleDetails"],
      }
    ),
});

export type SaleFormData = z.infer<typeof saleSchema>;
