package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_ConvertLead extends Base  
{    
	@Test(groups={"Regression"},description="Converting a Lead")
	
	public static void Convertlead() throws InterruptedException
	{
		LeadPage lead=new LeadPage();//Initializing the Lead Class
		
		/*-------------------------Login Code
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	   -------------------------------------------*/
	    
	    //Navigate to the Lead Page
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/leads");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		/*--------------Commenting the Code where searching for Lead with In Process Status & Convert it
	    //Click the Advance Search Button
	    lead.AdvSearchBtn.click();
	    
		//Select the Search Filter for Status-In Process
	    lead.AdvSearchStatus.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    WebElement SrchStatus=driver.findElement(By.id("chk_status_leads_"+config.getProperty("SrchStatus")));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",SrchStatus);
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    
	    //-------Click the Advanced Search Button
		 lead.AdvSearchButton.click();
		 WebDriverWait waitSearch = new WebDriverWait (driver, 20);
		 waitSearch.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	     
	    
	    
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>0)
	        {
	        	        
	        	Leads_num.get(0).click();//Click the First Lead in the List
	        	
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
	    
	    lead.LeadListSelection.click();//Click the First In Process Lead in the List
	    
	    */
		 
		//Click the Select Dropdown of the selected Lead
		driver.findElement(By.id("mydiv"+SavedData.getProperty("Lead_Id"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			
		//Select the Refer option from the Select Dropdown
		driver.findElement(By.linkText("Convert")).click();//Select the Convert option from the dropdown
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	   
	    
	    //Wait for the appearance of the Convert Lead Pop-up
	    WebDriverWait wait= new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(lead.ConvertLeadPopup));
	    
	    int nm=(int) (Math.random()*50+1);//random function
	    
	    //Set the Account Name in the Convert Lead pop up
	    lead.ConvertLeadAcctName.clear();
	    //lead.ConvertLeadAcctName.sendKeys("Test_"+String.valueOf(nm));
	    String AcctName=excel.GetCellData("Lead", 1, 14);//Fetching the Acct Name from the Test data
	    lead.ConvertLeadAcctName.sendKeys(AcctName);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Check the Create Contact CheckBox
	    String CreateContactStatus=lead.ConvertLeadCreateContact.getAttribute("value");
	    if(!CreateContactStatus.equalsIgnoreCase("1"))
	    {
	     lead.ConvertLeadCreateContact.click();
	    }
	    
	    	    
	    //-----Filled up the Contact section------
	    lead.ConvertLeadContactFirstNm.clear();
	    //lead.ConvertLeadContactFirstNm.sendKeys("Test_"+String.valueOf(nm));
	    String ContactFirstNm=excel.GetCellData("Lead", 1, 15);
	    lead.ConvertLeadContactFirstNm.sendKeys(ContactFirstNm);
	    
	    lead.ConvertLeadContactLastNm.clear();
	   // lead.ConvertLeadContactLastNm.sendKeys("Test_"+String.valueOf(nm));
	    String ContactLastNm=excel.GetCellData("Lead", 1, 16);
	    lead.ConvertLeadContactLastNm.sendKeys(ContactLastNm);
	    
	    
	    lead.ConvertLeadContactEmail.clear();
	   // lead.ConvertLeadContactEmail.sendKeys("Test"+String.valueOf(nm)+"@test.com");
	    String ContactEmail=excel.GetCellData("Lead", 1, 17);
	    lead.ConvertLeadContactEmail.sendKeys(ContactEmail);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	    
	    //Check the Create Deal CheckBox
	    String CreateDealStatus=lead.ConvertLeadCreateDeal.getAttribute("value");
	    
	    if(!CreateDealStatus.equalsIgnoreCase("1"))
	    {
	    	lead.ConvertLeadCreateDeal.click();
	    }
	    //-----Filled up the Deal section------
	    lead.ConvertLeadDealName.clear();
	    //lead.ConvertLeadDealName.sendKeys("Deal For Lead_"+String.valueOf(nm)+"@test.com");
	   // lead.ConvertLeadDealEstimatedAmt.sendKeys("500");
	    //lead.ConvertLeadComment.sendKeys("Test Comments");
	    String DealName=excel.GetCellData("Lead", 1, 18);
	    String DealEstimatedAmt=excel.GetCellData("Lead", 1, 19);
	    String DealComment=excel.GetCellData("Lead", 1, 20);
	    lead.ConvertLeadDealName.clear();
	    lead.ConvertLeadDealName.sendKeys(DealName);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    lead.ConvertLeadDealEstimatedAmt.clear();
	    lead.ConvertLeadDealEstimatedAmt.sendKeys(DealEstimatedAmt);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    lead.ConvertLeadComment.clear();
	    lead.ConvertLeadComment.sendKeys(DealComment);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    //Click the Save button
	    lead.ConvertLeadConvertBtn.click();
	    
	    //Waiting for successful conversion message
	    WebDriverWait waitsuccessmsg= new WebDriverWait (driver, 20);
	    waitsuccessmsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
	    
	    //Validation-Lead Converted successfully message is appearing
	    Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Lead converted successfully"));
	    
	}


}
