package com.example.crud_api.repos;

import com.example.crud_api.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository <Instructor, Integer> {

}
