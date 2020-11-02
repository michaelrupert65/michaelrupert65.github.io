package com.arteach.main.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SeleniumConfig {

	@Bean
	public WebDriver getWebDriver(Environment env) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michael\\Desktop\\__MACOSX\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", env.getProperty("selenium.path"));

		WebDriver driver = new ChromeDriver();
		//driver.get("http://localhost:8080/login");
		return driver;
	}
}
