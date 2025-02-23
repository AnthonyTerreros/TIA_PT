import { Button } from "@/components/ui/button";
import { CiLogout } from "react-icons/ci";
import {
  DropdownMenu,
  DropdownMenuTrigger,
  DropdownMenuContent,
  DropdownMenuItem,
} from "@/components/ui/dropdown-menu";

import { FaRegUser } from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import { SidebarTrigger } from "../ui/sidebar";

export default function Navbar() {
  const navigator = useNavigate();

  return (
    <>
      <nav className="h-16 flex items-center justify-between px-4 bg-white shadow">
        <SidebarTrigger />

        {/* Profile Dropdown */}
        <DropdownMenu>
          <DropdownMenuTrigger asChild>
            <Button variant="ghost" className="p-2">
              <FaRegUser className="h-6 w-6" />
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent align="end">
            <DropdownMenuItem onClick={() => navigator("/login")}>
              <CiLogout className="h-4 w-4 mr-2" />
              Logout
            </DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      </nav>
    </>
  );
}
