import { createBrowserRouter } from "react-router-dom";
import LoginPage from "../modules/auth/pages/LoginPage";
import MainLayout from "../components/shared/MainLayout";
import ProductPage from "../modules/inventory/pages/ProductPage";
import ShopPage from "../modules/inventory/pages/ShopPage";
import SalePage from "../modules/sales/pages/SalePage";

const router = createBrowserRouter([
  { path: "login", element: <LoginPage /> },
  {
    path: "/dashboard",
    element: <MainLayout />,
    children: [
      { path: "products", element: <ProductPage /> },
      { path: "shops", element: <ShopPage /> },
      { path: "sales", element: <SalePage /> },
    ],
  },
]);

export default router;
