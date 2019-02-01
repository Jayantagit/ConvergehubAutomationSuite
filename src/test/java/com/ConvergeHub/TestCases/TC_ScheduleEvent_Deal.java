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
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_ScheduleEvent_Deal extends Base  
{    
	@Test(groups={"Regression"},description="Schedule Event for Deal")
	
	public static void ScheduleEventforDeal() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		
		/*-------------------------Login Code
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    driver.get("https://staging.convergehub.com/deals/");
	    -------------------------------------------*/
	  
		//Navigating to the Deal List Page
	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/deals");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	    /*------------------Commenting the Code for Clicking the Select Dropdown of the First Deal in List--------------	
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>0)
	        {
	        	Leads_num.get(0).click();//Click the First Deal in the List
	        }
	        else
	        {
	        	System.out.println("No deal is present in the Deal List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    //Click the Select dropdown for the First Deal in the List
	    lead.LeadListSelection.click();
	    
	    --------------------------------------------------------------------------------*/
	    
	    //Click the Select Dropdown of the selected Deal
	    driver.findElement(By.id("mydiv"+Deal.getProperty("Deal_Id"))).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Select the Schedule Event option from the Select Dropdown
	    driver.findElement(By.linkText("Schedule Event")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
    
	    driver.findElement(By.id("meeting_"+Deal.getProperty("Deal_Id"))).sendKeys("Follow up Meeting");
	    lead.EventDescription.sendKeys("Sample Description");
	    lead.NotesSaveBtn.click();	
	    
	  //Validation Step-Event Schedule added successfully
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Event Relation Added");
	    
	}
      
}
