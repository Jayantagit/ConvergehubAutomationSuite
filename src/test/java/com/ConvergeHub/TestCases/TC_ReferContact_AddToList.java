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


public class TC_ReferContact_AddToList extends Base  
{    
	@Test(priority = 0,groups={"Regression"},description="Refer a Contact")
	
	public static void ReferContact() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
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
		driver.get("https://staging.convergehub.com/leads");
		
		-------------------------------------------*/
		//Navigating to the Contact List page
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/contacts/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	
		//Click the Select Dropdown of the selected Contact
		driver.findElement(By.id("mydiv"+SavedData.getProperty("Contact_ID"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//Select the Refer option from the Select Dropdown of the Selected Contact
	    driver.findElement(By.linkText("Refer")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    lead.ReferBtn.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	    //Enter the value in the Refer popup	    
	    lead.ReferTo.sendKeys("ABC@mailinator.com");
	    lead.ReferBtnpopup.click();
	    
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='header_notification_msg']"))));
	    
	    //Verification statement added 
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("successfully referred"));
	   
	    
	}
	
@Test(priority = 1,groups={"Regression"},description="Add Contact To List")
	
	public static void AddContactToList() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		
		/*-------------------------Login Code
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));	  
	   	driver.get("https://staging.convergehub.com/leads");
	   -------------------------------------------*/
		//Navigating to the Contact List Page
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/contacts/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		//Click the Select checkbox of the selected Lead
		driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Contact_ID"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//Select the Refer option from the Select Dropdown
		lead.Actiondropdown.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Add to List")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.visibilityOf(lead.ListName));
	    
	    //Enter the List Name	   
	    String ListName=excel.getCellDataUpd("Contact", "ListName", 1);
	    lead.ListName.sendKeys(ListName);
	    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	    
	    //Click the Add To List Button
	    lead.AddToListBtn.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='header_notification_msg']"))));
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Relation Added to List"));
	  
	    
	}
      
}
