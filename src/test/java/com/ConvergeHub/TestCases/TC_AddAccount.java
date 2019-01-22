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
import com.ConvergeHub.Pages.AccountPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;
import com.ConvergeHub.Pages.TargetPage;


public class TC_AddAccount extends Base  
{    
	@Test(groups={"Regression"},description="Create a New Account",priority = 0)
	
	public static void AccountCreation() throws InterruptedException
	{
		
		DealPage deal=new DealPage();
		TargetPage target=new TargetPage();
		AccountPage account=new AccountPage();
		
	
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
		  
	    //Navigate to the Account Add Page
	    driver.get("https://staging.convergehub.com/accounts/add");
	   // driver.findElement(By.linkText("+ New")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    //===========Filled up the Add Account Screen=====================
	    
	    //------Enter the Account Name
	    String acctnameVal=excel.GetCellData("Account", 1, 0);
	    //account.acctName.clear();
	    account.acctName.click();
	    account.acctName.sendKeys(acctnameVal);
	    
	    //------Select the Account Industry
	    String industryVal=excel.GetCellData("Account", 1, 1);//Fetch the value of Industry from Test Data
	    new Select(account.acctIndustry).selectByVisibleText(industryVal);
	    
	    //------Select the Account Type
	    String accttypeVal=excel.GetCellData("Account", 1, 2);//Fetch the value of Account Type from Test Data
	    new Select(account.acctType).selectByVisibleText(accttypeVal);
	    
	    //------Select the Account Status
	    String acctstatusVal=excel.GetCellData("Account", 1, 3);//Fetch the value of Account Status from Test Data
	    new Select(account.acctStatus).selectByVisibleText(acctstatusVal);
	    
        //------Enter the Phone No
	    account.acctPhone.clear();
	    String phoneNo=excel.GetCellData("Account", 1, 4);//Fetch the value of Account Phone no from Test Data
	    account.acctPhone.sendKeys(phoneNo);
	    
	    //------Enter the Email Address
	    account.acctEmail.clear();
	    String emailVal=excel.GetCellData("Account", 1, 5);//Fetch the value of Account email address from Test Data
	    account.acctEmail.sendKeys(emailVal);
	    
	    //Enter the Save Button
	    account.acctSaveBtn.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	     Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Account Created"));
	    	
	}
	
	     
}
