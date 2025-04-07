package com.example.leadmanagementsystem.repository;

import com.example.leadmanagementsystem.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeadRepository extends JpaRepository<Lead, UUID> {
    boolean existsByEmail(String email);
}
