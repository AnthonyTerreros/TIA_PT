import { SidebarMenuItemType } from "@/models/menu";
import { CiShop } from "react-icons/ci";
import { FaBasketShopping } from "react-icons/fa6";
import { MdPointOfSale } from "react-icons/md";

export const menuItems: SidebarMenuItemType[] = [
  { path: "/dashboard/products", icon: CiShop, name: "Productos" },
  { path: "/dashboard/shops", icon: FaBasketShopping, name: "Locales" },
  { path: "/dashboard/sales", icon: MdPointOfSale, name: "Ventas" },
];
