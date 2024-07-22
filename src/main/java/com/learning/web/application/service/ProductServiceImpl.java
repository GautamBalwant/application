package com.learning.web.application.service;

import com.learning.web.application.model.Product;
import com.learning.web.application.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{

    private ProductRepo productRepo;

    public  ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }


    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id : Not found"));
        productRepo.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        productRepo.findById(product.getProductId()).orElseThrow(() -> new RuntimeException("User with id : Not found"));
        return productRepo.save(product);
    }
}
