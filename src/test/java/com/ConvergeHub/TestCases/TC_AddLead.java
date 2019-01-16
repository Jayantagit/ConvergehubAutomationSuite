package com.ConvergeHub.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AddLead extends Base  
{    
	@Test(groups={"Regression","Smoke"})	
	
	public static void LeadCreation() throws InterruptedException
	{
		LoginPage login=new LoginPage();
		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	  
	    driver.get("https://staging.convergehub.com/leads/add");
	    
	
	}
      
}
