package com.example.leadmanagementsystem.controller;
import com.example.leadmanagementsystem.dto.LeadDTO;
import com.example.leadmanagementsystem.entity.Lead;
import com.example.leadmanagementsystem.service.LeadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


 // Controller to manage leads via HTTP requests.
@RestController
@RequestMapping("/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;


     // Creates a new lead
    @PostMapping
    public ResponseEntity<Lead> createLead(@Valid @RequestBody LeadDTO dto) {
        Lead lead = leadService.createLead(dto);
        return ResponseEntity.ok(lead);
    }


     //Gets all leads
    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        return ResponseEntity.ok((List<Lead>) leadService.getAllLeads());
    }


    // Deletes a lead by ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable UUID id) {
      Optional<Lead> lead =  leadRepository.findById(id);

        if (lead.isEmpty()) {
            // Throw ResourceNotFoundException if lead does not exist
            throw new EntityNotFoundException("Lead not found with id " + id);
        }

        // Delete the lead
        leadService.deleteLead(id);

        // Successfully deleted, returning 204 No Content with no body
        return ResponseEntity.noContent().build();
    }
}
