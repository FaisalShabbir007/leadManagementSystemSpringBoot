package com.example.leadmanagementsystem.service;

import com.example.leadmanagementsystem.dto.LeadDTO;
import com.example.leadmanagementsystem.entity.Lead;
import com.example.leadmanagementsystem.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

 // Service for lead-related business logic.
@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

     // Creates a new lead.
    public Lead createLead(LeadDTO dto) {
        Lead lead = Lead.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .companyName(dto.getCompanyName())
                .notes(dto.getNotes())
                .build();
        return leadRepository.save(lead);
    }


    // Retrieves all leads.
    public Iterable<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    // Deletes a lead by ID.
    public void deleteLead(UUID id) {
        leadRepository.deleteById(id);
    }
}
