package com.tiapt.backend_prueba_tecnica_tia.exception.exceptions;

public class CategoryAlreadyExistsException extends RuntimeException{
    public CategoryAlreadyExistsException(String name) {
        super("La categoria" + name + "ya existe.");
    }
}
