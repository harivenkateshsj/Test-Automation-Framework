package com.ui.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{
	
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	private static final String SIZE_M = "2";
	
	
	
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description="User logs into application and search for the product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("yekanen768@aganseo.com", "password")
				.searchForAProduct(SEARCH_TERM);
	}
	
	@Test(description="User if the logged in user is able to buy the dress", groups= {"e2e","smoke","sanity"})
	public void checkoutTest() {
		String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(SIZE_M)
		.addProductToCart().proceedToCheckout()
		.goToConfirmAddressPage().goToShippmentPage()
		.goToPaymentPage().makePayment();
		Assert.assertTrue(result.contains("payment"));
	}

}
