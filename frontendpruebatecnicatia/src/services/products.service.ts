import apiClient from "@/api/apiClient";
import { ProductFilters, ProductRequest } from "@/models";

export const getProducts = async ({ page, pageSize }: ProductFilters) => {
  const result = await apiClient.get("/products", {
    params: { page: page, size: pageSize },
  });
  return result.data;
};

export const getProductsByShopId = async (shopId: number) => {
  const result = await apiClient.get(`/products/shop/${shopId}`);
  return result;
};

export const getProductsAll = async () => {
  try {
    const result = await apiClient.get("/products/all");
    return result.data;
  } catch (ex: any) {
    return [];
  }
};

export const registerProduct = async (data: ProductRequest) => {
  const result = await apiClient.post("/products", data);
  return result;
};
