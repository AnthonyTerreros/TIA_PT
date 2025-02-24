import { useEffect, useState } from "react";
import DialogAssignProductsToShop from "../component/DialogAssignProductsToShop";
import { getShops } from "@/services/shop.service";
import { SelectItem, Shop, ShopFilters } from "@/models";
import { DynamicTable } from "@/components/shared/DynamicTable";
import DialogCreateShop from "../component/DialogCreateShop";
import CustomPagination from "@/components/shared/CustomPagination";
import { usePagination } from "@/hooks/usePagination";
import { getProductsAll } from "@/services/products.service";

export default function ShopPage() {
  const [shops, setShops] = useState<Shop[]>([
    {
      id: 1,
      name: "Tienda Centro",
      address: "Av. Centro",
      contact: "2332323232",
      isActive: true,
      phone: "233232",
      openingTime: "03:40",
      closingTime: "23:30",
    },
  ]);

  const [products, setProducts] = useState<SelectItem[]>([]);

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
    { name: "Nombre", accessKey: "name" },
    { name: "Dirección", accessKey: "address" },
    { name: "Contacto", accessKey: "contact" },
    { name: "Teléfono", accessKey: "phone" },
    { name: "Hora de Apertura", accessKey: "openingTime" },
    { name: "Hora de Cierre", accessKey: "closingTime" },
  ];

  const fetchData = async () => {
    const shopFilters = { page, pageSize } as ShopFilters;

    const [dataResponse, dataProductsResult] = await Promise.all([
      getShops(shopFilters),
      getProductsAll(),
    ]);

    console.log(dataResponse)
    console.log(dataProductsResult)

    const dataMapped = dataProductsResult.map((it: any) => {
      return {
        label: it.name,
        value: it.id,
      };
    }) as SelectItem[];
    setProducts(dataMapped);
    setShops(dataResponse.content);
    setPage(dataResponse.pageable.pageNumber);
    setTotalPages(dataResponse.totalPages);
  };

  useEffect(() => {
    fetchData();
  }, [page]);

  return (
    <div className="flex flex-col gap-3 py-2 px-5">
      <section>
        <h3 className="text-[30px] font-[800]">Locales</h3>
      </section>
      <section>
        <DialogCreateShop onShopAdded={fetchData} />
      </section>
      <section>
        <DynamicTable
          headers={headers}
          data={shops}
          renderActions={(it) => {
            return (
              <DialogAssignProductsToShop shopId={it.id} products={products} />
            );
          }}
        />
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
