import apiClient from "@/api/apiClient";
import { SaleFilters, SaleRequest } from "@/models";

export const getSales = async ({ page, pageSize }: SaleFilters) => {
  const result = await apiClient.get("/sales", {
    params: { page, size: pageSize },
  });
  return result.data;
};

export const registerSale = async (data: SaleRequest) => {
  const result = await apiClient.post("/sales", data);
  return result;
};
