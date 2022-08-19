package com.juaracoding.ujian.mingguke4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujian.Drivers.DriverSingleton;

public class login {

	private WebDriver driver;

	public login() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement isiuser;

	@FindBy(xpath = "//input[@id='user_pass']")
	private WebElement isipass;

	@FindBy(xpath = "//input[@id='wp-submit']")
	private WebElement btnLogin;

	public void loginShop() {
		String user = "dhannaputra7223@gmail.com";
		String password = "1sampai8888";
		isiuser.sendKeys(user);
		System.out.println("mengisi login username/email :" + user);
		isipass.sendKeys(password);
		System.out.println("mengisi login password" );
		btnLogin.click();
		System.out.println("klik tombol login");
	}
}