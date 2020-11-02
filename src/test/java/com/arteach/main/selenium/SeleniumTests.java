package com.arteach.main.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeleniumTests {
	
	@Autowired
	private WebDriver driver;
	
	@Test
	void testLoginPage() {
		// Opens the login page for this web application
		driver.get("http://localhost:8080/login");
		assertEquals("Login to ArTeach", driver.getTitle());
	}
}
