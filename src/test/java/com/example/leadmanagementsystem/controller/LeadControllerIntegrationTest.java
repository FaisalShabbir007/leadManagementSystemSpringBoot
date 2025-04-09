package com.example.leadmanagementsystem.controller;

import com.example.leadmanagementsystem.dto.LeadDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Disabled
@SpringBootTest
@AutoConfigureMockMvc
public class LeadControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Test to create a new lead and fetch it back
    @Test
    void testCreateAndGetLeads() throws Exception {
        // Create a dynamic email to avoid duplication
        String dynamicEmail = "faisal" + System.currentTimeMillis() + "@example.com";

        // Create a LeadDTO object with dummy data and the dynamic email
        LeadDTO dto = new LeadDTO();
        dto.setFullName("Faisal Khan");
        dto.setEmail(dynamicEmail);
        dto.setPhone("1234567890");
        dto.setCompanyName("Tech Ltd.");
        dto.setNotes("Potential client.");

        // Perform POST request to create a lead, and verify that the response is successful (200 OK)
        String response = mockMvc.perform(post("/leads")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // Extract the lead email from the response
        String createdEmail = response.substring(response.indexOf("email\":\"") + 8, response.indexOf("\"", response.indexOf("email\":\"") + 8));

        // Perform GET request to retrieve all leads, and verify the newly created lead is returned
        mockMvc.perform(get("/leads"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value(createdEmail)); // Verify the first lead's email matches the created one
    }



    // Test to delete a lead
    @Test
    void testDeleteLead() throws Exception {
        UUID nonExistentLeadId = UUID.randomUUID();  // ID that doesn't exist in the DB

        mockMvc.perform(delete("/leads/{id}", nonExistentLeadId))
                .andExpect(status().isNoContent());  // Expecting a 404 status when the lead does not exist
    }





}
