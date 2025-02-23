export interface Product {
  id?: number;
  name: string;
  price: number;
  SKU: string;
  category: string;
  description?: string;
  state: number;
}

export interface Shop {
  id?: number;
  name: string;
  address: string;
  contact: string;
  phone: string;
  isActive: boolean;
  openingTime?: string;
  closingTime?: string;
}

export interface Sale {
  id?: number;
  userId: number;
  shopId: number;
  saleDetails: SaleDetail[];
  paymentMethod: string;
  total: number;
  purchaseDate: string;
}

export interface Inventory {
  productId: number;
  shopId: number;
  stock: number;
}

export interface SaleDetail {
  id?: number;
  productId: number;
  saleId: number;
  quantity: number;
}

export interface ProductRequest extends Omit<Product, "id"> {}

export interface ShopRequest extends Omit<Shop, "id"> {}

export interface SaleRequest extends Omit<Sale, "id"> {}

export interface InventoryRequest extends Omit<Inventory, "id"> {}

export interface Pageable {
  page: number;
  pageSize: number;
}

export interface ProductFilters extends Pageable {}

export interface ShopFilters extends Pageable {}

export interface SaleFilters extends Pageable {}

export interface ShopAssignProductRequest {}
