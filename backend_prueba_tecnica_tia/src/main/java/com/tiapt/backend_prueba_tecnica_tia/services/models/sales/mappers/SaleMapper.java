package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.mappers;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.SaleEntity;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers.ShopMapper;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleRequestDTO;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ShopMapper.class, User.class})
public interface SaleMapper {

    SaleDTO toDto(SaleEntity saleEntity);


    SaleEntity toEntity(SaleRequestDTO saleRequestDTO);
}