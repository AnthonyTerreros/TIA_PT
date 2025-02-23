package com.tiapt.backend_prueba_tecnica_tia.exception.exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(Long id) {
        super("No hay stock del Producto con ID " + id);
    }

}
