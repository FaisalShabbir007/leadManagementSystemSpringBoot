package com.example.leadmanagementsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Leads API", version = "1.0", description = "API for managing leads"))
public class LeadManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeadManagementSystemApplication.class, args);
    }

}
