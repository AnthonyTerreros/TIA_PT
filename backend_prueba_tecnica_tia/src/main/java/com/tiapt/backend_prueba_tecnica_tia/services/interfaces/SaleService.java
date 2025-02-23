package com.tiapt.backend_prueba_tecnica_tia.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleRequestDTO;

public interface SaleService {
    Page<SaleDTO> getAllSales(Pageable pageable);

    SaleDTO createSale(SaleRequestDTO saleRequestDTO);
}