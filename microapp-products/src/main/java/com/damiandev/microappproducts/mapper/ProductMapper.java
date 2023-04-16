package com.damiandev.microappproducts.mapper;

import com.damiandev.microappproducts.model.Product;
import org.damiandev.model.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product dtoToEntity(ProductDTO dto);
    ProductDTO entityToDto(Product entity);
}
