package main.java.com.tiapt.backend_prueba_tecnica_tia.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleRequestDTO;

public interface SaleService {
    Page<SaleDTO> getAllSales(Pageable pageable);

    void createSale(SaleRequestDTO saleRequestDTO);
}