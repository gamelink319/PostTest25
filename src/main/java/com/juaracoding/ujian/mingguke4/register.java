package com.juaracoding.ujian.mingguke4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujian.Drivers.DriverSingleton;

public class register {

	private WebDriver driver;

	public register() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
	private WebElement btndismiss;

	@FindBy(xpath = "//a[@href='https://shop.demoqa.com/my-account/']")
	private WebElement btnmasuk;

	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement isinama;

	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement isiemail;

	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement isipassword;

	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnReg;

	public void RegShop() {

		String reguser = "dhannaputra7223";
		String regemail = "dhannaputra7223@gmail.com";
		String regpass = "1sampai8888";

		btndismiss.click();
		System.out.println("alert berhasil di klik");
		btnmasuk.click();
		System.out.println("masuk ke account perdaftaran");
		delay(5);
		isinama.sendKeys(reguser);
		System.out.println("mengisi nama :" + reguser);
		isiemail.sendKeys(regemail);
		System.out.println("mengisi email :" + regemail);
		isipassword.sendKeys(regpass);
		System.out.println("mengisi password ");
		btnReg.click();
		System.out.println("klik tombol register");
	}

	public void alert() {
		btndismiss.click();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}
}
