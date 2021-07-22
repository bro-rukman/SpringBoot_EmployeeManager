package com.example.crud_api.repos;

import com.example.crud_api.models.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LayananRepo extends JpaRepository<Layanan, Long> {
}
