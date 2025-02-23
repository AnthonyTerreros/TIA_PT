import { Outlet } from "react-router-dom";

export default function MainLayout() {
  return (
    <main className="border-2 p-3">
      <Outlet />
    </main>
  );
}
