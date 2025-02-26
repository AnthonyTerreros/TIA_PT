import type { Sale, SaleFilters } from "@/models";
import { getSales } from "@/services/sales.service";
import { useEffect, useState } from "react";
import DialogCreateSale from "../components/DialogCreateSale";
import { DynamicTable } from "@/components/shared/DynamicTable";
import CustomPagination from "@/components/shared/CustomPagination";
import { usePagination } from "@/hooks/usePagination";

export default function SalePage() {
  const [sales, setSales] = useState<Sale[]>([
    {
      id: 1,
      paymentMethod: "cash",
      purchaseDate: new Date().toISOString(),
      shopId: 1,
      saleDTODetails: [{ id: 1, productId: 1, quantity: 2, saleId: 1 }],
      total: 100,
      userId: 1,
    },
  ]);

  const {
    page,
    pageSize,
    totalPages,
    handleNextPage,
    handlePrevPage,
    setPage,
    setTotalPages,
  } = usePagination();

  const headers = [
    { name: "Monto", accessKey: "total" },
    { name: "Metodo de Pago", accessKey: "paymentMethod" },
    { name: "Fecha de la Venta", accessKey: "purchaseDate" },
    { name: "Tienda", accessKey: "shop.name" },
  ];

  const fetchData = async () => {
    const saleFilters = { page, pageSize } as SaleFilters;
    const dataResponse = await getSales(saleFilters);
    setSales(dataResponse.content);
    setPage(dataResponse.pageable.pageNumber);
    setTotalPages(dataResponse.totalPages);
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div className="flex flex-col gap-3 py-2 px-5">
      <section>
        <h3 className="text-[30px] font-[800]">Ventas</h3>
      </section>
      <section>
        <DialogCreateSale onSaleAdded={fetchData} />
      </section>
      <section>
        <DynamicTable headers={headers} data={sales} />
        <CustomPagination
          page={page}
          totalPages={totalPages}
          handleNextPage={handleNextPage}
          handlePrevPage={handlePrevPage}
        />
      </section>
    </div>
  );
}
