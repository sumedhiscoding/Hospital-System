package com.ikillpoints.patients_service.dto;

public record PatientResponse(
        String id,
        String firstName,
        String lastName,
        String gender,
        String address,
        int age,
        String contactNumber) {

}
