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
import com.ConvergeHub.Pages.ToolsPage;


public class TC_Tools extends Base  
{    
	@Test(groups={"Regression"},description="Manage Duplicate Search")
	
	public static void ManageDuplicateSearch() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		ToolsPage tools=new ToolsPage();
		
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
		
	   	//Navigate to the Manage Duplicate Page	    
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/manageduplicates/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		//Select the Module for which Manage Duplicate Search will be done
		String modulename=excel.getCellDataUpd("Tools", "Module", 1);
		new Select(tools.Module).selectByVisibleText(modulename);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Click the Find Duplicate Link-Partial Link as Test as Link name changes with Module
		driver.findElement(By.partialLinkText("Find Duplicate")).click();
		
		//Click the Email Checkbox & Search Button
		tools.ManagedDuplicateEmail.click();
		driver.findElement(By.partialLinkText("Search")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	     
	    //*****************************Validate the Search Result***********************************************************
	    try
	    {
	        List<WebElement> srch_cnt=driver.findElements(By.name("selected_record"));
	          
	        if(srch_cnt.size()>0)
	        {
	        	System.out.println("Basic Search return result  :"+srch_cnt.size());  
	        }
	        else
	        {
	        	System.out.println("No records found for the selected search criteras");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Record found for the Search");  
	    	e.printStackTrace();
	    	
	    }
	    	       
	}
      
}
