package com.ConvergeHub.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AddLead extends Base  
{    
	@Test(groups={"Regression"},description="Create New Lead")
	
	public static void LeadCreation() throws InterruptedException
	{
		LoginPage login=new LoginPage();
		LeadPage lead=new LeadPage();
		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	  
	    driver.get("https://staging.convergehub.com/leads/add");
	    
	    lead.Salutation.click();
	    new Select(lead.Salutation).selectByVisibleText("Mr.");
	    
	    lead.FirstName.sendKeys("Test First");
	    lead.LasttName.sendKeys("Test Last");
	    
	    lead.LeadType.click();
	    new Select(lead.LeadType).selectByVisibleText("Person");
	    
	    lead.AcctName.click();
	    lead.AcctName.sendKeys("Test");
	    
	    lead.LeadSource.click();
	    new Select(lead.LeadSource).selectByVisibleText("Online Site");
	    
	    lead.LeadStatus.click();
	    new Select(lead.LeadStatus).selectByVisibleText("New");
	    
	    lead.Industry.click();
	    new Select(lead.Industry).selectByVisibleText("Environmental");
	    
	    lead.EmailAddress.click();
	   lead.EmailAddress.sendKeys("ABSC@mailinator.com");
	   lead.LeadSave.click();
	    
	    //Assertion statement to be added for the verification
	    
	
	}
      
}
