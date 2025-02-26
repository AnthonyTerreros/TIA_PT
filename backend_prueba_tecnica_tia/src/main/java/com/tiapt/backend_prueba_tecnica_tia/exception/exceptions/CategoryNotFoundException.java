package com.tiapt.backend_prueba_tecnica_tia.exception.exceptions;

public class CategoryNotFoundException  extends   RuntimeException{
    public CategoryNotFoundException(Long id) {
        super("No se encontro la categoria." + id);
    }
}
