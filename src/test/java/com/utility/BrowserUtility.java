package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();//thread safe
	//private WebDriver driver; //instance variable - No thread safe
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public WebDriver getDriver() { //setter for instance variable - driver
		return driver.get();
	}
	
	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver); //initialize driver
	}
	
	public BrowserUtility(String browserName) {
		logger.info("Launching Browser name "+browserName);

		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}
		else {
			logger.error("Invalid Browser Name...Please select Chrome or Edge");
			System.err.println("Invalid Browser Name...Please select Chrome or Edge");
		}
	}
	
	
	public BrowserUtility(String browserName,boolean isHeadless) {
		logger.info("Launching Browser name "+browserName);

		if(browserName.equalsIgnoreCase("chrome")) {
			if(isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); //syntax of headless mode
				options.addArguments("--window-size=1920,1080"); //resolution of headless mode
				driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver());
			}	
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu"); //disable UI
				driver.set(new EdgeDriver(options));
			}
			else {
			driver.set(new EdgeDriver());
			}
		}
		else {
			logger.error("Invalid Browser Name...Please select Chrome or Edge");
			System.err.println("Invalid Browser Name...Please select Chrome or Edge");
		}
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadless) {
		logger.info("Launching Browser name "+browserName);

		if(browserName==Browser.CHROME) { //Please see how are we comparing enum
			if(isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); //syntax of headless mode
				options.addArguments("--window-size=1920,1080"); //resolution of headless mode
				driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver());
			}
		}
		else if(browserName==Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu"); //disable UI
				driver.set(new EdgeDriver(options));
			}
			else {
				driver.set(new EdgeDriver());
			}
		}
		else if(browserName==Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			}
			else {
				driver.set(new FirefoxDriver());
			}
		}
		/* => In enum, we dont need to worry about else block because what we declare inside enum are valid
		 * else { 
			System.err.println("Invalid Browser Name...Please select Chrome or Edge or Firefox");
		}*/
	}
	
	
	public void goToWebsite(String url) {
		logger.info("visiting the website"+url);
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		logger.info("maximizing thr browser window");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Finding element with locator "+locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("element found and now performing click");

		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with locator "+locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("element found and now enter text "+textToEnter);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding element with locator "+locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("element found and now returing visible text "+element.getText());
		return element.getText();
	}
	
	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get(); //TakeScreenshot is interface and we typecast with driver
		File ScreenshotData = screenshot.getScreenshotAs(OutputType.FILE); 
		Date date = new Date(); //to print timestamp
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss"); //to print timestamp
		String timestamp = format.format(date); //to print timestamp
		//String path = System.getProperty("user.dir")+"//screenshots//"+name+" - "+ timestamp + ".png"; //this is obsolete path so commented
		String path = "./screenshots/"+name+" - "+ timestamp + ".png"; //this is relative path
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(ScreenshotData,screenshotFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public void quit() {
		driver.get().quit();
	}
	
}
