package com.ias.calculator.api.api.repositories;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.ias.calculator.api.api.entities.ReportEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ReportRepositoryTest {

    @Autowired
    private ReportRepository reportRepository;



    @Test
    void testFindByTechnical() {
       List<ReportEntity> reports = this.reportRepository.findByTechnical(1L);
       assertEquals(3, reports.size());
    }
}
