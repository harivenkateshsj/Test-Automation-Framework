package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{
	
	//HomePage homePage; //instance variable
	Logger logger = LoggerUtility.getLogger(this.getClass()); //for ease of maintenance,we move this to TestListener.java

	
	@Test(description="Verify the valid user is able to login the application(TESTDATA FROM JSON)", 
		  groups= {"e2e","sanity"},
		  dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,
		  dataProvider="LoginTestDataProvider")
	public void loginTest(User user) {
		// TODO Auto-generated method stub
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Harivenkatesh S J");
	}
/*
	@Test(description="Verify the valid user is able to login the application(TESTDATA FROM CSV)", 
			  groups= {"e2e","sanity"},
			  dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,
			  dataProvider="LoginTestCSVDataProvider")
		public void loginCSVTest(User user) {
			// TODO Auto-generated method stub
			assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Harivenkatesh S J");
		}
	
	@Test(description="Verify the valid user is able to login the application(TESTDATA FROM CSV)", 
			  groups= {"e2e","sanity"},
			  dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,
			  dataProvider="LoginTestExcelDataProvider",
			  retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
		public void loginExcelTest(User user) {
			// TODO Auto-generated method stub
		//logger.info("login excel test is started"); 
			assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Harivenkatesh S J1");
		//logger.info("login excel test is completed");
	   }
	   */
}
