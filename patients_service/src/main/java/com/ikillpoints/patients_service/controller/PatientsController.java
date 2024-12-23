package com.ikillpoints.patients_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ikillpoints.patients_service.dto.PatientRequest;
import com.ikillpoints.patients_service.dto.PatientResponse;
import com.ikillpoints.patients_service.service.CreatePatientConsumer;
import com.ikillpoints.patients_service.service.GetAllPatientsConsumer;
import com.ikillpoints.patients_service.service.GetPatientByIdConsumer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientsController {

    private final CreatePatientConsumer createPatientConsumer;
    private final GetAllPatientsConsumer getAllPatientsConsumer;
    private final GetPatientByIdConsumer getPatientByIdConsumer;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String welcomeMessage() {
        return "Welcome to patient microservice";
    }

    @PostMapping("/create-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientResponse createPatient(@RequestBody PatientRequest patientRequest) {
        return createPatientConsumer.createPatient(patientRequest);
    }

    @GetMapping("/get-all-patients")
    @ResponseStatus(HttpStatus.OK)
    public List<PatientResponse> getAllPatients() {
        return getAllPatientsConsumer.getAllPatients();
    }

    @GetMapping("/get-patient-by-id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PatientResponse> getPatientById(@RequestParam String patientId) {
        return getPatientByIdConsumer.GetPatientById(patientId);
    }

    
}
