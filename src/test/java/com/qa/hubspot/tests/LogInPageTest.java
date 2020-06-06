package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LogInPage;
import com.qa.hubspot.utils.Constants;

public class LogInPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LogInPage logInPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		logInPage = new LogInPage(driver);
	}
	
	@Test(priority=1)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(logInPage.verifySignUpLink(), "signUpLink is not displayed");
	}
	
	@Test(priority=2)
	public void verifyLogInPageTitleTest(){
		String title =logInPage.getLogInPageTitle();
		System.out.println("login page title is :" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched");
	}
	
	@Test(priority=3)
	public void logInTest(){
		logInPage.doLogInPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
