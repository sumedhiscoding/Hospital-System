package com.ikillpoints.patients_service.dto;

public record PatientRequest(
                String id,
                String firstName,
                String lastName,
                int age,
                String gender,
                String address,
                String contactNumber

) {

}
