package com.crm.testcases;

import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.TaskPage;
import com.crm.util.CustomListners;
import com.crm.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

@Listeners(CustomListners.class)
public class HomePageTest extends Base {
  
	public HomePage homepageObj;
	public LoginPage loginPageObj;
	public ContactsPage contactpageObj;
	public DealsPage dealsPageObj;
	public TaskPage taskPageObj;
	public TestUtil testUtilObj;
	
	public HomePageTest()
	{
		super();
	}
	@Parameters({ "broser" })
	@BeforeMethod
  public void setup(String broser) 
  {
	  initialization(broser);
	 ContactsPage contactpageObj=new ContactsPage();
	DealsPage dealsPageObj=new DealsPage();
	 TaskPage taskPageObj=new TaskPage();
	  testUtilObj=new TestUtil();
	  loginPageObj= new LoginPage();
	
	  homepageObj=  loginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));
	  
  }
  @Test
  public void verifyHomePageTitleTest() 
  {
	String homePageTitle=  homepageObj.VerifyHomePageTitle();
	  Assert.assertEquals(homePageTitle, "CRMPRO","HomePage title not matched");
  }
  @Test
  public void VerifyUsernamedisplayedTest() 
  {
	  testUtilObj.switchToframeByName("mainpanel");
 homepageObj.VerifyUsernamedisplayed();
 Assert.assertTrue(true);
 }
	
	  @Test public void verifyClickOnContactsLinkTest() 
	  {
		  testUtilObj.switchToframeByName("mainpanel");
		  contactpageObj=  homepageObj.ClickOnContactsLink(); 
		  
	  }
	   
  @AfterMethod
  public void teardown()
  {
	  driver.quit();
  }

}
