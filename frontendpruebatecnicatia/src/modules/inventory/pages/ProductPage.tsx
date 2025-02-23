import { Button } from "@/components/ui/button";
import { IoAdd } from "react-icons/io5";

export default function ProductPage() {
  return (
    <div className="flex flex-col">
      <section>
        <Button >
          <IoAdd className="size-5 mr-1" />
          Agregar Producto
        </Button>
      </section>
      <section>
        
      </section>
    </div>
  );
}
