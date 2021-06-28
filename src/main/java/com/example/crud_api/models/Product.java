package com.example.crud_api.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String product_name;
    private String description;
    private double price;

    public Product(){}
    public Product(Long id,String product_name,String description,double price){
        this.id = id;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getProduct_name(){
        return product_name;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    @Override
    public String toString(){
        return "Product{"+"id="+id+",product_name='"+product_name+'\''+",description'"+description+'\''+",price'"+price+'\''+'}';
    }

}
