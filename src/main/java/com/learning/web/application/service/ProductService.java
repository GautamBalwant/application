package com.learning.web.application.service;

import com.learning.web.application.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);
    Product getProduct(Long id);
    List<Product> getProducts();
    void deleteProduct(Long id);
    Product updateProduct(Product product);
}
