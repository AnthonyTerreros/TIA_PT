package com.tiapt.backend_prueba_tecnica_tia.exception.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Producto con ID " + id + " no encontrado.");
    }
}
