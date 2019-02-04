package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.ContactPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_ScheduleEvent_Contact extends Base  
{    
	@Test(groups={"Regression"},description="Schedule Event for Contact")
	
	public static void ScheduleEventforContact() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		
		/*-------------Login section needed if executed this TC separately
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]"))); 
	    driver.get("https://staging.convergehub.com/contacts/");
	    ------------------------------------------ */
		
		//Navigating to the Contact List Page
	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/contacts/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    /*------------------Commenting the Code for Clicking the Select Dropdown of the First Contact in List--------------	
	    
	    try
	    {
	        List<WebElement> contacts_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(contacts_num.size()>0)
	        {
	        	contacts_num.get(0).click();//Click the First Contact in the List
	        }
	        else
	        {
	        	System.out.println("No Contact is present in the Contact List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    //Click the Select dropdown for the First Contact in the List
	    lead.LeadListSelection.click();
	    
	     --------------------------------------------------------------------------------*/
	    //Click the Select Dropdown of the selected Contact
	    driver.findElement(By.id("mydiv"+SavedData.getProperty("Contact_ID"))).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	    
	    
	    //Select the ---Schedule Event option from the Select Dropdown
	    driver.findElement(By.linkText("Schedule Event")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.findElement(By.id("meeting_"+SavedData.getProperty("Contact_ID"))).sendKeys("Follow up Meeting");
	    lead.EventDescription.sendKeys("Sample Description");
	    lead.NotesSaveBtn.click();	
	    
	    /*---------------------------------------------------------------------------------------------------
	  //Set Focus on Event Subject
	    new Actions(driver).moveToElement(lead.EventSubject).build().perform();
	    
	  //Enter the value in the Subject
	    lead.EventSubject.sendKeys("Test Event for Contact");
	    
	  //Enter the description in Subject
	    lead.EventDescription.sendKeys("Sample Description for Contact");
	    
	    //Click the Save button for the new Event
	    lead.NotesSaveBtn.click();	
	  -----------------------------------------------------------------------------------------------------*/ 
	    
	  //Validation Step-Event Schedule added successfully
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Event Relation Added");
	    
	}
      
}
