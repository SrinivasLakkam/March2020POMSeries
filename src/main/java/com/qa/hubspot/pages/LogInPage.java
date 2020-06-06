package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LogInPage extends BasePage{

	private WebDriver driver;
	
//	1.By locators -- OR
	By username = By.id("username");
	By password = By.id("password");
	By logInButton =  By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	
//	2.create const.. of the page class
	public LogInPage(WebDriver driver){
		this.driver = driver;
	}
	
//	3.page actions
	public String getLogInPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink(){
		return driver.findElement(signUp).isDisplayed();
	}
	
	public HomePage doLogInPage(String username, String password){
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.logInButton).click();

		return new HomePage(driver);
	}
}
