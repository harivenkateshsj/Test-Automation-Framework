package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippmentPage extends BrowserUtility{

	private static final By TERMS_CHECKBOX = By.id("uniform-cgv");
	
	private static final By PROCEED_TO_CHECKOUT_SHIPPING_BUTTON_LOCATOR = By.name("processCarrier");
	
	public ShippmentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	public PaymentPage goToPaymentPage() {
		clickOnCheckBox(TERMS_CHECKBOX);
		clickOn(PROCEED_TO_CHECKOUT_SHIPPING_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
