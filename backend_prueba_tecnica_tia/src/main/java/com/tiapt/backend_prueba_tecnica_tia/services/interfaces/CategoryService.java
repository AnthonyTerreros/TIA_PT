package com.tiapt.backend_prueba_tecnica_tia.services.interfaces;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.CategoryDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.CategoryRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    Page<CategoryDTO> getCategories(Pageable pageable);

    CategoryDTO createCategory(CategoryRequestDTO categoryRequestDTO);

    CategoryDTO editCategory(CategoryDTO categoryDTO);

    void deleteCategory(CategoryDTO categoryDTO);
}
