package com.ikillpoints.patients_service.dto;

import com.ikillpoints.patients_service.models.enums.BloodGroup;

public record PatientResponse(
        String id,
        String firstName,
        String lastName,
        String gender,
        String address,
        int age,
        String contactNumber,
        String email,
        BloodGroup bloodGroup,
        String insuranceId,
        String primaryCarePhysicianId) {

}
