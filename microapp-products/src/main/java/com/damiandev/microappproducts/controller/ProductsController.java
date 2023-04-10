package com.damiandev.microappproducts.controller;

import com.damiandev.microappproducts.service.ProductsService;
import org.damiandev.api.ProductsApi;
import org.damiandev.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController implements ProductsApi {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public ResponseEntity<Void> createProduct(ProductDTO productDTO) {
        productsService.createProduct(productDTO);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteProductById(String productId) {
        productsService.deleteProductById(productId);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(String productId) {
        return ResponseEntity.ok(productsService.getProductByID(productId));
    }

    @Override
    public ResponseEntity<Void> updateProduct(ProductDTO productDTO) {
        productsService.updateProduct(productDTO);

        return ResponseEntity.ok().build();
    }
}
