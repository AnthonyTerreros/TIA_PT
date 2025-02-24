export interface Product {
  id?: number;
  name: string;
  price: number;
  sku: string;
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
  isActive?: boolean;
  openingTime?: string;
  closingTime?: string;
}

export interface User {
  id?: number;
  firstName: string;
  phone: string;
  email: string;
  home_address: string;
  DNI: string;
}

export interface Inventory {
  productId: number;
  shopId: number;
  stock: number;
}

export interface Sale {
  id?: number;
  userId: number;
  user?: User;
  shopId: number;
  shop?: Shop;
  saleDetails: SaleDetail[];
  paymentMethod: string;
  total: number;
  purchaseDate: string;
}

export interface SaleDetail {
  id?: number;
  productId: number;
  saleId?: number;
  quantity: number;
}

export interface ProductRequest extends Omit<Product, "id"> {}

export interface ShopRequest extends Omit<Shop, "id"> {}

export interface SaleRequest extends Omit<Sale, "id"> {}

export interface InventoryRequest
  extends Omit<Inventory, "id" | "shop" | "user"> {}

export interface Pageable {
  page: number;
  pageSize: number;
  totalPages: number;
}

export interface ProductFilters extends Pageable {}

export interface ShopFilters extends Pageable {}

export interface SaleFilters extends Pageable {}

export interface ShopAssignProductRequest {}

export interface SelectItem {
  label: string;
  value: number;
}
