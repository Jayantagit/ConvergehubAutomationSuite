package com.ConvergeHub.TestCases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_MassUpdateForDeal extends Base  
{    
	@Test(groups={"Regression"},description="Mass Update for Deal")
	
	public static void MassUpdateforlead() throws InterruptedException
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
	     -------------------------------------------*/
	   
		/*-
	    driver.get("https://staging.convergehub.com/deals/");
	    
	    try
	    {
	        List<WebElement> deals_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(deals_num.size()>1)
	        {
	        	deals_num.get(0).click();//Click the First Deal in the List
	        	deals_num.get(1).click();//Click the Second Deal in the List
	        }
	        else
	        {
	        	System.out.println("No or only One deal is present in the Deal List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    -------------------------------------------*/
		
	    	driver.get("https://"+config.getProperty("Environment")+".convergehub.com/deals");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Deal_Id"))).click();
			driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Deal_Id_New"))).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    lead.Actiondropdown.click(); //Click the Action dropdown
		    driver.findElement(By.linkText("Mass Update")).click();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    
		    //Update the Deal Type
		    String dealType=excel.getCellDataUpd("Deal", "MassUpdDealType", 1);
		    new Select(deal.MassUpdDealType).selectByVisibleText(dealType);
		    
		    //Update the Lead Source
		    String leadSource=excel.getCellDataUpd("Deal", "MassUpdateLeadSource", 1);
		    new Select(deal.MassUpdLeadSource).selectByVisibleText(leadSource);
		    
		    //Update the Deal Sales Stage
		    String salesStage=excel.getCellDataUpd("Deal", "MassUpdateSalesStage", 1);
		    new Select(deal.MassUpdSalesStage).selectByVisibleText(salesStage);
				   
		    //Click the save button
		    lead.MassUpdSave.click();
	    
	    
	    for (String winHandle : driver.getWindowHandles()) 
	    { 

	    	driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle 

	        WebDriverWait wait = new WebDriverWait (driver, 20);
		    wait.until(ExpectedConditions.visibilityOf(lead.MassUpdUpdateBtn));
		    lead.MassUpdUpdateBtn.click();//Click the Update Button on the Mass Update Confirmation Popup

	   
	    }
	    
	   	    
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
	    
	    
	    Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Deals Updated"));
	    
	}


}
