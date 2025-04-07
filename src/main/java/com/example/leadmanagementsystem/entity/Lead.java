package com.example.leadmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "leads")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lead {

    // Primary key for the Lead entity, generated automatically using UUID.
    @Id
    @GeneratedValue
    private UUID id;

    // Full name of the lead. The column is mandatory and cannot be null.
    @Column(name = "full_name", nullable = false)
    private String fullName;

    // Email address of the lead. This field is unique and cannot be null.
    @Column(nullable = false, unique = true)
    private String email;

    // Phone number of the lead. This field is mandatory and is optional.
    @Column
    private String phone;

    // The company name associated with the lead.
    @Column(name = "company_name")
    private String companyName;

    // Notes associated with the lead. This can hold longer text and is optional.
    @Column(columnDefinition = "TEXT")
    private String notes;

    // Timestamp indicating when the lead was created. This field is automatically filled with the creation time.
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;


}
