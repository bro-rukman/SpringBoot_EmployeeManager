package com.example.crud_api.repos;

import com.example.crud_api.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
