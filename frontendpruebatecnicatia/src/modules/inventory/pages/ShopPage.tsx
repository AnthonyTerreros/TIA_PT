import { Button } from "@/components/ui/button";
import { useEffect } from "react";
import { IoAdd } from "react-icons/io5";

export default function ShopPage() {
  useEffect(() => {}, []);

  return (
    <div className="flex flex-col gap-3 py-2 px-5">
      <section>
        <h3 className="text-[30px] font-[800]">Locales</h3>
      </section>
      <section>
        <Button>
          <IoAdd className="size-6" />
          Agregar Local
        </Button>
      </section>
      <section></section>
    </div>
  );
}
