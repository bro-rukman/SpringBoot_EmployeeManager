package com.example.crud_api.models;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Vegetable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String product_code;
    private String product_name;
    private String product_description;
    private Long product_price;
    private Integer product_stock;

    public Vegetable(){}
    public Vegetable(Long id,String product_name,String product_code,String product_description,Long product_price,Integer product_stock ){
        this.id= id;
        this.product_code= product_code;
        this.product_name = product_name;
        this.product_description=product_description;
        this.product_price = product_price;
        this.product_stock = product_stock;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getProduct_code(){
        return product_code;
    }
    public void setProduct_code(String product_code){
        this.product_code= product_code;
    }
    public String getProduct_name(){
        return product_name;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }
    public String getProduct_description(){
        return product_description;
    }
    public void setProduct_description(String product_description){
        this.product_description = product_description;
    }
    public Long getProduct_price(){
        return product_price;
    }
    public void setProduct_price(Long product_price){
        this.product_price = product_price;
    }
    public Integer getProduct_stock(){
        return product_stock;
    }
    public void setProduct_stock(Integer product_stock){
        this.product_stock = product_stock;
    }

    public String toString(){
        return "Vegetables{"+"id="+id+",product_name='"+product_name+'\''+",product_code='"+product_code+'\''+",product_description'"+product_description+'\''+",product_price'"+product_price+'\''+",product_stock'"+product_stock+'\''+'}';
    }



}
