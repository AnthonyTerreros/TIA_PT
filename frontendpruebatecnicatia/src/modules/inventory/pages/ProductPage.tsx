import { DynamicTable } from "@/components/shared/DynamicTable";
import { Product, ProductFilters } from "@/models";
import { getProducts } from "@/services/products.service";
import { useEffect, useState } from "react";
import DialogRegisterProduct from "../component/DialogRegisterProduct";

import CustomPagination from "@/components/shared/CustomPagination";
import { usePagination } from "@/hooks/usePagination";

export default function ProductPage() {
  const [products, setProducts] = useState<Product[]>([
    {
      id: 1,
      name: "Ryzen 5 5600g",
      price: 200,
      sku: "344444444",
      category: "Tech",
      description: "procesador",
      state: 1,
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
    { name: "Nombre", accessKey: "name" },
    { name: "Precio", accessKey: "price" },
    { name: "SKU", accessKey: "SKU" },
    { name: "Category", accessKey: "category" },
    { name: "Descripcion", accessKey: "description" },
    // { name: "Estado", accessKey: "state" },
  ];

  const fetchData = async () => {
    const productFilters = { page, pageSize } as ProductFilters;
    const dataResponse = await getProducts(productFilters);
    setProducts(dataResponse.content);
    setPage(dataResponse.pageable.pageNumber);
    setTotalPages(dataResponse.totalPages);
  };

  useEffect(() => {
    fetchData();
  }, [page]);

  return (
    <div className="flex flex-col gap-3 py-2 px-5">
      <section>
        <h3 className="text-[30px] font-[800]">Productos</h3>
      </section>
      <section>
        <DialogRegisterProduct onProductAdded={fetchData} />
      </section>
      <section>
        <DynamicTable headers={headers} data={products} />
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
