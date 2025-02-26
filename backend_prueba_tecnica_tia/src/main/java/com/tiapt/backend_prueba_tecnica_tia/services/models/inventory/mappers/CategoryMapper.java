package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.CategoryEntity;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.CategoryDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.CategoryRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDto(CategoryEntity categoryEntity);

    CategoryEntity toEntity(CategoryRequestDTO categoryRequestDTO);
}
