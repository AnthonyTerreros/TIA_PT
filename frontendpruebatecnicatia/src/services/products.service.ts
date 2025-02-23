import apiClient from "@/api/apiClient";
import { ProductFilters, ProductRequest } from "@/models";

export const getProducts = async (data: ProductFilters) => {
  const result = await apiClient.get("/products", { data });
  return result.data;
};

export const registerProduct = async (data: ProductRequest) => {
  const result = await apiClient.post("/products", data);
  return result;
};
