package com.tiapt.backend_prueba_tecnica_tia.controllers.inventory;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ProductNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.ProductService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductRequestDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductDTO> getProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductDTO productDTO = productService.registerProduct(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }
}
