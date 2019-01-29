package com.ConvergeHub.TestCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AddLead extends Base  
{   
	
	static AtomicInteger sequence = new AtomicInteger(0);
	
	@Test(groups={"Regression"},invocationCount=2,description="Create New Lead")
	
	public static void LeadCreation(ITestContext testContext) throws InterruptedException
	{
		LoginPage login=new LoginPage();
		LeadPage lead=new LeadPage();
		
		/*-------------------------Login Code
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,30); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='icon search-top']")));
	    -------------------------------------------*/
	  
	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/leads/add");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Select the Salutation
	    lead.Salutation.click();
	    //String Salutation=excel.GetCellData("Lead", 1, 0);
	    String Salutation=excel.getCellDataUpd("Lead", "Salutation", 1);
	    new Select(lead.Salutation).selectByVisibleText(Salutation);
	    
	    //Enter the First and LastName
	   // String FirstName=excel.GetCellData("Lead", 1, 1);
	    //String LastName=excel.GetCellData("Lead", 1, 2);
	    String FirstName=excel.getCellDataUpd("Lead", "FirstName", 1);
	    String LastName=excel.getCellDataUpd("Lead", "LastName", 1);
	    lead.FirstName.sendKeys(FirstName);
	    lead.LasttName.sendKeys(LastName);
	    
	    //Select the Lead Type
	    lead.LeadType.click();
	    //String LeadType=excel.GetCellData("Lead", 1, 3);
	    String LeadType=excel.getCellDataUpd("Lead", "LeadType", 1);
	    new Select(lead.LeadType).selectByVisibleText(LeadType);
	    
	    //Enter the Account Name
	    lead.AcctName.click();
	    //String AcctName=excel.GetCellData("Lead", 1, 4);
	    String AcctName=excel.getCellDataUpd("Lead", "AcctName", 1);
	    lead.AcctName.sendKeys(AcctName);
	    
	    //Select the Lead Source
	    lead.LeadSource.click();
	    //String LeadSource=excel.GetCellData("Lead", 1, 5);
	    String LeadSource=excel.getCellDataUpd("Lead", "LeadSource", 1);
	    new Select(lead.LeadSource).selectByVisibleText(LeadSource);
	    
	  //Select the Lead Status
	    lead.LeadStatus.click();
	    //String LeadStatus=excel.GetCellData("Lead", 1, 6);
	    String LeadStatus=excel.getCellDataUpd("Lead", "LeadStatus", 1);
	    new Select(lead.LeadStatus).selectByVisibleText(LeadStatus);
	    
	  //Select the Industry
	    lead.Industry.click();
	    //String Industry=excel.GetCellData("Lead", 1, 7);
	    String Industry=excel.getCellDataUpd("Lead", "Industry", 1);
	    new Select(lead.Industry).selectByVisibleText(Industry);
	    
	   //Set the Phone No
	    //String PhoneNo=excel.GetCellData("Lead", 1, 8);
	    String PhoneNo=excel.getCellDataUpd("Lead", "PhoneNo", 1);
	    lead.PhoneNo.sendKeys(PhoneNo);
	   
	  //Set the Email Address
	   lead.EmailAddress.click();
	   //String emailAddr=excel.GetCellData("Lead", 1, 9);
	   String emailAddr=excel.getCellDataUpd("Lead", "emailAddr", 1);
	   lead.EmailAddress.sendKeys(emailAddr);
	   
	   //Click  Save Button
	   lead.LeadSave.click();
	    
	   //Assertion statement Added for the verification
	   
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	    
	    int currentCount= sequence.addAndGet(1);
	    
	    
	    String  baseurl=driver.getCurrentUrl();
	    String arr[]=baseurl.split("/");
		
		String Lead_ID=arr[arr.length-1];
		System.out.println(Lead_ID);
		
		//excel.SetCellData("ID", 1, 0, Lead_ID);
		
		System.out.println(currentCount);
		if(currentCount>1)
		{
			//SavedData.clear();
			//SavedData.put("Lead_Id_New", Lead_ID);
			SavedData.setProperty("Lead_Id_New", Lead_ID);
			
			
		}
		else
		{
			//SavedData.put("Lead_Id", Lead_ID);
			SavedData.setProperty("Lead_Id", Lead_ID);
		}
		
		
		try 
		{			
			SavedData.store(fos,"Saved");
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Lead Created");//Validation that Lead edited successfully
	    
	    
	
	}
      
}
