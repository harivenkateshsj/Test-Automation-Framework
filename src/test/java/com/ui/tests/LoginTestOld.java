package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class LoginTestOld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();
		wd.get("https://automationpractice.techwithjatin.com/");
		wd.manage().window().maximize();	
		By signInLocator = By.xpath("//a[contains(text(),'Sign in')]");
		WebElement signInLink = wd.findElement(signInLocator);
		signInLink.click();
		
		By emailLocator = By.id("email");
		WebElement emailTextBox = wd.findElement(emailLocator);
		emailTextBox.sendKeys("yekanen768@aganseo.com");
		
		By passwordLocator = By.id("passwd");
		WebElement passwordTextBox = wd.findElement(passwordLocator);
		passwordTextBox.sendKeys("password");
		
		By signInBtnLocator = By.xpath("//button[@id='SubmitLogin']");
		WebElement signInBtnWebElement = wd.findElement(signInBtnLocator);
		signInBtnWebElement.click();
	}

}
