package com.example.crud_api.services;


import com.example.crud_api.exceptions.ProductNotFound;
import com.example.crud_api.models.Product;
import com.example.crud_api.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
//    post
    public Product addProduct(Product product){
        return productRepo.save(product);
    }
//    get
    public List<Product> findAllProduct(){
        return productRepo.findAll();
    }
//    update
    public Product updateProduct(Product product){
        return productRepo.save(product);
    }
//    findById
    public Product findProductById(Long id){
        return productRepo.findById(id).orElseThrow(()-> new ProductNotFound("Product with id"+id+"was no found !"));
    }
//    delete
    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }

}
