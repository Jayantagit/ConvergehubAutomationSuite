package com.ConvergeHub.TestCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
	    wait=new WebDriverWait(driver,30); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='icon search-top']")));
	  
	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/leads/add");
	    
	    //Select the Salutation
	    lead.Salutation.click();
	    String Salutation=excel.GetCellData("Lead", 1, 0);
	    new Select(lead.Salutation).selectByVisibleText(Salutation);
	    
	    //Enter the First and LastName
	    String FirstName=excel.GetCellData("Lead", 1, 1);
	    String LastName=excel.GetCellData("Lead", 1, 2);
	    lead.FirstName.sendKeys(FirstName);
	    lead.LasttName.sendKeys(LastName);
	    
	    //Select the Lead Type
	    lead.LeadType.click();
	    String LeadType=excel.GetCellData("Lead", 1, 3);
	    new Select(lead.LeadType).selectByVisibleText(LeadType);
	    
	    //Enter the Account Name
	    lead.AcctName.click();
	    String AcctName=excel.GetCellData("Lead", 1, 4);
	    lead.AcctName.sendKeys(AcctName);
	    
	    //Select the Lead Source
	    lead.LeadSource.click();
	    String LeadSource=excel.GetCellData("Lead", 1, 5);
	    new Select(lead.LeadSource).selectByVisibleText(LeadSource);
	    
	  //Select the Lead Status
	    lead.LeadStatus.click();
	    String LeadStatus=excel.GetCellData("Lead", 1, 6);
	    new Select(lead.LeadStatus).selectByVisibleText(LeadStatus);
	    
	  //Select the Industry
	    lead.Industry.click();
	    String Industry=excel.GetCellData("Lead", 1, 7);
	    new Select(lead.Industry).selectByVisibleText(Industry);
	    
	   //Set the Phone No
	    String PhoneNo=excel.GetCellData("Lead", 1, 8);
	    lead.PhoneNo.sendKeys(PhoneNo);
	   
	  //Set the Email Address
	   lead.EmailAddress.click();
	   String emailAddr=excel.GetCellData("Lead", 1, 9);
	   lead.EmailAddress.sendKeys(emailAddr);
	   
	   //Click  Save Button
	   lead.LeadSave.click();
	    
	   //Assertion statement to be added for the verification
	   
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	    
	    
	    
	    String  baseurl=driver.getCurrentUrl();
	    String arr[]=baseurl.split("/");
		
		String Lead_ID=arr[arr.length-1];
		System.out.println(Lead_ID);
		
		//excel.SetCellData("ID", 1, 0, Lead_ID);
		
		SavedData.put("Lead_Id", Lead_ID);
		try {
			SavedData.store(fos, "saving");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Lead Created");//Validation that Lead edited successfully
	    
	    
	
	}
      
}
