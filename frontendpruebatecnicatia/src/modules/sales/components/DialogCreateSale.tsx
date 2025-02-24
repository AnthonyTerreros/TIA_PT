import { useState, useEffect, useMemo } from "react";
import { useForm, useFieldArray, useWatch } from "react-hook-form";
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
import { ProductOption, SaleRequest, Shop, ShopOption } from "@/models";
import {
  getProductsAll,
  getProductsByShopId,
} from "@/services/products.service";
import { getShopsAll } from "@/services/shop.service";
import { toast } from "sonner";
import { registerSale } from "@/services/sales.service";
import { productMapper, shopMapper } from "@/utils/mappers";
import { FaSave } from "react-icons/fa";

interface DialogCreateSale {
  onSaleAdded: VoidFunction;
}

export default function DialogCreateSale({ onSaleAdded }: DialogCreateSale) {
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

  const saleDetails = useWatch({ control, name: "saleDetails" });

  const total = useMemo(() => {
    return saleDetails.reduce((acc, item) => {
      const product = products.find((p) => p.value === item.productId);
      return acc + (product ? product.price * item.quantity : 0);
    }, 0);
  }, [saleDetails, products]);

  const fetchData = async () => {
    const [dataProductsResult, dataShopsResult] = await Promise.all([
      getProductsAll(),
      getShopsAll(),
    ]);
    const optionsProducts = productMapper(dataProductsResult);
    const optionsShops = shopMapper(dataShopsResult);
    setProducts(optionsProducts);
    setShops(optionsShops);
  };

  const shopId = watch("shopId");

  const fetchProductsByShopId = async (shopId: number) => {
    try {
      const dataResponse = await getProductsByShopId(shopId);
      if (dataResponse.status === 404) {
        toast.info("La tienda no tiene productos registrados.");
        return;
      }
      const optionsProducts = productMapper(dataResponse.data);
      setProducts(optionsProducts);
    } catch (error: any) {
      toast.error("Ocurrio un error. Intenta mas tarde.", error.message);
    }
  };

  useEffect(() => {
    if (shopId > 0) {
      fetchProductsByShopId(shopId);
    }
  }, [shopId]);

  useEffect(() => {
    fetchData();
  }, []);

  const onSubmit = async (data: SaleFormData) => {
    const saleData = {
      paymentMethod: data.paymentMethod,
      total,
      purchaseDate: new Date().toISOString(),
      userId: 1,
      saleDTODetails: data.saleDetails,
      shopId: data.shopId,
    } as SaleRequest;
    try {
      const responseApi = await registerSale(saleData);
      if (responseApi.status !== 201) {
        toast.error(
          `Ocurrio un error. Intenta de nuevo. \nMensaje: ${responseApi.data}`
        );
        return;
      }
      toast.success("Venta Creada Sastifactoriamente.");
      reset();
      onSaleAdded();
      setIsOpen(false);
    } catch (ex: any) {
      toast.error(
        `Ocurrio un error. Intenta mas tarde. \nMensaje: ${ex.response.data}`
      );
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

          {errors.saleDetails?.saleDetails?.message && (
            <p className="text-red-500 text-sm">
              {errors.saleDetails?.saleDetails?.message}
            </p>
          )}

          <Button
            type="button"
            onClick={() => append({ productId: 0, quantity: 1 })}
          >
            Agregar Producto
          </Button>

          <div className="text-xl font-semibold">
            Total: ${total.toFixed(2)}
          </div>

          <Button type="submit" className="w-full">
            <FaSave size={10} />
            Guardar Venta
          </Button>
        </form>
      </DialogContent>
    </Dialog>
  );
}
