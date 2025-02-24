import {
  InventoryFormData,
  inventorySchema,
} from "@/models/validations/inventorySchema";
import { zodResolver } from "@hookform/resolvers/zod";
import { useEffect, useState } from "react";
import { useFieldArray, useForm } from "react-hook-form";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";

import { Button } from "@/components/ui/button";
import { IoCartOutline, IoTrash } from "react-icons/io5";
import { CustomSelect } from "@/components/shared/CustomSelect";
import { InventoryRequest, ProductFilters, SelectItem } from "@/models";
import { getProducts } from "@/services/products.service";
import { CustomInput } from "@/components/shared/CustomInput";
import { toast } from "sonner";
import { assignProductsToShop } from "@/services/shop.service";

interface DialogAssignProductsToShop {
  shopId?: number;
}

export default function DialogAssignProductsToShop({
  shopId = 1,
}: DialogAssignProductsToShop) {
  const [products, setProducts] = useState<SelectItem[]>([]);

  const [isOpen, setIsOpen] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      const dataResult = await getProducts({
        page: 0,
        pageSize: 10,
      } as ProductFilters);
      const dataMapped = dataResult.map((it: any) => {
        return {
          label: it.name,
          value: it.id,
        };
      }) as SelectItem[];
      setProducts(dataMapped);
    };

    // fetchData();
  }, []);

  const {
    register,
    handleSubmit,
    setValue,
    reset,
    control,
    formState: { errors },
  } = useForm<InventoryFormData>({
    resolver: zodResolver(inventorySchema),
    defaultValues: {
      inventory: [{ productId: 0, shopId, stock: 1 }],
    },
  });

  const { fields, append, remove } = useFieldArray({
    control,
    name: "inventory",
  });

  const onSubmit = async (data: InventoryFormData) => {
    console.log("Inventario creado:", data.inventory);
    setIsOpen(false);
    const dataRequest = data.inventory as InventoryRequest[];

    try {
      const responseApi = await assignProductsToShop(dataRequest);
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
          <IoCartOutline className="size-6" />
          Asignar
        </Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Registrar Inventario</DialogTitle>
        </DialogHeader>

        <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
          {fields.map((field, index) => (
            <div key={field.id} className="flex items-center space-x-4">
              <CustomSelect
                label="Producto"
                name={`inventory.${index}.productId`}
                options={products}
                error={errors.inventory?.[index]?.productId}
                setValue={setValue}
              />
              <CustomInput
                label="Stock"
                name={`inventory.${index}.stock`}
                register={register}
                error={errors.inventory?.[index]?.stock}
                type="number"
              />
              {index > 0 && (
                <Button
                  variant="destructive"
                  type="button"
                  onClick={() => remove(index)}
                >
                  <IoTrash className="size-6" />
                </Button>
              )}
            </div>
          ))}

          <Button
            type="button"
            onClick={() => append({ productId: 0, shopId, stock: 1 })}
          >
            Agregar otra fila
          </Button>

          <Button type="submit" className="w-full">
            Guardar Inventario
          </Button>
        </form>
      </DialogContent>
    </Dialog>
  );
}
