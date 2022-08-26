package com.juaracoding.ujian.mingguke4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.ujian.Drivers.DriverSingleton;

public class SearchAndCompare {
	private WebDriver driver;

	public SearchAndCompare() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='noo-search']")
	private WebElement btnSearch;

	@FindBy(xpath = "//input[@name='s']")
	private WebElement Search;

	@FindBy(xpath = "//select[@id='pa_color']")
	private WebElement pilihColor;

	@FindBy(xpath = "//select[@id='pa_size']")
	private WebElement pilihSize;

	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	private WebElement BtnAddToCart;

	@FindBy(xpath = "//a[@class='compare button']")
	private WebElement BtnCompare;

	@FindBy(xpath = "//button[@id='cboxClose']")
	private WebElement BtnCloseCompare;
	
	@FindBy(xpath = "//span[@class='cart-name-and-total']")
	private WebElement BtnGoToCart;
	//a[@class='button wc-forward']
	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	private WebElement BtnCheckout;
	//a[contains(text(),'Checkout')]
	public void Search(String isi) {
		btnSearch.click();
		System.out.println("Btn Search Telah Di klik");
		Search.sendKeys(isi);
		System.out.println("Telah mengisi search :" + isi);
		Search.sendKeys(Keys.ENTER);
		System.out.println("telah menekan tombol enter");
	}

	public void ColorAndSize(String warna, String ukuran) {
		Select selectcolor = new Select(pilihColor);
		Select selectsize = new Select(pilihSize);
		selectcolor.selectByValue(warna);
		System.out.println("Berhasil Memilih Warna :" + warna);
		selectsize.selectByValue(ukuran);
		System.out.println("Berhasil Memilih Ukuran :" + ukuran);
	}

	public void AddToCart() {
		BtnAddToCart.click();
		System.out.println("Berhasil Memasukan ke dalam Keranjang");
	}
	
	public void GotoCart() {
		BtnGoToCart.click();
		System.out.println("button cart berhasil di klik");
	}

	public void Compare() {
		BtnCompare.click();
		System.out.println("Menekan Tombol Compare");
	}

	public void CloseCompare() {
		BtnCloseCompare.click();
		System.out.println("menutup Compare");
	}

	public void Checkout() {
		BtnCheckout.click();
		System.out.println("Membuka Page CheckOut");
	}
}
