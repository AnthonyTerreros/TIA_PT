import apiClient from "@/api/apiClient";
import { ShopAssignProductRequest, ShopFilters, ShopRequest } from "@/models";

export const getShops = async ({ page, pageSize }: ShopFilters) => {
  const result = await apiClient.get("/shops", {
    params: { page, size: pageSize },
  });
  return result.data;
};

export const getShopsAll = async () => {
  try {
    const result = await apiClient.get("/shops/all");
    return result.data;
  } catch (ex: any) {
    return [];
  }
};

export const registerShop = async (data: ShopRequest) => {
  const result = await apiClient.post("/shops", data);
  return result;
};

export const assignProductsToShop = async (data: ShopAssignProductRequest) => {
  const result = await apiClient.post("/shops/assign-products-to-shop", data);
  return result;
};
