import {
  ProductFormData,
  productSchema,
} from "@/models/validations/productSchema";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { useState } from "react";
import { CustomInput } from "@/components/shared/CustomInput";
import { FaSave } from "react-icons/fa";

import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import { IoAdd } from "react-icons/io5";
import { registerProduct } from "@/services/products.service";
import { ProductRequest } from "@/models";
import { toast } from "sonner";

interface DialogRegisterProductProps {
  onProductAdded: VoidFunction;
}

export default function DialogRegisterProduct({
  onProductAdded,
}: DialogRegisterProductProps) {
  const [isOpen, setIsOpen] = useState(false);

  const {
    register,
    handleSubmit,
    setValue,
    reset,
    formState: { errors },
  } = useForm<ProductFormData>({
    resolver: zodResolver(productSchema),
    defaultValues: {
      name: "",
      price: 0,
      sku: "",
      category: "",
      description: "",
      state: 1,
    },
  });

  const onSubmit = async (data: ProductFormData) => {
    console.log("Producto creado:", data);
    const dataRequest = {
      ...data,
      price: Number(data.price),
    } as ProductRequest;

    try {
      const responseApi = await registerProduct(dataRequest);
      if (responseApi.status !== 201) {
        toast.error("Ocurrio un error. Intenta de nuevo");
        return;
      }
      toast.success("Producto Creado Sastifactoriamente.");
      reset();
      onProductAdded();
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
          Crear Producto
        </Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Registrar Producto</DialogTitle>
        </DialogHeader>

        <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
          <CustomInput
            label="Nombre"
            name="name"
            register={register}
            error={errors.name}
          />
          <CustomInput
            label="Precio"
            name="price"
            register={register}
            error={errors.price}
            setValue={setValue}
            type="number"
          />
          <CustomInput
            label="SKU"
            name="sku"
            register={register}
            error={errors.sku}
          />
          <CustomInput
            label="Categoria"
            name="category"
            register={register}
            error={errors.category}
          />
          <CustomInput
            label="Descripción"
            name="description"
            register={register}
            error={errors.description}
          />

          <Button type="submit" className="w-full">
            <FaSave size={10} />
            Guardar Producto
          </Button>
        </form>
      </DialogContent>
    </Dialog>
  );
}
