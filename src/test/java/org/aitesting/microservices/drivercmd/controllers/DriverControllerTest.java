//package org.aitesting.microservices.drivercmd.controllers;
//
//import io.restassured.RestAssured;
//import org.aitesting.microservices.drivercmd.DriverCmdApplication;
//import org.aitesting.microservices.drivercmd.domain.models.DriverDto;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static io.restassured.RestAssured.*;
//import static org.aitesting.microservices.drivercmd.configuration.TestConstants.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
//@ContextConfiguration(classes = DriverCmdApplication.class)
//@DirtiesContext
//public class DriverControllerTest {
//
//    @Before
//    public void setUp() throws Exception {
//        RestAssured.port = 8080;
//    }
//
////    @Test
////    public void createDriver() {
////        DriverDto driver = new DriverDto(FIRST_NAME, LAST_NAME, ADDRESS,
////                EMAIL, PHONE, LICENSE);
////
////        given()
////                .contentType("application/json")
////                .body(driver)
////        .when()
////                .post("/api/v1/driver")
////        .then()
////                .statusCode(201);
////
////    }
//
////    @Test
////    public void deleteDriver() {
////        DriverDto driver = new DriverDto(FIRST_NAME, LAST_NAME, ADDRESS,
////                EMAIL, PHONE, LICENSE);
////
////        given()
////                .contentType("application/json")
////                .body(driver)
////        .when()
////                .post("/api/v1/driver");
////
////        given()
////        .when()
////                .delete("/api/v1/")
////
////    }
//
//}
