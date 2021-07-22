package com.example.crud_api.controllers;


import com.example.crud_api.dto.OrderRequest;
import com.example.crud_api.models.Employee;
import com.example.crud_api.repos.EmployeeRepo;
import com.example.crud_api.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private final ProductRepo productRepo;
    @Autowired
    private final EmployeeRepo employeeRepo;

    public OrderController(ProductRepo productRepo, EmployeeRepo employeeRepo) {
        this.productRepo = productRepo;
        this.employeeRepo = employeeRepo;
    }
    @PostMapping("/orders")
    public Employee placeOrder(@RequestBody OrderRequest request){
        return employeeRepo.save(request.getEmployee());
    }
    @GetMapping("/findOrders")
    public List<Employee> findAllOrders(){
        return employeeRepo.findAll();
    }
}
