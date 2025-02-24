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
import { SelectItem, ShopAssignProductRequest } from "@/models";
import { CustomInput } from "@/components/shared/CustomInput";
import { toast } from "sonner";
import { assignProductsToShop } from "@/services/shop.service";
import { FaSave } from "react-icons/fa";

interface DialogAssignProductsToShop {
  shopId?: number;
  products: SelectItem[];
}

export default function DialogAssignProductsToShop({
  shopId = 1,
  products,
}: DialogAssignProductsToShop) {
  const [isOpen, setIsOpen] = useState(false);

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
    const dataRequest = {
      inventoryRequestDTOList: data.inventory,
    } as ShopAssignProductRequest;
    try {
      const responseApi = await assignProductsToShop(dataRequest);
      if (responseApi.status !== 201) {
        toast.error("Ocurrio un error. Intenta de nuevo.");
        return;
      }
      toast.success("Productos asignados al Local Sastifactoriamente.");
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

          {errors.inventory?.inventory?.message && (
            <p className="text-red-500 text-sm">
              {errors.inventory?.inventory?.message}
            </p>
          )}

          <Button
            type="button"
            onClick={() => append({ productId: 0, shopId, stock: 1 })}
          >
            Agregar otra fila
          </Button>

          <Button type="submit" className="w-full">
            <FaSave size={10} />
            Guardar Inventario
          </Button>
        </form>
      </DialogContent>
    </Dialog>
  );
}
