package com.ConvergeHub.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AddLead_QuickView extends Base  
{    
	@Test(groups={"Regression"},description="Create New Lead through Quick View")
	
	public static void LeadCreationQuickView() throws InterruptedException
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
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    driver.get("https://staging.convergehub.com/leads/add");
	    */
		
		  Actions actions = new Actions(driver);
		  WebElement mainMenu = driver.findElement(By.linkText("Sales"));
		  actions.moveToElement(mainMenu).build().perform();;
	    
	      actions.moveToElement(lead.QuickViewicon).build().perform();
	      lead.QuickViewicon.click();
	      
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
	      //Fillup the Quick view Form
	      lead.FirstNamepopup.sendKeys("Test First");
	      lead.LastNamepopup.sendKeys("Test Last");
	      lead.AccountNamepopup.sendKeys("Test Account");
	      new Select(lead.LeadSourcepopup).selectByVisibleText("Demo Request");
	      new Select(lead.Statuspopup).selectByVisibleText("New");
	      
	      lead.Phonepopup.sendKeys("1234567890");
	      lead.Emailpopup.sendKeys("test@test.com");
	      lead.Commentpopup.sendKeys("Test Comments");
	      
	      lead.SaveandNew.click();
	    
	      //Assertion statement to be added
	
	}
      
}
