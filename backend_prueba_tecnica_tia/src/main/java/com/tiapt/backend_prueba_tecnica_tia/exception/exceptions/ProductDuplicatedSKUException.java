package com.tiapt.backend_prueba_tecnica_tia.exception.exceptions;

public class ProductDuplicatedSKUException extends RuntimeException {
    public ProductDuplicatedSKUException(Long id) {
        super("Ya existe un producto con ese SKU. Product ID: " + id);
    }

}
