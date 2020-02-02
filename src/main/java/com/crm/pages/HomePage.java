package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Base;

public class HomePage extends Base  {
	//define pagefactory
		@FindBy(xpath="//td[contains(text(),'Pallavi Kundagol')]")
		WebElement username;
				
		@FindBy(xpath="//a[contains(text(),'Contacts')]")
		WebElement contactLink;
		
		@FindBy(xpath="//a[contains(text(),'Deals')]")
		WebElement dealsLink;
				
		@FindBy(xpath="//a[contains(text(),'Tasks')]")
		WebElement taskLink;
		
		public HomePage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public String VerifyHomePageTitle()
		{
			return driver.getTitle();
		}
		public boolean VerifyUsernamedisplayed()
		{
			return username.isDisplayed();
			
		}
		
	public ContactsPage ClickOnContactsLink()
	{
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsPage()
	{
		dealsLink.click();	
		return new DealsPage();
	}
	
	public TaskPage ClickOnTaskLink()
	{
		taskLink.click();
	
	return new TaskPage();
	}
	

}
