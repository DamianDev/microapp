package com.damiandev.microappproducts.service.impl;

import com.damiandev.microappproducts.repository.ProductsRepository;
import com.damiandev.microappproducts.service.ProductsService;
import org.damiandev.model.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    // TODO Add MapStruct
    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
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
    public void createProduct(ProductDTO productDTO) {

    }

    @Override
    public void updateProduct(ProductDTO productDTO) {

    }

    @Override
    public void deleteProductById(String id) {

    }
}
