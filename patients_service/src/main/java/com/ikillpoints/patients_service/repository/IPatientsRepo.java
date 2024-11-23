package com.ikillpoints.patients_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ikillpoints.patients_service.models.Patient;

public interface IPatientsRepo extends MongoRepository<Patient, String> {
    
}
