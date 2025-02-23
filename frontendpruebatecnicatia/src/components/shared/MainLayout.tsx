import { Outlet } from "react-router-dom";
import Sidebar from "./SidebarCustom";
import Navbar from "./Navbar";
import { SidebarProvider } from "../ui/sidebar";

export default function MainLayout() {
  return (
    <SidebarProvider>
      <div className="flex min-h-screen w-full">
        <Sidebar />
        <div className="flex flex-col flex-1">
          <Navbar />
          <main className="flex-1 p-3 bg-gray-100 overflow-auto">
            <div className="w-full h-full bg-white shadow-xl">
              <Outlet />
            </div>
          </main>
        </div>
      </div>
    </SidebarProvider>
  );
}
