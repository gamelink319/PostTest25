package com.juaracoding.ujian.posttest25;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.ujian.Drivers.DriverSingleton;

import Utils.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class HooksPosttest25 {
	public static WebDriver driver;

	@Before
	public void setUP() {
		DriverSingleton.getInstance(Constants.FIREFOX);
		driver = DriverSingleton.getDriver();
	}

	@AfterAll
	public static void CloseBrowser() {
		delay(5);
		DriverSingleton.CloseObjectInstance();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0," + vertical + ")");
	}

}
