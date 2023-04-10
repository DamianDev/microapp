package com.damiandev.microappproducts.service.impl;

import com.damiandev.microappproducts.service.ProductsService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.damiandev.model.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    public ProductsServiceImpl() {

    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public ProductDTO getProductByID(String id) {
        return null;
    }

    @Override
    public void addProduct(ProductDTO productDTO) {

    }

    @Override
    public void updateProduct(ProductDTO productDTO) {

    }

    @Override
    public void deleteProductById(String id) {

    }
}
