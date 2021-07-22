package com.example.crud_api.controllers;

import com.example.crud_api.models.Product;
import com.example.crud_api.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.findAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product product1 = productService.addProduct(product);
        return new ResponseEntity<>(product1,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product2 = productService.updateProduct(product);
        return new ResponseEntity<>(product2,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
