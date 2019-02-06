package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.AccountPage;
import com.ConvergeHub.Pages.ContactPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_DeleteAccount extends Base  
{    
	@Test(priority = 10,groups={"Regression"},description="Delete Account")
	
	public static void DeleteAccount() throws InterruptedException
	{
		//Initialize the Page Classes
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		
		/*-------------------------Login Code
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));	    
	    driver.get("https://staging.convergehub.com/accounts/");
	    -------------------------------------------*/
		
	 //Navigate to the Account List Page   
	   driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   

	//Select the Merged account id
		driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Account_ID_Merged"))).click();
	    
		/*
	    try
	    {
	        List<WebElement> account_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(account_num.size()>0)
	        {
	        	account_num.get(0).click();//Click the First Account in the List
	        }
	        else
	        {
	        	System.out.println("No Account is present in the Account List for Deletion");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    //Select the First Account in the List
	   // account.acctCheckbox.click();
	    
	    */
	   
	  //Click the Mass Delete icon for First Account in the List
	    account.acctMassDelicon.click();
	    
	  //Wait for the Delete confirmation Pop up
	   Alert alt=driver.switchTo().alert();
	   Assert.assertTrue(alt.getText().contains("Are you sure you want to delete"));
	  // Assert.assertEquals("Are you sure you want to remove this Account?", alt.getText());
	   alt.accept();
	    
	   WebDriverWait wait = new WebDriverWait (driver, 20);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	   Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Account Deleted"));

	   
	    
	}
		     
}
