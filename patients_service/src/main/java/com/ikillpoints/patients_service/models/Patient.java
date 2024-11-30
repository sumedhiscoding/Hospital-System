package com.ikillpoints.patients_service.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ikillpoints.patients_service.models.enums.BloodGroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(value = "patients")
@AllArgsConstructor
@Builder
@Data
public class Patient {
    @Id
    private String patientId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private int age;
    private String gender; // Could use enum for validation if desired
    private String contactNumber;
    private String email;
    private String address;
    private BloodGroup bloodGroup;
    private String insuranceId; // Nullable
    private String primaryCarePhysicianId; // Foreign key to Doctor collection
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
