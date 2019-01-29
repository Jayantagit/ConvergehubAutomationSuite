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
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_ReferLead_AddToList extends Base  
{    
	@Test(groups={"Regression"},description="Refer a Lead")
	
	public static void Referlead() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		
		/*
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));*/
	  
	   // driver.get("https://staging.convergehub.com/leads");
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/leads");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
	    /*
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>0)
	        {
	        	Leads_num.get(0).click();//Click the First Lead in the List
	        }
	        else
	        {
	        	System.out.println("No Lead is present in the Lead List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    lead.LeadListSelection.click();
	    
	    */
		//Click the Select Dropdown of the selected Lead
		driver.findElement(By.id("mydiv"+SavedData.getProperty("Lead_Id"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//Select the Refer option from the Select Dropdown
	    driver.findElement(By.linkText("Refer")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    lead.ReferBtn.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //Enter the value in the Refer popup
	    
	    lead.ReferTo.sendKeys("ABC@mailinator.com");
	    lead.ReferBtnpopup.click();
	    
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='header_notification_msg']"))));
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Leads successfully referred"));
	   //Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Leads successfully referred");
	    
	}
	
@Test(groups={"Regression"},description="Add Lead To List")
	
	public static void AddleadToList() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		
		/*
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));*/
	  
	   // driver.get("https://staging.convergehub.com/leads");
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/leads");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
	    /*
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>0)
	        {
	        	Leads_num.get(0).click();//Click the First Lead in the List
	        }
	        else
	        {
	        	System.out.println("No Lead is present in the Lead List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    lead.LeadListSelection.click();
	    
	    */
		//Click the Select checkbox of the selected Lead
		driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Lead_Id"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//Select the Refer option from the Select Dropdown
		lead.Actiondropdown.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Add to List")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.visibilityOf(lead.ListName));
	    
	    //Enter the List Name
	   // String ListName=excel.GetCellData("Lead", 1, 13);//Fetching the List Name from the Test data
	    String ListName=excel.getCellDataUpd("Lead", "ListName", 1);
	    lead.ListName.sendKeys(ListName);
	    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	    
	    //Click the Add To List Button
	    lead.AddToListBtn.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='header_notification_msg']"))));
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Lead Relation Added to List"));
	   //Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Leads successfully referred");
	    
	}
      
}
