import { Button } from "@/components/ui/button";
import { useEffect, useState } from "react";
import { IoAdd } from "react-icons/io5";
import DialogAssignProductsToShop from "../component/DialogAssignProductsToShop";
import { getShops } from "@/services/shop.service";
import { Shop, ShopFilters } from "@/models";
import { DynamicTable } from "@/components/shared/DynamicTable";
import DialogCreateShop from "../component/DialogCreateShop";

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
  const [shopFilters, setShopFilters] = useState<ShopFilters>({
    page: 1,
    pageSize: 10,
    totalPages: 1,
  });

  const headers = [
    { name: "Nombre", accessKey: "name" },
    { name: "Dirección", accessKey: "address" },
    { name: "Contacto", accessKey: "contact" },
    { name: "Teléfono", accessKey: "phone" },
    { name: "Hora de Apertura", accessKey: "openingTime" },
    { name: "Hora de Cierre", accessKey: "closingTime" },
  ];

  useEffect(() => {
    const fetchData = async () => {
      const dataResponse = await getShops(shopFilters);
      setShops(dataResponse);
    };

    // fetchData();
  }, []);

  return (
    <div className="flex flex-col gap-3 py-2 px-5">
      <section>
        <h3 className="text-[30px] font-[800]">Locales</h3>
      </section>
      <section>
        <DialogCreateShop />
      </section>
      <section>
        <DynamicTable
          headers={headers}
          data={shops}
          renderActions={(it) => {
            return <DialogAssignProductsToShop shopId={it.id} />;
          }}
        />
      </section>
    </div>
  );
}
