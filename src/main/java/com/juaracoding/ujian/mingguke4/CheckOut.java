package com.juaracoding.ujian.mingguke4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujian.Drivers.DriverSingleton;

public class CheckOut {

	private WebDriver driver;

	public CheckOut() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='billing_first_name']")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@id='billing_last_name']")
	private WebElement LastName;

	@FindBy(xpath = "//input[@id='billing_company']")
	private WebElement CompanyName;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement isi;

	@FindBy(xpath = "//input[@id='billing_address_1']")
	private WebElement Adress;

	@FindBy(xpath = "//input[@id='billing_city']")
	private WebElement City;

	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement State;

	@FindBy(xpath = "//input[@id='billing_postcode']")
	private WebElement PostCode;
	
	@FindBy(xpath = "//input[@id='billing_email']")
	private WebElement Email;

	@FindBy(xpath = "//input[@id='billing_phone']")
	private WebElement PhoneNumber;
	// input[@id='terms']
	@FindBy(xpath = "//span[@class='woocommerce-terms-and-conditions-checkbox-text']")
	private WebElement ChkBoxTerms;

	@FindBy(xpath = "//button[@id='place_order']")
	private WebElement BtnPlaceOrder;

	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	private WebElement getSucces;

	@FindBy(xpath = "//span[@id='select2-billing_country-container']")
	private WebElement BtnRegion;

	@FindBy(xpath = "//span[@id='select2-billing_state-container']")
	private WebElement BtnState;

	public void isiCekOut() {
		FirstName.sendKeys("jacob");
		LastName.sendKeys("bambang");
		CompanyName.sendKeys("Juara coding");
		BtnRegion.click();
		isi.sendKeys("Indonesia", Keys.ENTER);
		Adress.sendKeys("jln kecebong makan durian no 69");
		BtnState.click();
		isi.sendKeys("Bali", Keys.ENTER);
		City.sendKeys("denpasar");
		PostCode.sendKeys("80111");
		PhoneNumber.sendKeys("0888886913645");
		Email.sendKeys("dhannaputra4@gmail.com");
		System.out.println("Berhasil Mengisi Data Pembelian");
	}

	public void ChkAndBtn() {
		ChkBoxTerms.click();
		System.out.println("mengkonfirmasi checkout");
	}
	
	public void CheckPlaceOrder() {
		BtnPlaceOrder.click();
	}
	
	public String Succes() {
		return getSucces.getText();
	}
}