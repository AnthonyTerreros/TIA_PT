package com.tiapt.backend_prueba_tecnica_tia.controllers.inventory;

import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.InventoryService;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.ShopService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/shops")
public class ShopController {
    private final ShopService shopService;
    private  final InventoryService inventoryService;

    public ShopController(ShopService shopService, InventoryService inventoryService) {
        this.shopService = shopService;
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public Page<ShopDTO> getShops(Pageable pageable) {
        return shopService.getAllShops(pageable);
    }

    @PostMapping
    public ShopDTO registerShop(@RequestBody ShopRequestDTO shopRequestDTO) {
        return shopService.createShop(shopRequestDTO);
    }

    @PostMapping("/assign-products-to-shop")
    ResponseEntity<String> assignProductToShop(@RequestBody ShopAssignProductsRequestDTO shopAssignProductsRequestDTO) {
        inventoryService.assignProductsToShop(shopAssignProductsRequestDTO);
        return ResponseEntity.ok("Productos asignados al local exitosamente.");
    }
}
