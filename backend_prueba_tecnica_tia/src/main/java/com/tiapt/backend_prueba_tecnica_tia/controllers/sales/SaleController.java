package com.tiapt.backend_prueba_tecnica_tia.controllers.sales;

import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.SaleService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public Page<SaleDTO> getSales(Pageable pageable) {
        return saleService.getAllSales(pageable);
    }

    @PostMapping
    ResponseEntity<String> registerSale(@RequestBody SaleRequestDTO saleRequestDTO) {
        saleService.createSale(saleRequestDTO);
        return ResponseEntity.ok("Venta registrada sastifactoriamente.");
    }
}
