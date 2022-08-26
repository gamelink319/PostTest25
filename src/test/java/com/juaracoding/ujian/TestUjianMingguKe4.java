package com.juaracoding.ujian;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.ujian.Drivers.*;
import com.juaracoding.ujian.mingguke4.CheckOut;
import com.juaracoding.ujian.mingguke4.SearchAndCompare;
import com.juaracoding.ujian.mingguke4.login;
import com.juaracoding.ujian.mingguke4.register;

public class TestUjianMingguKe4 {

	public static WebDriver driver;
	private login Login;
	private register Register;
	private SearchAndCompare search;
	private CheckOut check;

	@BeforeClass
	public void setUP() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/checkout/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		Login = new login();
		Register = new register();
		search = new SearchAndCompare();
		check = new CheckOut();
	}
	@Test
	public void test() {
		check.ChkAndBtn();
		delay(4);
	}

	@Test(priority = 1)
	public void testregister() {
		Register.RegShop();
		delay(4);
	}

	@Test(priority = 2)
	public void testlogin() {
		Login.loginShop();
		delay(4);
	}

	@Test(priority = 3)
	public void testsearchandcompare() {
		search.Search("black lux");
		delay(5);
		scroll(300);
		search.ColorAndSize("black", "34");
		search.AddToCart();
		search.Compare();
		delay(3);
		search.CloseCompare();
		delay(3);
		scroll(-300);
		delay(2);
		search.Search("playboy x");
		delay(3);
		scroll(300);
		search.ColorAndSize("grey", "40");
		delay(1);
		search.AddToCart();
		delay(1);
		search.Compare();
		delay(3);
		search.CloseCompare();
		delay(1);
		scroll(-300);
		search.Checkout();
		delay(3);
	}

	@Test(priority = 4)
	public void testcheckout() {
		scroll(300);
		check.isiCekOut();
		delay(2);
		check.ChkAndBtn();
		delay(7);
		scroll(900);
		String x = "Thank you. Your order has been received.";
		assertEquals(check.Succes(), x);
		System.out.println("Test Berhasil");
	}

	@AfterClass
	public void CloseBrowser() {
		delay(5);
		driver.quit();
	}

	public void delay(int detik) {
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