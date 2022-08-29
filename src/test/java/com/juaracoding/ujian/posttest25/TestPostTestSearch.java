package com.juaracoding.ujian.posttest25;

import org.openqa.selenium.WebDriver;

import com.juaracoding.ujian.Drivers.DriverSingleton;
import com.juaracoding.ujian.mingguke4.SearchAndCompare;
import com.juaracoding.ujian.mingguke4.register;

import Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestPostTestSearch {
	WebDriver driver;

	private register Register = new register();
	private SearchAndCompare search = new SearchAndCompare();;

	public TestPostTestSearch() {
		driver = HooksPosttest25.driver;
	}

	@Given("User go to web shop")
	public void user_go_to_shop() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		System.out.println("Web Shop Berhasil");
	}

	@And("User click dismiss")
	public void user_click_dismiss() {
		Register.alert();
		System.out.println("Click button dismiss");
	}

	@When("User click Search first item")
	public void User_click_Search_first_item() {
		search.Search("black lux");
		HooksPosttest25.delay(5);
		HooksPosttest25.scroll(300);
		search.ColorAndSize("black", "34");
		System.out.println("Search dan input color size (1)");

	}

	@And("User add first item to cart")
	public void User_add_first_item_to_cart() {
		search.AddToCart();
		System.out.println("add item ke dalam keranjang(1)");
	}

	@Then("User click Search second cart")
	public void User_click_Searc_second_cart() {
		search.Search("playboy x");
		HooksPosttest25.delay(3);
		HooksPosttest25.scroll(300);
		search.ColorAndSize("grey", "40");
		System.out.println("Search dan input color size (2)");
	}

	@And("User add Second item to cart")
	public void User_add_Second_item_to_cart() {
		HooksPosttest25.delay(2);
		search.AddToCart();
		System.out.println("add item ke dalam keranjang (2)");
		HooksPosttest25.delay(3);
	}

	@Then("User click view cart")
	public void User_click_view_cart() {
		HooksPosttest25.scroll(-600);
		HooksPosttest25.delay(3);
		search.GotoCart();
		System.out.println("Click view cart");
	}

	@And("User click view Checkout")
	public void User_click_view_Checkout() {
		HooksPosttest25.scroll(600);
		search.Checkout();
		System.out.println("Click view Checkout");
	}
}
