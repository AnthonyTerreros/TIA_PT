import { useState } from "react";

export const usePagination = () => {
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(1);
  const pageSize = 10;

  const handlePrevPage = () => {
    if (page > 0) setPage(page - 1);
  };

  const handleNextPage = () => {
    if (page < totalPages - 1) setPage(page + 1);
  };

  return {
    page,
    pageSize,
    totalPages,
    handleNextPage,
    handlePrevPage,
    setTotalPages,
    setPage,
  };
};
