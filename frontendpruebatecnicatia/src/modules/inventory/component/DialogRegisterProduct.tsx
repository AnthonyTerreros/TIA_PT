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

export default function DialogRegisterProduct() {
  const [isOpen, setIsOpen] = useState(false);

  const {
    register,
    handleSubmit,
    setValue,
    formState: { errors },
  } = useForm<ProductFormData>({
    resolver: zodResolver(productSchema),
    defaultValues: {
      name: "",
      price: 0,
      SKU: "",
      category: "",
      description: "",
      state: 1,
    },
  });

  const onSubmit = (data: ProductFormData) => {
    console.log("Producto creado:", data);
    setIsOpen(false);
  };

  return (
    <Dialog open={isOpen} onOpenChange={setIsOpen}>
      <DialogTrigger asChild>
        <Button variant="outline">Crear Producto</Button>
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
            type="number"
          />
          <CustomInput
            label="SKU"
            name="SKU"
            register={register}
            error={errors.SKU}
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
