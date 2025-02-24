import type { Sale, SaleFilters } from "@/models";
import { getSales } from "@/services/sales.service";
import { useEffect, useState } from "react";
import DialogCreateSale from "../components/DialogCreateSale";
import { DynamicTable } from "@/components/shared/DynamicTable";

export default function SalePage() {
  const [sales, setSales] = useState<Sale[]>([
    {
      id: 1,
      paymentMethod: "cash",
      purchaseDate: new Date().toISOString(),
      shopId: 1,
      saleDetails: [{ id: 1, productId: 1, quantity: 2, saleId: 1 }],
      total: 100,
      userId: 1,
    },
  ]);

  const [saleFilters, setSaleFilters] = useState<SaleFilters>({
    page: 1,
    pageSize: 10,
  });

  const headers = [
    { name: "Monto", accessKey: "total" },
    { name: "Metodo de Pago", accessKey: "paymentMethod" },
    { name: "Fecha de la Venta", accessKey: "purchaseDate" },
    { name: "Tienda", accessKey: "shopId" },
  ];

  useEffect(() => {
    const fetchData = async () => {
      const dataResponse = await getSales(saleFilters);
      setSales(dataResponse);
    };

    // fetchData();
  }, []);

  return (
    <div className="flex flex-col gap-3 py-2 px-5">
      <section>
        <h3 className="text-[30px] font-[800]">Ventas</h3>
      </section>
      <section>
        <DialogCreateSale />
      </section>
      <section>
        <DynamicTable headers={headers} data={sales} />
      </section>
    </div>
  );
}
