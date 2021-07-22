package com.example.crud_api.repos;

import com.example.crud_api.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
