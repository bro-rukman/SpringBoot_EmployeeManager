package com.example.crud_api.dto;

import com.example.crud_api.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

    private Employee employee;
}
