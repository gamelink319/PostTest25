package com.juaracoding.ujian;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.ujian.Drivers.DriverSingleton;
import com.juaracoding.ujian.mingguke4.CheckOut;
import com.juaracoding.ujian.mingguke4.SearchAndCompare;
import com.juaracoding.ujian.mingguke4.register;

import Utils.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestUjianMingguKe5 {
	public static WebDriver driver;
	private register Register;
	private SearchAndCompare search;
	private CheckOut check;
	boolean vv = false;

	@Before
	public void setUP() {
		DriverSingleton.getInstance(Constants.FIREFOX);
		Register = new register();
		search = new SearchAndCompare();
		check = new CheckOut();
	}

	@Given("User go to web shop")
	public void user_go_to_shop() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		System.out.println("1");
	}

	@And("User click dismiss")
	public void user_click_dismiss() {
		Register.alert();
		System.out.println("2");
	}

	@When("User click Search first item")
	public void User_click_Search_first_item() {
		search.Search("black lux");
		delay(5);
		scroll(300);
		search.ColorAndSize("black", "34");
		System.out.println("3");

	}

	@And("User add first item to cart")
	public void User_add_first_item_to_cart() {
		search.AddToCart();
		System.out.println("4");
	}

	@Then("User click Search second cart")
	public void User_click_Searc_second_cart() {
		search.Search("playboy x");
		delay(3);
		scroll(300);
		search.ColorAndSize("grey", "40");
		System.out.println("5");
	}

	@And("User add Second item to cart")
	public void User_add_Second_item_to_cart() {
		delay(2);
		search.AddToCart();
		System.out.println("6");
		delay(3);
	}

	@Then("User click view cart")
	public void User_click_view_cart() {
		scroll(-600);
		delay(3);
		search.GotoCart();
		System.out.println("7");
	}

	@And("User click view Checkout")
	public void User_click_view_Checkout() {
		scroll(600);
		search.Checkout();
		System.out.println("8");
	}

	@When("User input data")
	public void User_input_data() {
		delay(5);
		scroll(300);
		check.isiCekOut();
		delay(3);
		check.ChkAndBtn();
		System.out.println("9");
	}

	@And("User click checkout")
	public void User_click_checkout() {
		check.CheckPlaceOrder();
		delay(3);
		scroll(900);
		System.out.println("10");
	}

	@Then("User Your order has been received")
	public void User_Your_order_has_been_received() {
		String x = "Thank you. Your order has been received.";
		assertEquals(check.Succes(), x);
		System.out.println("Test Berhasil");
		vv = true;
		System.out.println("11");
	}

	@After
	public void CloseBrowser() {
		delay(5);
		if (vv == true) {
			driver.quit();
		}
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
