package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;
import com.ConvergeHub.Pages.TargetPage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_AddTarget_Convert extends Base  
{    
	@Test(priority = 0,groups={"Regression"},description="Create a New Target")
	
	public static void TargetCreation() throws InterruptedException
	{
		
		DealPage deal=new DealPage();
		TargetPage target=new TargetPage();
		
	
	/*-------------------------Login Code
		LoginPage login=new LoginPage();
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,30); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));	
	    driver.get("https://staging.convergehub.com/targets/add");
	    -------------------------------------------*/
	    
		//Redirecting to the Add Target Page
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/targets/add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Target Screen=====================
	    //------Select the Target Salutation
	    String salutationVal=excel.getCellDataUpd("Target", "Salutation", 1);
	    new Select(target.Salutation).selectByVisibleText(salutationVal);
	    
	    //------Select the Target Status
	    String statusVal=excel.getCellDataUpd("Target", "Status", 1);
	    new Select(target.Status).selectByVisibleText(statusVal);
	    
	    //------Enter the First Name
	    target.FirstName.clear();
	    String firstNm=excel.getCellDataUpd("Target", "FirstName", 1);
	    target.FirstName.sendKeys(firstNm);
	    
	    //------Enter the Last Name
	    target.LastName.clear();
	    String lastNm=excel.getCellDataUpd("Target", "LastName", 1);
	    target.LastName.sendKeys(lastNm);
	    
	  //------Select the Type
	    String typeVal=excel.getCellDataUpd("Target", "Type", 1);
	    new Select(target.TargetType).selectByVisibleText(typeVal);
	    	    
	    //------Enter the Company Name
	    target.CompanyName.clear();
	    String companyNm=excel.getCellDataUpd("Target", "CompanyName", 1);
	    target.CompanyName.sendKeys(companyNm);
	    
		//------Select the Industry
	    String industryVal=excel.getCellDataUpd("Target", "Industry", 1);
	    new Select(target.Industry).selectByVisibleText(industryVal);
	    
	    //------Enter the Phone No
	    target.PhoneNo.clear();
	    String phoneNo=excel.getCellDataUpd("Target", "PhoneNo", 1);
	    target.PhoneNo.sendKeys(phoneNo);
	    
	    //------Enter the Email Address
	    target.EmailAddress.clear();
	    String emailVal=excel.getCellDataUpd("Target", "EmailAddress", 1);
	    target.EmailAddress.sendKeys(emailVal);
	    
	    //Enter the Save Button
	    target.TargetSaveBtn.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Target Created"));
	    
	  	String  baseurl=driver.getCurrentUrl();
		String arr[]=baseurl.split("/");		
		String Target_ID=arr[arr.length-1];
		TestUtil.writeProperty("Target_ID", Target_ID);  
	    	
	}
	
	@Test(priority = 1,groups={"Smoke"},description="Converting a Target to Lead")
	
	public static void ConvertTarget() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		TargetPage target=new TargetPage();
   
	    //Navigate to the Target Page
		/*
	    driver.get("https://staging.convergehub.com/targets/");
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    */
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/targets/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    
	    
	    /*--------------------This Code has been written-Search for the Status new and select the First Target in List
	    //Click the Advance Search Button
	    deal.AdvSearchBtn.click();
	    
		//Set the Search Filter-Status to New
	    target.srchStatus.click();
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    String srchtatusVal=excel.GetCellData("Target", 1, 9);
	    WebElement SrchStatus=driver.findElement(By.id("chk_status_targets_"+ srchtatusVal));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",SrchStatus);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    target.srchTags.click(); //Click the tags field
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    
		 lead.AdvSearchButton.click();
		 WebDriverWait waitSearch = new WebDriverWait (driver, 20);
		 waitSearch.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	    
	    try
	    {
	        List<WebElement> targets_num=driver.findElements(By.xpath(OR.getProperty("selectDropdown")));
	          
	        if(targets_num.size()>0)
	        {
	        	        
	        	targets_num.get(0).click();//Click the First Target in the List
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	WebElement Element =driver.findElement(By.linkText("Convert To Leads"));
	        	JavascriptExecutor js = (JavascriptExecutor) driver;
	        	js.executeScript("arguments[0].click();", Element);
	        	
	    	    //Wait for the appearance of the Convert Lead Pop-up
	    	    WebDriverWait wait= new WebDriverWait (driver, 20);
	    	    wait.until(ExpectedConditions.visibilityOf(lead.ConvertLeadPopup));
	    	    
	       	    //Click the Save button
	    	    lead.ConvertLeadConvertBtn.click();
	        	
	        }
	        else
	        {
	        	System.out.println("No Target is present in the Target List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	 ----------------------------------------------------------------------- */
	    
	    //Click the Select Dropdown of the Created target	   
	    driver.findElement(By.id("mydiv"+SavedData.getProperty("Target_ID"))).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebElement Element =driver.findElement(By.linkText("Convert To Leads"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", Element);
    	
    	
    	//Wait for the appearance of the Convert Lead Pop-up
    	WebDriverWait wait= new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(lead.ConvertLeadPopup));
	    
   	    //Click the Save button
	    lead.ConvertLeadConvertBtn.click();

	    
	    //Waiting for successful conversion message
	    WebDriverWait waitsuccessmsg= new WebDriverWait (driver, 20);
	    waitsuccessmsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
	    
	    //Validation-Lead Converted successfully message is appearing
	    Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Convert to Leads"));
	    
	}
      
}
