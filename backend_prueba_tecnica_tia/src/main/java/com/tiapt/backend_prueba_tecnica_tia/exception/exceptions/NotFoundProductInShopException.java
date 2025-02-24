package com.tiapt.backend_prueba_tecnica_tia.exception.exceptions;

public class NotFoundProductInShopException extends RuntimeException {
    public NotFoundProductInShopException() {
        super("Producto no disponible en esta tienda");
    }

}
