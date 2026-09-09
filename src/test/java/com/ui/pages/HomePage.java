package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility{
	Logger logger = LoggerUtility.getLogger(this.getClass());
	public static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign')]");
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless);
		//goToWebsite(readProperty(QA,"URL")); //get the url information from properties file
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public LoginPage goToLoginPage() { //Page Functions -> Cannot use Void!!
		logger.info("Trying to perform click on the sign in page");
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
}
