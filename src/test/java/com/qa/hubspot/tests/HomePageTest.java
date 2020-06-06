package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LogInPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	LogInPage logInPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		logInPage = new LogInPage(driver);
		homePage = logInPage.doLogInPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void verifyHomePageTitle(){
		String title = homePage.getHomePageTitle();
		System.out.println("homePage title is :"+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "homePage title is not matched");
	}
	
	@Test(priority=1)
	public void verifyHomePageHeader(){
		String header = homePage.getHomePageHeaderText();
		System.out.println("homePage header is :"+ header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "homePage header is not matched");
	}
	
	@Test(priority=2)
	public void loggedInUserTest(){
		String loggedInUser = homePage.getLoggedInUserName();
		System.out.println("loggedInUser is :" + loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountName"), "loggedIn user is not matched");
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
