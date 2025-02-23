package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.mappers;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.SaleDetailEntity;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDetailDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleDetailMapper {

    SaleDetailDTO toDto(SaleDetailEntity saleDetailEntity);

    SaleDetailEntity toEntity(SaleDetailDTO saleDetailDTO);
}
