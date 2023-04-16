package com.damiandev.microappproducts.service.impl;

import com.damiandev.microappproducts.mapper.ProductMapper;
import com.damiandev.microappproducts.repository.ProductsRepository;
import com.damiandev.microappproducts.service.ProductsService;
import org.damiandev.model.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductMapper mapper;
    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductMapper mapper, ProductsRepository productsRepository) {
        this.mapper = mapper;
        this.productsRepository = productsRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productsRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @Override
    public ProductDTO getProductByID(String id) {
        return mapper.entityToDto(productsRepository.findById(id).orElse(null));
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productsRepository.save(mapper.dtoToEntity(productDTO));
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        productsRepository.save(mapper.dtoToEntity(productDTO));
    }

    @Override
    public void deleteProductById(String id) {
        productsRepository.deleteById(id);
    }
}
