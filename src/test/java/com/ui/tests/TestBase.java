package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtlity;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLamdaTest;
	
	@Parameters({"browser","isLamdaTest","isHeadless"})
	@BeforeMethod(description="Load the Homepage of the website")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLamdaTest, @Optional("true") boolean isHeadless, ITestResult result) {
		this.isLamdaTest=isLamdaTest;
		WebDriver lamdaDriver;
		if(isLamdaTest) {
			lamdaDriver = LamdaTestUtlity.initializeLamdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lamdaDriver);
		}
		else {
		logger.info("Load the Homepage of the website");
		homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description="Tear down the browser")
	public void tearDown() {
	if(isLamdaTest) {
		LamdaTestUtlity.quitSession(); //quit the local session on lamdaTest (Cloud)
	}
	else {
		homePage.quit(); //local session
	}
	}
}
