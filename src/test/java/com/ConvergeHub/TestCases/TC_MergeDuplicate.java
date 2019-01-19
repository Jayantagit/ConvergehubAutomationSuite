package com.ConvergeHub.TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_MergeDuplicate extends Base  
{    
	@Test(groups={"Regression"},description="Merge Duplicates")
	
	public static void MergeLeads() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
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
	    driver.get("https://staging.convergehub.com/leads");
	    
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>1)
	        {
	        	Leads_num.get(0).click();//Click the First Lead in the List
	        	Leads_num.get(1).click();//Click the Second Lead in the List
	        }
	        else
	        {
	        	System.out.println("No or only One Lead is present in the Lead List");      
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
	    lead.MergeSaveRecord.click();
	    
	    WebDriverWait successMsg = new WebDriverWait (driver, 20);
	    successMsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
	   
	    //Verification Step-Selected leads are successfully merged
	  	Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Selected leads are successfully merged."));
	    
	}


}
