package com.tiapt.backend_prueba_tecnica_tia.exception.exceptions;

public class ShopNotFoundException extends RuntimeException{
    public ShopNotFoundException(Long id) {
        super("Shop con ID " + id + " no encontrado.");
    }

}
