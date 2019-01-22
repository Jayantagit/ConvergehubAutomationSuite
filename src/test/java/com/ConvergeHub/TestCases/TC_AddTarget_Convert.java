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


public class TC_AddTarget_Convert extends Base  
{    
	@Test(groups={"Regression"},description="Create a New Target",priority = 0)
	
	public static void TargetCreation() throws InterruptedException
	{
		
		DealPage deal=new DealPage();
		TargetPage target=new TargetPage();
		
	
	//Login Function-Start
		LoginPage login=new LoginPage();
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,30); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	//Login Code-End
		  
	    //Navigate to the Target Add Page
	    driver.get("https://staging.convergehub.com/targets/add");
	    
	    //===========Filled up the Add Target Screen=====================
	    //------Select the Target Salutation
	    String salutationVal=excel.GetCellData("Target", 1, 0);
	    new Select(target.Salutation).selectByVisibleText(salutationVal);
	    
	    //------Select the Target Status
	    String statusVal=excel.GetCellData("Target", 1, 1);//variable will be in CamelCase format
	    new Select(target.Status).selectByVisibleText(statusVal);
	    
	    //------Enter the First Name
	    target.FirstName.clear();
	    String firstNm=excel.GetCellData("Target", 1, 2);
	    target.FirstName.sendKeys(firstNm);
	    
	    //------Enter the Last Name
	    target.LastName.clear();
	    String lastNm=excel.GetCellData("Target", 1, 3);
	    target.LastName.sendKeys(lastNm);
	    
	  //------Select the Type
	    String typeVal=excel.GetCellData("Target", 1, 4);
	    new Select(target.TargetType).selectByVisibleText(typeVal);
	    	    
	    //------Enter the Company Name
	    target.CompanyName.clear();
	    String companyNm=excel.GetCellData("Target", 1, 5);
	    target.CompanyName.sendKeys(companyNm);
	    
		//------Select the Industry
	    String industryVal=excel.GetCellData("Target", 1, 6);
	    new Select(target.Industry).selectByVisibleText(industryVal);
	    
	    //------Enter the Phone No
	    target.PhoneNo.clear();
	    String phoneNo=excel.GetCellData("Target", 1, 7);
	    target.PhoneNo.sendKeys(phoneNo);
	    
	    //------Enter the Email Address
	    target.EmailAddress.clear();
	    String emailVal=excel.GetCellData("Target", 1, 8);
	    target.EmailAddress.sendKeys(emailVal);
	    
	    //Enter the Save Button
	     target.TargetSaveBtn.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	     Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Target Created"));
	    	
	}
	
	@Test(groups={"Smoke"},description="Converting a Target to Lead",priority = 1)
	
	public static void ConvertTarget() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		TargetPage target=new TargetPage();
   
	    //Navigate to the Target Page
	    driver.get("https://staging.convergehub.com/targets/");
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    
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
	    
	    //-------Click the Advanced Search Button
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
	    
	 

	    
	    //Waiting for successful conversion message
	    WebDriverWait waitsuccessmsg= new WebDriverWait (driver, 20);
	    waitsuccessmsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
	    
	    //Validation-Lead Converted successfully message is appearing
	    Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Convert to Leads"));
	    
	}
      
}
