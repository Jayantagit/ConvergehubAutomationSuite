package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
import com.ConvergeHub.Pages.AccountPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;
import com.ConvergeHub.Pages.TargetPage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_AddAccount extends Base  
{    
	static AtomicInteger sequence = new AtomicInteger(0);
	
	@Test(groups={"Regression"},description="Create a New Account",invocationCount=2)	
	public static void AccountCreation() throws InterruptedException
	{
		//Initialize the Page Classes
		DealPage deal=new DealPage();
		TargetPage target=new TargetPage();
		AccountPage account=new AccountPage();
		
	
		/*-------------------------Login Code
		LoginPage login=new LoginPage();
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,30); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
  	    driver.get("https://staging.convergehub.com/accounts/add");
	   // driver.findElement(By.linkText("+ New")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	    
	     -------------------------------------------*/
		
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Account Screen=====================
	    
	    //------Enter the Account Name
	    String acctnameVal=excel.getCellDataUpd("Account", "AccountName", 1);	    
	    account.acctName.click();
	    account.acctName.sendKeys(acctnameVal);
	    
	    //------Select the Account Industry
	    String industryVal=excel.getCellDataUpd("Account", "Industry", 1);
	    new Select(account.acctIndustry).selectByVisibleText(industryVal);
	    
	    //------Select the Account Type
	    String accttypeVal=excel.getCellDataUpd("Account", "AccountType", 1);//Fetch the value of Account Type from Test Data
	    new Select(account.acctType).selectByVisibleText(accttypeVal);
	    
	    //------Select the Account Status
	    String acctstatusVal=excel.getCellDataUpd("Account", "Status", 1);//Fetch the value of Account Status from Test Data
	    new Select(account.acctStatus).selectByVisibleText(acctstatusVal);
	    
        //------Enter the Phone No
	    account.acctPhone.clear();
	    String phoneNo=excel.getCellDataUpd("Account", "PhoneNo", 1);//Fetch the value of Account Phone no from Test Data
	    account.acctPhone.sendKeys(phoneNo);
	    
	    //------Enter the Email Address
	    account.acctEmail.clear();
	    String emailVal=excel.getCellDataUpd("Account", "EmailAddress", 1);//Fetch the value of Account email address from Test Data
	    account.acctEmail.sendKeys(emailVal);
	    
	    //Clickon the Other tab
		driver.findElement(By.linkText("Other")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String leadSource=excel.getCellDataUpd("Account", "LeadSource", 1);
		new Select(deal.DealLeadSource).selectByVisibleText(leadSource);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	    //Enter the Save Button
	    account.acctSaveBtn.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    int currentCountAccount= sequence.addAndGet(1);
	    
	    
	    String  baseurl=driver.getCurrentUrl();
	    String arr[]=baseurl.split("/");
		
		String Account_ID=arr[arr.length-1];
		System.out.println(Account_ID);
		
		System.out.println(currentCountAccount);
		if(currentCountAccount>1)
		{
			TestUtil.writeProperty("Account_ID_New", Account_ID);
		}
		else
		{
			TestUtil.writeProperty("Account_ID", Account_ID);
		}
	    
		//Verification Statement added for Account creation
	     Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Account Created"));
	    	
	}
	
	     
}
