package com.damiandev.microappproducts.repository;


import com.damiandev.microappproducts.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductsRepository extends MongoRepository<Product, String> {
}
