package com.ConvergeHub.TestCases;

import java.io.IOException;
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
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AddAccount_QuickView extends Base  
{    
	@Test(priority = 5,groups={"Regression"},description="Create New Account through Quick View")
	
	public static void AccountCreationQuickView() throws InterruptedException
	{	
		LeadPage lead=new LeadPage();
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
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='icon search-top']")));
	   driver.get("https://staging.convergehub.com/leads/add");
		-------------------------------------------*/
	   
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.linkText("Sales"));
		actions.moveToElement(mainMenu).build().perform();;
	    
	    actions.moveToElement(account.quickViewIcon).build().perform();
	    account.quickViewIcon.click();
	      
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
	    //Fillup the Quick view Form
	    
	    //------------------Enter the Account Name----
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();",account.qvacctName);	     
	    account.qvacctName.sendKeys(excel.getCellDataUpd("Account", "qvacctName", 1));
	     
	    //------------------Select the Account Type ----  
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",account.qvacctType);	      
	      new Select(account.qvacctType).selectByVisibleText(excel.getCellDataUpd("Account", "qvacctType", 1));
	      
	      //------------------Select the Account Status ----    
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",account.qvacctStatus);	    
	      new Select(account.qvacctStatus).selectByVisibleText(excel.getCellDataUpd("Account", "qvacctStatus", 1));
	      
	      //------------------Select the Account Lead Source ----    
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",account.qvacctLeadSrc);	    
	      new Select(account.qvacctLeadSrc).selectByVisibleText(excel.getCellDataUpd("Account", "qvacctLeadSrc", 1));
	      
	    //------------------Set the PhonoNo ----   
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",account.qvacctPhone);	     
	      account.qvacctPhone.sendKeys(excel.getCellDataUpd("Account", "qvacctPhone", 1));
	     
	    //------------------Set the Email Address ----  
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",account.qvacctEmailAddr);	      
	      account.qvacctEmailAddr.sendKeys(excel.getCellDataUpd("Account", "qvacctEmailAddr", 1));
	      
	    //------------------Set the Comments ----   
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",account.qvacctComments);	     
	      account.qvacctComments.sendKeys(excel.getCellDataUpd("Account", "qvacctComments", 1));
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.QuickViewSave);//Click the Save Button    
	   
	     	      
	      //Waiting for successful conversion message
		  WebDriverWait waitsuccessmsg= new WebDriverWait (driver, 20);
		  waitsuccessmsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
		 

		  //Validation-Account Created successfully message is appearing
		  Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Account Created"));
	
	}
      
}
