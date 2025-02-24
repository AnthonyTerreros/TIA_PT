import { useState, useEffect, useMemo } from "react";
import { useForm, useFieldArray } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { CustomInput } from "@/components/shared/CustomInput";
import { CustomSelect } from "@/components/shared/CustomSelect";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import { IoAdd, IoTrash } from "react-icons/io5";
import { SaleFormData, saleSchema } from "@/models/validations/saleSchema";
import { ProductFilters, SaleRequest, SelectItem, ShopFilters } from "@/models";
import { getProducts } from "@/services/products.service";
import { getShops } from "@/services/shop.service";
import { toast } from "sonner";
import { registerSale } from "@/services/sales.service";

interface ProductOption extends SelectItem {
  price: number;
}

type ShopOption = SelectItem;

export default function DialogCreateSale() {
  const [isOpen, setIsOpen] = useState(false);
  const [products, setProducts] = useState<ProductOption[]>([
    {
      value: 1,
      label: "Ryzen 5 5600g",
      price: 200,
    },
  ]);

  const [shops, setShops] = useState<ShopOption[]>([
    {
      value: 1,
      label: "Tienda Centro",
    },
  ]);

  const {
    register,
    handleSubmit,
    setValue,
    control,
    reset,
    watch,
    formState: { errors },
  } = useForm<SaleFormData>({
    resolver: zodResolver(saleSchema),
    defaultValues: {
      shopId: 0,
      paymentMethod: "cash",
      saleDetails: [{ productId: 0, quantity: 1 }],
    },
  });

  const { fields, append, remove } = useFieldArray({
    control,
    name: "saleDetails",
  });

  // Total
  const total = useMemo(() => {
    return watch("saleDetails").reduce((acc, item) => {
      const product = products.find((p) => p.value === item.productId);
      return acc + (product ? product.price * item.quantity : 0);
    }, 0);
  }, [watch("saleDetails")]);

  useEffect(() => {
    const fetchData = async () => {
      const [dataProductsResult, dataShopsResult] = await Promise.all([
        getProducts({ page: 1, pageSize: 10 } as ProductFilters),
        getShops({ page: 1, pageSize: 10 } as ShopFilters),
      ]);
      setProducts(dataProductsResult);
      setShops(dataShopsResult);
    };

    // fetchData();
  }, []);

  const onSubmit = async (data: SaleFormData) => {
    const saleData = {
      ...data,
      total,
      purchaseDate: new Date().toISOString(),
      userId: 1,
    } as SaleRequest;
    console.log("Venta registrada:", saleData);
    try {
      const responseApi = await registerSale(saleData);
      if (responseApi.status !== 201) {
        toast.error("Ocurrio un error. Intenta de nuevo.");
        return;
      }
      toast.success("Producto Creado Sastifactoriamente.");
      reset();
      setIsOpen(false);
    } catch (ex: any) {
      toast.error("Ocurrio un error. Intenta mas tarde.");
    }
  };

  return (
    <Dialog open={isOpen} onOpenChange={setIsOpen}>
      <DialogTrigger asChild>
        <Button>
          <IoAdd className="size-6" />
          Registrar Venta
        </Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Registrar Venta</DialogTitle>
        </DialogHeader>

        <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
          {/* Selección de tienda y método de pago */}
          <div className="grid grid-cols-2 gap-4">
            <CustomSelect
              label="Tienda"
              name="shopId"
              options={shops}
              error={errors.shopId}
              setValue={setValue}
            />
            <CustomSelect
              label="Método de Pago"
              name="paymentMethod"
              getId={false}
              options={[
                { value: "cash", label: "Efectivo" },
                { value: "card", label: "Tarjeta" },
              ]}
              error={errors.paymentMethod}
              setValue={setValue}
            />
          </div>

          {/* Productos y Cantidades */}
          {fields.map((field, index) => (
            <div key={field.id} className="flex items-center space-x-4">
              <CustomSelect
                label="Producto"
                name={`saleDetails.${index}.productId`}
                options={products}
                error={errors.saleDetails?.[index]?.productId}
                setValue={setValue}
              />
              <CustomInput
                label="Cantidad"
                name={`saleDetails.${index}.quantity`}
                register={register}
                error={errors.saleDetails?.[index]?.quantity}
                type="number"
              />
              {index > 0 && (
                <Button
                  variant="destructive"
                  type="button"
                  onClick={() => remove(index)}
                >
                  <IoTrash />
                </Button>
              )}
            </div>
          ))}

          {/* Botón para agregar más productos */}
          <Button
            type="button"
            onClick={() => append({ productId: 0, quantity: 1 })}
          >
            Agregar Producto
          </Button>

          {/* Total Calculado */}
          <div className="text-xl font-semibold">
            Total: ${total.toFixed(2)}
          </div>

          {/* Botón para guardar */}
          <Button type="submit" className="w-full">
            Guardar Venta
          </Button>
        </form>
      </DialogContent>
    </Dialog>
  );
}
