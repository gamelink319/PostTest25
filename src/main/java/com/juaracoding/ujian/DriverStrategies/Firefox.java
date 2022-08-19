package com.juaracoding.ujian.DriverStrategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{
	
	public WebDriver setStrategy() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Xh\\OneDrive\\Desktop\\Bootcamp\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
