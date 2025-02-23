import { Button } from "@/components/ui/button";
import type { Sale } from "@/models";
import { useEffect, useState } from "react";
import { IoAdd } from "react-icons/io5";

export default function SalePage() {
  const [sales, setSales] = useState<Sale[]>([]);

  useEffect(() => {}, []);

  return (
    <div className="flex flex-col gap-3 py-2 px-5">
      <section>
        <h3 className="text-[30px] font-[800]">Ventas</h3>
      </section>
      <section>
        <Button>
          <IoAdd className="size-6" />
          Crear Venta
        </Button>
      </section>
      <section></section>
    </div>
  );
}
