package com.juaracoding.ujian.posttest26;

import org.openqa.selenium.WebDriver;

import com.juaracoding.ujian.Drivers.DriverSingleton;
import com.juaracoding.ujian.mingguke4.SearchAndCompare;
import com.juaracoding.ujian.mingguke4.register;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestPostTestSearch {
	
	WebDriver driver;
	private register Register = new register();
	private SearchAndCompare search = new SearchAndCompare();;
	private static ExtentTest extentTest;

	public TestPostTestSearch() {
		driver = HooksPosttest26.driver;
		extentTest = HooksPosttest26.extentTest;
	}

	@Given("User go to web shop")
	public void user_go_to_shop() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		System.out.println("Web Shop Berhasil");
		extentTest.log(LogStatus.PASS,"User go to web shop");
		HooksPosttest26.delay(2);
	}

	@And("User click dismiss")
	public void user_click_dismiss() {
		Register.alert();
		System.out.println("Click button dismiss");
		extentTest.log(LogStatus.PASS,"User click dismiss");
	}

	@When("User click Search first item")
	public void User_click_Search_first_item() {
		search.Search("black lux");
		HooksPosttest26.delay(5);
		HooksPosttest26.scroll(300);
		search.ColorAndSize("black", "34");
		System.out.println("Search dan input color size (1)");
		extentTest.log(LogStatus.PASS,"User click Search first item");

	}

	@And("User add first item to cart")
	public void User_add_first_item_to_cart() {
		HooksPosttest26.delay(2);
		search.AddToCart();
		System.out.println("add item ke dalam keranjang(1)");
		extentTest.log(LogStatus.PASS,"User add first item to cart");
	}

	@Then("User click Search second cart")
	public void User_click_Searc_second_cart() {
		search.Search("playboy x");
		HooksPosttest26.delay(3);
		HooksPosttest26.scroll(300);
		search.ColorAndSize("grey", "40");
		System.out.println("Search dan input color size (2)");
		extentTest.log(LogStatus.PASS,"User click Search second cart");
	}

	@And("User add Second item to cart")
	public void User_add_Second_item_to_cart() {
		HooksPosttest26.delay(2);
		search.AddToCart();
		System.out.println("add item ke dalam keranjang (2)");
		extentTest.log(LogStatus.PASS,"User add Second item to cart");
		HooksPosttest26.delay(3);
	}

	@Then("User click view cart")
	public void User_click_view_cart() {
		HooksPosttest26.scroll(-600);
		HooksPosttest26.delay(3);
		search.GotoCart();
		System.out.println("Click view cart");
		extentTest.log(LogStatus.PASS,"User click view cart");
	}

	@And("User click view Checkout")
	public void User_click_view_Checkout() {
		HooksPosttest26.scroll(600);
		search.Checkout();
		System.out.println("Click view Checkout");
		extentTest.log(LogStatus.PASS,"User click view Checkout");
	}
}
