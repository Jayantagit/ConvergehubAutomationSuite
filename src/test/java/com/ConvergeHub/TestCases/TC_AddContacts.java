package com.ConvergeHub.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
import com.ConvergeHub.Utilities.TestUtil;


public class TC_AddContacts extends Base  
{    
	
	static AtomicInteger sequence = new AtomicInteger(0);
	@Test(groups={"Regression"},description="Create a New Contact Manually",invocationCount=2)
	
	public static void ContactCreation() throws InterruptedException
	{
		
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		
		/*-------------------------Login Code
		LoginPage login=new LoginPage();
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));	  
	     driver.get("https://staging.convergehub.com/contacts/add");
	    -------------------------------------------*/
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/contacts/add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //===========Filled up the Add Contact Screen=====================
	    //------Select the Contact Salutation
	   // String Salutation=excel.GetCellData("Contact", 1, 0);
		String Salutation=excel.getCellDataUpd("Contact", "Salutation", 1);
	    new Select(contact.Salutation).selectByVisibleText(Salutation); 
	    
	   	    
	  //------Enter the First Name
	   // String contactFirstname=excel.GetCellData("Contact", 1, 1);
	   String contactFirstname=excel.getCellDataUpd("Contact", "FirstName", 1);
	   contact.FirstName.clear();
	   contact.FirstName.sendKeys(contactFirstname);
	   
	   //------Enter the Last Name
	   //String contactLastname=excel.GetCellData("Contact", 1, 2);
	   String contactLastname=excel.getCellDataUpd("Contact", "LastName", 1);
	   contact.LastName.clear();
	   contact.LastName.sendKeys(contactLastname);
	   
	   //------Enter the Phone no
	   //String contactPhoneno=excel.GetCellData("Contact", 1, 3);
	   String contactPhoneno=excel.getCellDataUpd("Contact", "PhoneNo", 1);
	   contact.PhoneNo.clear();
	   contact.PhoneNo.sendKeys(contactPhoneno);
	    
	   //------Enter the Email Address
	   //String contactEmail=excel.GetCellData("Contact", 1, 4);
	   String contactEmail=excel.getCellDataUpd("Contact", "EmailAddress", 1);
	   contact.EmailAddress.clear();
	   contact.EmailAddress.sendKeys(contactEmail);
	   
	   //Clickon the Other tab
	   driver.findElement(By.linkText("Other")).click();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   String leadSource=excel.getCellDataUpd("Contact", "LeadSource", 1);
	   new Select(deal.DealLeadSource).selectByVisibleText(leadSource);
	   
    
	   contact.ContactSaveBtn.click();
	    
	    //Assertion statement to be added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    int currentCountContact= sequence.addAndGet(1);
	    
	    
	    String  baseurl=driver.getCurrentUrl();
	    String arr[]=baseurl.split("/");
		
		String Contact_ID=arr[arr.length-1];
		System.out.println(Contact_ID);
		
		//excel.SetCellData("ID", 1, 0, Lead_ID);
		
		System.out.println(currentCountContact);
		if(currentCountContact>1)
		{
			
			//SavedData.setProperty("Contact_ID_New", Contact_ID);
			TestUtil.writeProperty("Contact_ID_New", Contact_ID);
			
			
		}
		else
		{
			//SavedData.put("Lead_Id", Lead_ID);
			//SavedData.setProperty("Contact_Id", Contact_ID);
			TestUtil.writeProperty("Contact_ID", Contact_ID);
		}
		
		/*---------------
		try 
		{			
			SavedData.store(fos,"Saved");
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	    -----------------*/
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Created"));
	    
	
	}
      
}
