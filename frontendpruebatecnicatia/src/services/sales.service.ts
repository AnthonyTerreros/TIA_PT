import apiClient from "@/api/apiClient";
import { SaleFilters, SaleRequest } from "@/models";

export const getSales = async (data: SaleFilters) => {
  const result = await apiClient.get("/sales", { data });
  return result.data;
};

export const registerSale = async (data: SaleRequest) => {
  const result = await apiClient.post("/sales", data);
  return result;
};
