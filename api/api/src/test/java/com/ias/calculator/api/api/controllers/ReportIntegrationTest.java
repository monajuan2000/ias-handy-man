package com.ias.calculator.api.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReportIntegrationTest {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;
    
    @BeforeEach
    void setUpp(){
        objectMapper= new ObjectMapper();
    }

    @Test
    void testDelete() {

    }

    @Test
    @Order(1)
    void testFindAll() {
         
    }

    @Test
    void testFindByTechnical() {

    }

    @Test
    void testNumberOfHours() {

    }

    @Test
    void testSave() {

    }

    @Test
    void testUpdate() {

    }
}
