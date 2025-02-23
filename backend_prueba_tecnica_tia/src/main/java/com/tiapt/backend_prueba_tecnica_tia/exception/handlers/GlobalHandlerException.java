package com.tiapt.backend_prueba_tecnica_tia.exception.handlers;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ShopNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ProductNotFoundException;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ShopNotFoundException.class)
    public ResponseEntity<String> handleShopNotFoundException(ShopNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
