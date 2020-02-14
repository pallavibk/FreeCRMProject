package com.crm.testcases;


import com.crm.base.Base;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.CustomListners;
import com.crm.util.TestUtil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners(CustomListners.class)
public class LoginPageTest extends Base 
{
	
	 
	
  public  LoginPage loginPageObj;
  public HomePage homePage;
  
  Logger log=LogManager.getLogger(LoginPageTest.class);
	public LoginPageTest()
	{
		super();
	}
	@AfterSuite
	  public void afterSuite() {
		  System.out.println("After suite");
	  }
	@Parameters({ "broser" })
	@BeforeMethod
  public void setup(String broser) 
  {
		log.info("Entered setup method");
		log.debug("Inside setup: broser: "+broser);
		log.fatal("This is a fatal message");
	  initialization(broser);
	  loginPageObj=new LoginPage();
	 
  }
  @AfterMethod
  public void teardown() {
	  driver.quit();
  }
  
  @Test
  public void validateLoginPageTitleTest() 
  {
	String title=  loginPageObj.validateLoginPageTitle();
	  Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
  }
  
  @Test
  public void validateCRMImageTest() 
  {
	 boolean logo= loginPageObj.validateCRMImage();
	 Assert.assertTrue(logo);
	  
  }
  @Test
  public void loginTest() 
  {
	  homePage=loginPageObj.login(prop.getProperty("username"),prop.getProperty("password"));
  }
  
  
  

 

}
