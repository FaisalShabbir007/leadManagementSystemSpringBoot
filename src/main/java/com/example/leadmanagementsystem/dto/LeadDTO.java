package com.example.leadmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LeadDTO {

    // This field represents the full name of the lead and must not be blank.
    @NotBlank(message = "Full name is required")
    private String fullName;

    // This field represents the email of the lead, it must be a valid email format and cannot be blank.
    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    private String phone;
    private String companyName;
    private String notes;
}
