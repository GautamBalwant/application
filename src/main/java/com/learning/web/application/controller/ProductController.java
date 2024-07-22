package com.learning.web.application.controller;

import com.learning.web.application.model.Product;
import com.learning.web.application.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public  ProductController(ProductService service){
        this.productService=service;
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProduct(id));
            }

      @PostMapping("/product/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
       return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);

      }


    @GetMapping("/products/")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
         productService.deleteProduct(id);
         return new ResponseEntity<>("record with id : " + id + " deleted",HttpStatus.OK);
    }

    @PutMapping("/product/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){

        return ResponseEntity.ok(productService.updateProduct(product));
    }

}
