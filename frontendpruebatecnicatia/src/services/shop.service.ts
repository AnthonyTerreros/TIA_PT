import apiClient from "@/api/apiClient";
import { ShopAssignProductRequest, ShopFilters, ShopRequest } from "@/models";

export const getShops = async (data: ShopFilters) => {
  const result = await apiClient.get("/shops", { data });
  return result.data;
};

export const registerShops = async (data: ShopRequest) => {
  const result = await apiClient.post("/shops", data);
  return result;
};

export const assignProductsToShop = async (data: ShopAssignProductRequest) => {
  const result = await apiClient.post("/shops", data);
  return result;
};
