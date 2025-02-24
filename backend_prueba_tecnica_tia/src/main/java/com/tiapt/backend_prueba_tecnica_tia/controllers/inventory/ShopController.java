package com.tiapt.backend_prueba_tecnica_tia.controllers.inventory;

import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.InventoryService;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.ShopService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public List<ShopDTO> getIndexShops() {
        return shopService.getShops();
    }

    @PostMapping
    public ResponseEntity<ShopDTO> registerShop(@RequestBody ShopRequestDTO shopRequestDTO) {
        ShopDTO shopDTO = shopService.createShop(shopRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(shopDTO);
    }

    @PostMapping("/assign-products-to-shop")
    ResponseEntity<String> assignProductToShop(@RequestBody ShopAssignProductsRequestDTO shopAssignProductsRequestDTO) {
        inventoryService.assignProductsToShop(shopAssignProductsRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Productos asignados al local exitosamente.");
    }
}
