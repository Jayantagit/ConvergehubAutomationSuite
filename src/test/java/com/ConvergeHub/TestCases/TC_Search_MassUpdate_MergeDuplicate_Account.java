package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.AccountPage;
import com.ConvergeHub.Pages.ContactPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_Search_MassUpdate_MergeDuplicate_Account extends Base  
{    
	@Test(priority = 6,groups={"Smoke"},description="Advance Search for Account")
	
	public static void AccountAdvanceSearch() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		AccountPage account=new AccountPage();
		
	   /*-------------Login section needed if executed this TC separately 
	
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    driver.get("https://staging.convergehub.com/deals/");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   ---------------------------------------------------------------------- */	    
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Click the Advanced Search button
	    deal.AdvSearchBtn.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    //Enter the Search criteria for Account Name	    
	    account.srchAcctName.sendKeys(excel.getCellDataUpd("Account", "srchAcctName", 1));
	    
	    
	    
	    //Select the Search Filter for Account Type
	  
	    account.srchAccountType.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	   
	    WebElement srchAcctType=driver.findElement(By.id("chk_account_type_accounts_"+excel.getCellDataUpd("Account", "srchAccountType", 1)));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",srchAcctType);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
   
	    //-------Click the Advanced Search Button
	    lead.AdvSearchButton.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	     
	    
	    try
	    {
	        List<WebElement> accounts_num=driver.findElements(By.xpath("//input[@class='list_checkbox']"));
	          
	        if(accounts_num.size()>0)
	        {
	        	System.out.println("Advanced Search return result  :"+accounts_num.size());  
	        }
	        else
	        {
	        	System.out.println("No Accounts found for the selected search criteras");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Accounts found for the Search");  
	    	e.printStackTrace();
	    	
	    }
	    
	}
	
@Test(priority = 7,groups={"Regression"},description="Basic Search at Account Level")
	
	public static void AccountBasicSearch() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		AccountPage account=new AccountPage();
		
	   	//Navigate to the Contacts Page  
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		//Clear the Search field and Enter the Search Text for Quick Search
        deal.SrchQuiclSearch.clear();
       
        String quiclsearchVal=excel.getCellDataUpd("Account", "QuickSearch", 1);
        deal.SrchQuiclSearch.sendKeys(quiclsearchVal);
	    
	    //Click the Go button
	    lead.Gobtn.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	     
	    
	    try
	    {
	        List<WebElement> account_no=driver.findElements(By.xpath("//input[@class='list_checkbox']"));
	          
	        if(account_no.size() >0)
	        {
	        	System.out.println("Basic Search return result - :"+account_no.size());  
	        }
	        else
	        {
	        	System.out.println("No Accounts found for the selected search criteras for Quick search");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Accounts found for the Search");  
	    	e.printStackTrace();
	    	
	    }    
	    
	}

@Test(priority = 8,groups={"Regression"},description="Mass Update for Accounts")

public static void MassUpdateForAccounts() throws InterruptedException
{
	LeadPage lead=new LeadPage();
	DealPage deal=new DealPage();
	ContactPage contact=new ContactPage();
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
     -------------------------------------------*/

	//Navigating to the Contact List Page
    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Account_ID"))).click();
	driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Account_ID_New"))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    lead.Actiondropdown.click(); //Click the Action dropdown
    driver.findElement(By.linkText("Mass Update")).click();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
   
    //Select the Account Type value
    String massupdAccountType=excel.getCellDataUpd("Account", "massupdAccountType", 1);
    new Select(account.massupdAccountType).selectByVisibleText(massupdAccountType);
    
    //Select the Industry value
    String massupdIndustry=excel.getCellDataUpd("Account", "massupdIndustry", 1);
    new Select(account.massupdIndustry).selectByVisibleText(massupdIndustry);
    
    //Click the save button
    lead.MassUpdSave.click();
    
	    
    for (String winHandle : driver.getWindowHandles()) 
    { 

    	driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle 

        WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(lead.MassUpdUpdateBtn));
	    lead.MassUpdUpdateBtn.click();//Click the Update Button on the Mass Update Confirmation Popup

   
    }
    
   	    
    WebDriverWait wait1 = new WebDriverWait (driver, 20);
    wait1.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
    
    
    Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Updated"));
    
}

@Test(priority=9,groups={"Regression"},description="Merge Duplicates-Accounts")

public static void MergeAccounts() throws InterruptedException
{
	LeadPage lead=new LeadPage();
	DealPage deal=new DealPage();
	ContactPage contact=new ContactPage();
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
     -------------------------------------------*/
	
  //Navigate to the Account List Page   
   driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   

   //Select the Accounts already created from the List
    driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Account_ID"))).click();
	driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Account_ID_New"))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
	//Click the Action DropDown
    lead.Actiondropdown.click(); 
    driver.findElement(By.linkText("Merge Duplicates")).click();
    WebDriverWait mergebtn = new WebDriverWait (driver, 20);
    mergebtn.until(ExpectedConditions.visibilityOf(lead.MergeSaveRecord));
    
    //Click the save button
    lead.MergeSaveRecord.click();
    
    WebDriverWait successMsg = new WebDriverWait (driver, 20);
    successMsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
   
    //Verification Step-Selected Contacts are successfully merged
  	Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("successfully merged."));
  	
  	String  baseurl=driver.getCurrentUrl();
	String arr[]=baseurl.split("/");		
	String Account_ID_Merged=arr[arr.length-1];
	TestUtil.writeProperty("Account_ID_Merged", Account_ID_Merged);  	
    
}

      
}
