package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.SaleEntity;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    SaleDTO toDto(SaleEntity saleEntity);

    SaleEntity toEntity(SaleRequestDTO saleRequestDTO);
}
