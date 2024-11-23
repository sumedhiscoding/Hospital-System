package com.ikillpoints.patients_service.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Document(value = "patients")
@AllArgsConstructor
@Builder
@Data
public class Patient {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String address;
    private String contactNumber;

}
