package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static final By CONFIRM_PAYMENT_LOCATOR = By.xpath("//p[contains(@class,'alert')]");
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String makePayment() {
		return getVisibleText(CONFIRM_PAYMENT_LOCATOR);
	}

}
