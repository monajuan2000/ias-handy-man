package com.ias.calculator.api.api.repositories;

import com.ias.calculator.api.api.entities.TechnicalEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TechnicalRepositoryTest {

    @Autowired
    private TechnicalRepository technicalRepository;

    @Test
    @DisplayName("Test find all")
    void findAll() {
        List<TechnicalEntity> technical = technicalRepository.findAll();
        boolean c = technical.stream().anyMatch(element -> element.getName().equals("Miguel Hernandez"));
        TechnicalEntity technical1 = technical.stream().filter(element -> element.getName()
                .equals("Laura Navarro")).findFirst().orElseThrow();
        assertAll(
                () -> assertEquals(5, technical.size()),
                () -> assertTrue(c),
                () -> assertEquals("9", technical1.getCc())
        );
    }

    @Test
    @DisplayName("Test find By id")
    void findById() {
        Optional<TechnicalEntity> technicalEntity = technicalRepository.findById(1L);
        assertAll(
                () -> assertTrue(technicalEntity.isPresent()),
                () -> assertEquals("Juan Esteban Mona", technicalEntity.orElseThrow().getName()),
                () -> assertEquals("1", technicalEntity.orElseThrow().getCc())
        );
    }

    @Test
    @DisplayName("Test save")
    void create() {
        TechnicalEntity technical = new TechnicalEntity();
        technical.setCc("9999");
        technical.setName("Mariana");
        technicalRepository.save(technical);
        List<TechnicalEntity> technicalAll = technicalRepository.findAll();
        assertAll(
                () -> assertEquals(6, technicalAll.size()),
                () -> assertEquals(6L, technical.getId())
        );
    }

    @Test
    @DisplayName("Test update")
    void update() {
        TechnicalEntity technicalEntity = technicalRepository.findById(1L).orElseThrow();
        technicalEntity.setCc("4562");
        technicalEntity.setName("Sofia");
        technicalRepository.save(technicalEntity);
        assertAll(
                () -> assertEquals("Sofia", technicalRepository.findById(1L).orElseThrow().getName()),
                () -> assertEquals("4562", technicalRepository.findById(1L).orElseThrow().getCc())
        );
    }
}

