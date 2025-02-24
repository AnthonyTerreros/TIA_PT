import { CustomInput } from "@/components/shared/CustomInput";
import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { ShopRequest } from "@/models";
import { ShopFormData, shopSchema } from "@/models/validations/shopSchema";
import { registerShop } from "@/services/shop.service";
import { zodResolver } from "@hookform/resolvers/zod";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { FaSave } from "react-icons/fa";
import { IoAdd } from "react-icons/io5";
import { toast } from "sonner";

interface DialogCreateShopProps {
  onShopAdded: VoidFunction;
}

export default function DialogCreateShop({
  onShopAdded,
}: DialogCreateShopProps) {
  const [isOpen, setIsOpen] = useState(false);

  const {
    register,
    handleSubmit,
    setValue,
    reset,
    formState: { errors },
  } = useForm<ShopFormData>({
    resolver: zodResolver(shopSchema),
    defaultValues: {
      name: "",
      address: "",
      contact: "",
      isActive: true,
      phone: "",
      openingTime: "",
      closingTime: "",
    },
  });

  const onSubmit = async (data: ShopFormData) => {
    const dataRequest = data as ShopRequest;
    try {
      const responseApi = await registerShop(dataRequest);
      if (responseApi.status !== 201) {
        toast.error("Ocurrio un error. Intenta de nuevo.");
        return;
      }
      toast.success("Local Creado Sastifactoriamente.");
      reset();
      onShopAdded();
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
          Crear Local
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
            label="Direccion"
            name="address"
            register={register}
            error={errors.address}
            setValue={setValue}
          />
          <CustomInput
            label="Contacto"
            name="contact"
            register={register}
            error={errors.contact}
          />
          <CustomInput
            label="Telefono"
            name="phone"
            register={register}
            error={errors.phone}
          />
          <CustomInput
            label="Hora de Apertura"
            name="openingTime"
            register={register}
            error={errors.openingTime}
            type="time"
          />

          <CustomInput
            label="Hora de Cierre"
            name="closingTime"
            register={register}
            error={errors.closingTime}
            type="time"
          />

          <Button type="submit" className="w-full">
            <FaSave size={10} />
            Guardar Local
          </Button>
        </form>
      </DialogContent>
    </Dialog>
  );
}
