package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";
    
	@BeforeMethod(description="Valid user logs into application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("yekanen768@aganseo.com", "password");
	}
	
	@Test(description="Verify if loggedin user is able to search for a product and correct products are shown", 
		  groups= {"e2e","smoke","sanity"}
	      )
	public void verifyProductSearchtest() {
		// TODO Auto-generated method stub
		//String data=myAccountPage.searchForAProduct("Printed Summer Dress").getSearchResultTitle();
		//System.out.println(data);
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}


}
