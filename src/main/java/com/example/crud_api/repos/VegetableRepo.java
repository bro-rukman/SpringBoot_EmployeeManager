package com.example.crud_api.repos;

import com.example.crud_api.models.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VegetableRepo extends JpaRepository<Vegetable,Long> {

}
