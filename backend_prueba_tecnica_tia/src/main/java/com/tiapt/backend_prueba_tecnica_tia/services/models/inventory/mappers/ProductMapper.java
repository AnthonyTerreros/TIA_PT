package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers;

import org.mapstruct.Mapper;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ProductEntity;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductRequestDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(ProductEntity productEntity);

    ProductEntity toEntity(ProductRequestDTO productRequestDTO);

}