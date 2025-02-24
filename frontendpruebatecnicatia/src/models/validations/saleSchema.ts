import { z } from "zod";

export const saleSchema = z.object({
  shopId: z.number().min(1, "Seleccione una tienda"),
  paymentMethod: z.enum(["card", "cash"]),
  saleDetails: z.array(
    z.object({
      productId: z.number().min(1, "Seleccione un producto"),
      quantity: z.number().min(1, "Debe ser al menos 1"),
    })
  ),
});

export type SaleFormData = z.infer<typeof saleSchema>;
