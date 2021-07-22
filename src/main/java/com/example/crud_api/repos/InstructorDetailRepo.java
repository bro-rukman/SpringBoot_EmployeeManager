package com.example.crud_api.repos;

import com.example.crud_api.models.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepo extends JpaRepository<InstructorDetail, Integer> {

}
