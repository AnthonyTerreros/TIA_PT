package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ShopEntity;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    ShopDTO toDto(ShopEntity shopEntity);

    ShopEntity toEntity(ShopRequestDTO shopRequestDTO);
}