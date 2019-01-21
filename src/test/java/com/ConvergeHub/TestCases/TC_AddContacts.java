package com.ConvergeHub.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.ContactPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AddContacts extends Base  
{    
	@Test(groups={"Regression"},description="Create a New Contact Manually")
	
	public static void ContactCreation() throws InterruptedException
	{
		
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		
		//Login Function-Start
		LoginPage login=new LoginPage();
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    //Login Code-End
	  
	    //Navigate to the Contact Add Page
	    driver.get("https://staging.convergehub.com/contacts/add");
	    
	    //===========Filled up the Add Contact Screen=====================
	    //------Select the Contact Salutation
	    String Salutation=excel.GetCellData("Contact", 1, 0);
	    new Select(contact.Salutation).selectByVisibleText(Salutation); 
	    
	   	    
	  //------Enter the First Name
	    String contactFirstname=excel.GetCellData("Contact", 1, 1);
	   contact.FirstName.clear();
	   contact.FirstName.sendKeys(contactFirstname);
	   
	   //------Enter the Last Name
	   String contactLastname=excel.GetCellData("Contact", 1, 2);
	   contact.LastName.clear();
	   contact.LastName.sendKeys(contactLastname);
	   
	   //------Enter the Phone no
	   String contactPhoneno=excel.GetCellData("Contact", 1, 3);
	   contact.PhoneNo.clear();
	   contact.PhoneNo.sendKeys(contactPhoneno);
	    
	   //------Enter the Email Address
	   String contactEmail=excel.GetCellData("Contact", 1, 4);
	   contact.EmailAddress.clear();
	   contact.EmailAddress.sendKeys(contactEmail);
    
	   contact.ContactSaveBtn.click();
	    
	    //Assertion statement to be added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Created"));
	    
	
	}
      
}
