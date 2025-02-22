package com.tiapt.backend_prueba_tecnica_tia.controllers.inventory;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ProductEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/products")
public class ProductController {

    @GetMapping("/")
    public List<ProductEntity> getAllProducts() {
        return List.of(ProductEntity.builder().build());
    }
}
