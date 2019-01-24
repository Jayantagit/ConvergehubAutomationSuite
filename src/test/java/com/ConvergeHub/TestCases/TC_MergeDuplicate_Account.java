package com.ConvergeHub.TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.AccountPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_MergeDuplicate_Account extends Base  
{    
	@Test(groups={"Regression"},description="Merge Duplicates-Accounts")
	
	public static void MergeAccounts() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		/*
		//Login section for Testing-Start
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    //Login Section-End
	     */
	  //Navigate to the Lead Page
	    driver.get("https://staging.convergehub.com/accounts/");
	    
	    try
	    {
	        List<WebElement> acct_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(acct_num.size()>1)
	        {
	        	acct_num.get(0).click();//Click the First Account in the List
	        	acct_num.get(1).click();//Click the Second Account in the List
	        }
	        else
	        {
	        	System.out.println("No or only One Account is present in the Account List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    //Click the Action DropDown
	    lead.Actiondropdown.click(); 
	    driver.findElement(By.linkText("Merge Duplicates")).click();
	    WebDriverWait mergebtn = new WebDriverWait (driver, 20);
	    mergebtn.until(ExpectedConditions.visibilityOf(lead.MergeSaveRecord));
	    
        //Click the save button
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", lead.MergeSaveRecord);
	    //lead.MergeSaveRecord.click();
	    
	    WebDriverWait successMsg = new WebDriverWait (driver, 20);
	    successMsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
	   
	    //Verification Step-Selected Accounts are successfully merged
	  	Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Selected accounts are successfully merged."));
	    
	}


}
