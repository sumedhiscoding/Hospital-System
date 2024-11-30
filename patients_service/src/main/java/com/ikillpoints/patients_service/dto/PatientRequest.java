package com.ikillpoints.patients_service.dto;

import com.ikillpoints.patients_service.models.enums.BloodGroup;

public record PatientRequest(
                String patientId,
                String firstName,
                String lastName,
                int age,
                String gender,
                String address,
                String contactNumber,
                String email,
                BloodGroup bloodGroup,
                String insuranceId,
                String primaryCarePhysicianId
) {

}
