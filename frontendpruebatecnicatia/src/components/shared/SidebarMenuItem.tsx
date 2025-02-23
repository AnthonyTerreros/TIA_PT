import { SidebarMenuItemType } from "@/models/menu";
import { Link } from "react-router-dom";
import { SidebarMenuButton, SidebarMenuItem } from "../ui/sidebar";

export interface SidebarMenuItemsProps {
  menuItem: SidebarMenuItemType;
}

export default function SidebarMenuItemCustom({
  menuItem,
}: SidebarMenuItemsProps) {
  return (
    <>
      <SidebarMenuItem>
        <SidebarMenuButton asChild>
          <Link to={menuItem.path}>
            <menuItem.icon />
            <span>{menuItem.name}</span>
          </Link>
        </SidebarMenuButton>
      </SidebarMenuItem>
    </>
  );
}
