package com.damiandev.microappproducts.service;

import org.damiandev.model.ProductDTO;

import java.util.List;

public interface ProductsService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductByID(String id);
    void createProduct(ProductDTO productDTO);
    void updateProduct(ProductDTO productDTO);
    void deleteProductById(String id);
}
