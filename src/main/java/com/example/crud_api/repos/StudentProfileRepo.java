package com.example.crud_api.repos;

import com.example.crud_api.models.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepo extends JpaRepository<StudentProfile,Long> {
}
