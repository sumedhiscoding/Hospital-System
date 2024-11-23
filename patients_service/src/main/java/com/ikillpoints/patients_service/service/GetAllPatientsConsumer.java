package com.ikillpoints.patients_service.service;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ikillpoints.patients_service.dto.PatientResponse;
import com.ikillpoints.patients_service.repository.IPatientsRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class GetAllPatientsConsumer {

    public final IPatientsRepo patientsRepo;

    public List<PatientResponse> getAllPatients() {
        // Implement logic to fetch all patients from the database
        return patientsRepo.findAll()
                .stream()
                .map(patient -> new PatientResponse(
                        patient.getId(),
                        patient.getFirstName(),
                        patient.getLastName(),
                        patient.getGender(),
                        patient.getAddress(),
                        patient.getAge(),
                        patient.getContactNumber()))
                .toList();

    }

}
