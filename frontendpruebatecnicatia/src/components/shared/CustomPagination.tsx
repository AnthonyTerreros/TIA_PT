import { FaArrowLeft, FaArrowRight } from "react-icons/fa6";
import { Button } from "../ui/button";

interface CustomPaginationProps {
  page: number;
  totalPages: number;
  handlePrevPage: VoidFunction;
  handleNextPage: VoidFunction;
}

export default function CustomPagination({
  page,
  totalPages,
  handleNextPage,
  handlePrevPage,
}: CustomPaginationProps) {
  return (
    <div className="flex gap-3 items-center mt-4">
      <Button onClick={handlePrevPage}>
        <FaArrowLeft />
      </Button>
      <span>
        Pagina {page + 1} de {totalPages}
      </span>
      <Button onClick={handleNextPage}>
        <FaArrowRight />
      </Button>
    </div>
  );
}
