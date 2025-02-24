import { Product, ProductOption, Shop, ShopOption } from "@/models";

export const productMapper = (data: Product[]): ProductOption[] => {
  return data.map((it: Product) => {
    return {
      value: it.id || -1,
      label: it.name,
      price: it.price,
    };
  });
};

export const shopMapper = (data: Shop[]): ShopOption[] => {
  return data.map((it: Shop) => {
    return {
      value: it.id || -1,
      label: it.name,
    };
  });
};
