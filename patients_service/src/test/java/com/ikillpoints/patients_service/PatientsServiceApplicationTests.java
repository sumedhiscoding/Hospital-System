package com.ikillpoints.patients_service;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;


import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientsServiceApplicationTests {
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mongoDBContainer.start();
	}

	@Test
	void shouldCreatePatient() {
		String requestBody = """
				{
					"firstName":"Sumedh",
					"lastName":"Gavai",
					"age":21,
					"gender":"Male",
					"address":"Mumbai",
					"contactNumber":"8356838551"
				}
				""";
		RestAssured.given()
		.contentType("application/json")
		.body(requestBody)
		.when()
		.post("/api/patient/create-patient")
		.then()
		.statusCode(201)
		.body("id", Matchers.notNullValue())
		.body("firstName", Matchers.equalTo("Sumedh"))
		.body("lastName", Matchers.equalTo("Gavai"))
		.body("age", Matchers.equalTo(21))
		.body("gender", Matchers.equalTo("Male"))
		.body("address", Matchers.equalTo("Mumbai"))	
		.body("contactNumber", Matchers.equalTo("8356838551"));		
	}

}
