package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.CategoryAlreadyExistsException;
import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.CategoryNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.CategoryEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.CategoryRepository;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.CategoryService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.CategoryDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.CategoryRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<CategoryDTO> getCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapper::toDto);
    }

    @Override
    public CategoryDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        Optional<CategoryEntity> categoryEntityExits = categoryRepository.findByName(categoryRequestDTO.getName());
        if(categoryEntityExits.isPresent()) {
            throw new CategoryAlreadyExistsException(categoryEntityExits.get().getName());
        }
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryRequestDTO);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryMapper.toDto(categoryEntity);
    }

    @Override
    public CategoryDTO editCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryDTO.getId()).orElseThrow(() -> new CategoryNotFoundException(categoryDTO.getId()));

        Optional<CategoryEntity> categoryEntityExists = categoryRepository.findByName(categoryDTO.getName());

        if(categoryEntityExists.isPresent() && !categoryEntityExists.get().getId().equals(categoryDTO.getId())) {
            throw new CategoryAlreadyExistsException(categoryDTO.getName());
        }

        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setDescription(categoryDTO.getDescription());
        categoryRepository.save(categoryEntity);

        return categoryMapper.toDto(categoryEntity);
    }

    @Override
    public void deleteCategory(CategoryDTO categoryDTO) {
        categoryRepository.deleteById(categoryDTO.getId());
    }
}
