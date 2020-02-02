package com.crm.testcases;


import com.crm.base.Base;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.CustomListners;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListners.class)
public class LoginPageTest extends Base 
{
	
  public  LoginPage loginPageObj;
  public HomePage homePage;
  
	public LoginPageTest()
	{
		super();
	}
	
  @BeforeMethod
  public void setup() 
  {
	  initialization();
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
	  Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and suppor");
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
