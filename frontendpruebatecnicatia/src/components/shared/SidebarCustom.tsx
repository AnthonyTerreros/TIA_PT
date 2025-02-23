import { SidebarMenuItemType } from "@/models/menu";
import { menuItems } from "@/constants/menu";
import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarGroupLabel,
  SidebarHeader,
  SidebarMenu,
} from "@/components/ui/sidebar";
import SidebarMenuItemCustom from "./SidebarMenuItem";

import logo from "@/assets/logo.png";

export default function SidebarCustom() {
  return (
    <div>
      <Sidebar className="bg-sidebarColor">
        <SidebarHeader>
          <img src={logo} alt="Logo" className="size-32 mx-auto" />
        </SidebarHeader>
        <SidebarContent>
          <SidebarGroup>
            <SidebarGroupLabel>Transacciones</SidebarGroupLabel>
            <SidebarGroupContent>
              <SidebarMenu>
                {menuItems.map((it: SidebarMenuItemType) => {
                  return <SidebarMenuItemCustom key={it.name} menuItem={it} />;
                })}
              </SidebarMenu>
            </SidebarGroupContent>
          </SidebarGroup>
        </SidebarContent>
      </Sidebar>
    </div>
  );
}
