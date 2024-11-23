package com.ikillpoints.patients_service.service;

import org.springframework.stereotype.Service;

import com.ikillpoints.patients_service.dto.PatientRequest;
import com.ikillpoints.patients_service.dto.PatientResponse;
import com.ikillpoints.patients_service.models.Patient;
import com.ikillpoints.patients_service.repository.IPatientsRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreatePatientConsumer {

    private final IPatientsRepo patientsRepo;

    public PatientResponse createPatient(PatientRequest patientRequest) {
        Patient patient = Patient.builder()
                .firstName(patientRequest.firstName())
                .lastName(patientRequest.lastName())
                .age(patientRequest.age())
                .gender(patientRequest.gender())
                .address(patientRequest.address())
                .contactNumber(patientRequest.contactNumber())
                .build();
        patientsRepo.save(patient);
        log.info("Patient created successfully ");
        return new PatientResponse(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getGender(),
                patient.getAddress(),
                patient.getAge(),
                patient.getContactNumber());
    }

}
