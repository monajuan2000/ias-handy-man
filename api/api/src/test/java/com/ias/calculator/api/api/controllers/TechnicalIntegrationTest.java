package com.ias.calculator.api.api.controllers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import com.ias.calculator.api.api.entities.TechnicalEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TechnicalIntegrationTest {

    @Autowired
    private TestRestTemplate client;

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUpp() {

    }

    private String configurationUri(String uri) {
        return "http://localhost:" + this.port + uri;
    }

    @Test
    @Order(1)
    void testSave() {
        TechnicalEntity technicalEntity = new TechnicalEntity();
        technicalEntity.setCc("23456789");
        technicalEntity.setName("Alejandra alzate");
        ResponseEntity<TechnicalEntity> response = client.postForEntity(this.configurationUri("/api/v1/technical/save"),
                technicalEntity, TechnicalEntity.class);
        TechnicalEntity technicalEntityTest = response.getBody();
        assertAll(() -> assertEquals(HttpStatus.CREATED, response.getStatusCode().CREATED),
                () -> assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType()),

                () -> {

                    assertEquals("Alejandra alzate", technicalEntityTest.getName());
                }, () -> assertEquals(6L, technicalEntityTest.getId())

        );
    }

    @Test
    @Order(2)
    void testFindAll() {
        ResponseEntity<TechnicalEntity[]> response = client
                .getForEntity(this.configurationUri("/api/v1/technical/find-all"), TechnicalEntity[].class);
        List<TechnicalEntity> technicians = Arrays.asList(response.getBody());
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType()),
                () -> assertEquals("Santiago", technicians.get(0).getName()),
                () -> assertEquals(1L, technicians.get(0).getId()),
                () -> assertEquals("1000406213", technicians.get(0).getCc()),
                () -> assertEquals(6, technicians.size()));
    }

    @Test
    @Order(3)
    void testUpdate() {
        TechnicalEntity technicalEntity = new TechnicalEntity();
        technicalEntity.setCc("23456789");
        technicalEntity.setId(6L);
        technicalEntity.setName("Juan Esteban Mona bermudez");
        ResponseEntity<TechnicalEntity> response = client.postForEntity(this.configurationUri("/api/v1/technical/save"),
                technicalEntity, TechnicalEntity.class);
        TechnicalEntity technicalEntityTest = response.getBody();
        assertAll(() -> assertEquals(HttpStatus.CREATED, response.getStatusCode().CREATED),
                () -> assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType()),

                () -> {

                    assertEquals("Juan Esteban Mona bermudez", technicalEntityTest.getName());
                }, () -> assertEquals(6L, technicalEntityTest.getId())

        );
    }

    @Test
    @Order(4)
    void testDelete() {
        assertAll(() -> {
            ResponseEntity<TechnicalEntity[]> response = client
                    .getForEntity(this.configurationUri("/api/v1/technical/find-all"), TechnicalEntity[].class);
            List<TechnicalEntity> technicians = Arrays.asList(response.getBody());
            assertEquals(6, technicians.size());
        }, () -> {
            client.delete("/api/v1/technical/delete/6");
            ResponseEntity<TechnicalEntity[]> response = client
                    .getForEntity(this.configurationUri("/api/v1/technical/find-all"), TechnicalEntity[].class);
            List<TechnicalEntity> technicians = Arrays.asList(response.getBody());
            assertEquals(5, technicians.size());
        }, () -> {
            ResponseEntity<TechnicalEntity> response = client
                    .getForEntity(this.configurationUri("/api/v1/technical/findById/6"), TechnicalEntity.class);
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        });
    }
}
