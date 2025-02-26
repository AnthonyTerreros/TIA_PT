package com.tiapt.backend_prueba_tecnica_tia.exception.exceptions;

public class ProductAlreadyExists extends RuntimeException{
    public ProductAlreadyExists(String name) {
        super("La Tienda Ya esta registrada" + name);
    }
}
