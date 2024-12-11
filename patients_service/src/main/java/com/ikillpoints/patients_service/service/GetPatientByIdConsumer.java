package com.ikillpoints.patients_service.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.ikillpoints.patients_service.dto.PatientResponse;
import com.ikillpoints.patients_service.repository.IPatientsRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class GetPatientByIdConsumer {

    public final IPatientsRepo patientsRepo;

    public Optional<PatientResponse> GetPatientById(String PatientId) {

        return patientsRepo.findById(PatientId).map(patient -> new PatientResponse(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getGender(),
                patient.getAddress(),
                patient.getAge(),
                patient.getContactNumber(),
                patient.getEmail(),
                patient.getBloodGroup(),
                patient.getInsuranceId(),
                patient.getPrimaryCarePhysicianId()));

    }

}
