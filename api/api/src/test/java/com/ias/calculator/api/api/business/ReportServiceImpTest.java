package com.ias.calculator.api.api.business;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ias.calculator.api.api.services.ReportService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReportServiceImpTest {

    @Autowired
    private ReportService reportService;

    @Test
    void testNumberOfHours() { 
        assertAll(
            ()-> {assertEquals(15, reportService.numberOfHours(1L,"46"));}
        );
    }

    @Test
    void testDia() {
        assertAll(
            ()-> {assertEquals("vie.", reportService.dia());}
        );
    }
}
