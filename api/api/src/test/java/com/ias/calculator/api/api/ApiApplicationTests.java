package com.ias.calculator.api.api;

import com.ias.calculator.api.api.models.Report;
import com.ias.calculator.api.api.models.Technical;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {



	@Test
	void contextLoads() {
		Technical technical = new Technical();
		technical.setId(1l);
		technical.setCc("1000406213");
		technical.setName("Juan esteban");
		System.out.println(technical.toString());

		Report report = new Report();
		report.setId(1L);
		report.setOrder(23456);
		report.setDate("12-11-2021");
		report.setStartHour("12:00pm");
		report.setFinalHour("1:00pm");
		System.out.println(report.toString());
	}
}
