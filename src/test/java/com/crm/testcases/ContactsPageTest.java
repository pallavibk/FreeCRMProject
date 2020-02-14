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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

@Listeners(CustomListners.class)
public class ContactsPageTest extends Base {
  

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	  String sheetName = "contacts";
	 
	
	   
	public ContactsPageTest(){
			super();
			
	}
	
	@Parameters({"broser"})
	@BeforeMethod
	public void setUp(String broser) throws InterruptedException {
		
		  initialization(broser);
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToframeByName("mainpanel");
		
		//contactsPage = homePage.ClickOnContactsLink();
	}
	
	/*
	 * @Test(priority=1) public void verifyContactsPageLabel(){
	 * Assert.assertTrue(contactsPage.verifyContactsLabel(),
	 * "contacts label is missing on the page"); }
	 */
	
	/*
	 * @Test(priority=2) public void selectSingleContactsTest(){
	 * contactsPage.selectContactsByName("test2 test2"); }
	 * 
	 * @Test(priority=3) public void selectMultipleContactsTest(){
	 * contactsPage.selectContactsByName("test2 test2");
	 * contactsPage.selectContactsByName("ui uiii");
	 * 
	 * }
	 */
	

	
	  @DataProvider public Object[][] getCRMTestData() { Object data[][]
	  =TestUtil.getTestData(sheetName); return data; }
	 
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException{
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		testUtil.mouseOver(ele);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		//homePage.ClickOnContactsLink();
		Thread.sleep(2000);
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact1(String title, String firstName, String lastName, String company) throws InterruptedException{
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		testUtil.mouseOver(ele);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		//homePage.ClickOnContactsLink();
		Thread.sleep(2000);
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	@AfterMethod
	  public void teardown() {
		 driver.quit();
	  }

}
