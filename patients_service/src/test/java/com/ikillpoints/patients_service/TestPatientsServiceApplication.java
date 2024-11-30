package com.ikillpoints.patients_service;

import org.springframework.boot.SpringApplication;

public class TestPatientsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(PatientsServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
