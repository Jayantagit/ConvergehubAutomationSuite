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


public class TC_CreateTaskForDeal extends Base  
{    
	@Test(groups={"Regression"},description="Create Task for Deal")
	
	public static void CreatetaskforDeal() throws InterruptedException
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
	  
	    driver.get("https://staging.convergehub.com/deals");
	    
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>0)
	        {
	        	Leads_num.get(0).click();//Click the First Deal in the List
	        }
	        else
	        {
	        	System.out.println("No Deal is present in the Deal List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    lead.LeadListSelection.click();
	    driver.findElement(By.linkText("Create Task")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    new Actions(driver).moveToElement(lead.TaskSubject).build().perform();//Set Focus on Task Subject
	    
	    lead.TaskSubject.sendKeys("New Task");
	    lead.TaskSaveBtn.click();
	    
	    Assert.assertNotNull(driver.findElement(By.xpath("//span[contains(text(),'Task Relation Added')]")));
	    
	}
      
}
