package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_BasicSearch extends Base  
{    
	@Test(groups={"Regression"},description="Basic Search")
	
	public static void BasicSearch() throws InterruptedException
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
	    -------------------------------------------*/
		
	   	//Navigate to the Lead Page  
	    //driver.get("https://staging.convergehub.com/leads");
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/leads");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	  //Clear the Search field and Enter the Search Text for Quick Search
        lead.BasicSearchTxt.clear();
       // lead.BasicSearchTxt.sendKeys(excel.GetCellData("Lead", 1, 29));
        lead.BasicSearchTxt.sendKeys(excel.getCellDataUpd("Lead", "BasicSearchText", 1));
	    
	    //Click the Go button
	    lead.Gobtn.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	     
	    //*****************************Validate the Search Result***********************************************************
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath("//input[@class='list_checkbox']"));
	          
	        if(Leads_num.size()>0)
	        {
	        	System.out.println("Basic Search return result  :"+Leads_num.size());  
	        }
	        else
	        {
	        	System.out.println("No records found for the selected search criteras for Quick search");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Record found for the Search");  
	    	e.printStackTrace();
	    	
	    }
	    	       
	}
      
}
