package com.ias.calculator.api.api.business;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReportServiceImpTest {

	@Autowired
	private ReportServiceImp reportServiceImp;


       
    @Test
	void contextLoads() {
		
	}

    @Test
    void testCalculator() {
     assertAll(
		 () -> assertEquals(80, this.reportServiceImp.extractInf(1L,"48"))
	 );
    }
}
