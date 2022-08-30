package com.juaracoding.ujian.posttest26;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import com.juaracoding.ujian.mingguke4.CheckOut;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestPostTestCheckout {
	
	WebDriver driver;
	private CheckOut check = new CheckOut();
	private static ExtentTest extentTest;
	
	public TestPostTestCheckout() {
		driver = HooksPosttest26.driver;
		extentTest = HooksPosttest26.extentTest;
	}

	@When("User input data")
	public void User_input_data() {
		HooksPosttest26.delay(5);
		HooksPosttest26.scroll(300);
		check.isiCekOut();
		HooksPosttest26.delay(3);
		check.ChkAndBtn();
		System.out.println("memasukan data checkout");
		extentTest.log(LogStatus.PASS,"User input data");
	}

	@And("User click checkout")
	public void User_click_checkout() {
		check.CheckPlaceOrder();
		HooksPosttest26.delay(3);
		HooksPosttest26.scroll(900);
		System.out.println("Click place order");
		extentTest.log(LogStatus.PASS,"User click checkout");
	}

	@Then("User Your order has been received")
	public void User_Your_order_has_been_received() {
		String x = "Thank you. Your order has been received.";
		assertEquals(check.Succes(), x);
		System.out.println("menerima bukti order");
		System.out.println("Test Berhasil");
		extentTest.log(LogStatus.PASS,"User Your order has been received");
	}
}
