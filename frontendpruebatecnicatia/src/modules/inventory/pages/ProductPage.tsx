import { DynamicTable } from "@/components/shared/DynamicTable";
import { Product, ProductFilters } from "@/models";
import { getProducts } from "@/services/products.service";
import { useEffect, useState } from "react";
import { toast } from "sonner";
import DialogRegisterProduct from "../component/DialogRegisterProduct";

export default function ProductPage() {
  const [products, setProducts] = useState<Product[]>([
    {
      id: 1,
      name: "Ryzen 5 5600g",
      price: 200,
      SKU: "344444444",
      category: "Tech",
      description: "procesador",
      state: 1,
    },
  ]);
  const [productFilters, setProductFilters] = useState<ProductFilters>({
    page: 1,
    pageSize: 10,
  });

  const headers = [
    { name: "Nombre", accessKey: "name" },
    { name: "Precio", accessKey: "price" },
    { name: "SKU", accessKey: "SKU" },
    { name: "Category", accessKey: "category" },
    { name: "Descripcion", accessKey: "description" },
    { name: "Estado", accessKey: "state" },
  ];

  const handleAddProduct = () => {
    toast.success("Product Creado");
  };

  useEffect(() => {
    const fetchData = async () => {
      const dataResponse = await getProducts(productFilters);
      setProductFilters(dataResponse);
    };

    // fetchData();
  }, []);

  return (
    <div className="flex flex-col gap-3 py-2 px-5">
      <section>
        <h3 className="text-[30px] font-[800]">Productos</h3>
      </section>
      <section>
        <DialogRegisterProduct />
      </section>
      <section>
        <DynamicTable headers={headers} data={products} />
      </section>
    </div>
  );
}
