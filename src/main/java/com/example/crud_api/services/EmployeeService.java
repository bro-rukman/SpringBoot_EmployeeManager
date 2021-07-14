package com.example.crud_api.services;

import com.example.crud_api.exceptions.UserNotFoundException;
import com.example.crud_api.models.Employee;
import com.example.crud_api.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
//  post
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
//  get
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }
//  getID
    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id).orElseThrow(()->new UserNotFoundException("User by id"+ id +"was not found"));
    }
//  update
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

//  delete
    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
