package com.damiandev.microappproducts.controller;

import org.damiandev.api.ProductsApi;
import org.damiandev.model.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProductsController implements ProductsApi {
    @Override
    public ResponseEntity<Void> createProduct(ProductDTO productDTO) {
        return ProductsApi.super.createProduct(productDTO);
    }

    @Override
    public ResponseEntity<Void> deleteProductById(String productId) {
        return ProductsApi.super.deleteProductById(productId);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ProductsApi.super.getAllProducts();
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(String productId) {
        return ProductsApi.super.getProductById(productId);
    }

    @Override
    public ResponseEntity<Void> updateProduct(ProductDTO productDTO) {
        return ProductsApi.super.updateProduct(productDTO);
    }
}
