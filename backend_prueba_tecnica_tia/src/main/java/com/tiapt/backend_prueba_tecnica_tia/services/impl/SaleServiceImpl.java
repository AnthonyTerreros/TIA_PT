package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.SaleEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.SaleRepository;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.SaleService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers.SaleMapper;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleMapper saleMapper;
    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleMapper saleMapper, SaleRepository saleRepository) {
        this.saleMapper = saleMapper;
        this.saleRepository = saleRepository;
    }


    @Override
    public Page<SaleDTO> getAllSales(Pageable pageable) {
        return saleRepository.findAll(pageable).map(saleMapper::toDto);
    }

    @Override
    public SaleDTO createSale(SaleRequestDTO saleRequestDTO) {
        SaleEntity saleEntity = saleMapper.toEntity(saleRequestDTO);
        saleEntity = saleRepository.save(saleEntity);
        return saleMapper.toDto(saleEntity);
    }
}
