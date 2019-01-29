package com.ConvergeHub.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AddLead_QuickView extends Base  
{    
	@Test(groups={"Regression"},description="Create New Lead through Quick View")
	
	public static void LeadCreationQuickView() throws InterruptedException
	{	
		LeadPage lead=new LeadPage();
	/*
		LoginPage login=new LoginPage();
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='icon search-top']")));
	   // driver.get("https://staging.convergehub.com/leads/add");
	    
	  */
	   
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/leads");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  Actions actions = new Actions(driver);
		  WebElement mainMenu = driver.findElement(By.linkText("Sales"));
		  actions.moveToElement(mainMenu).build().perform();;
	    
	      actions.moveToElement(lead.QuickViewicon).build().perform();
	      lead.QuickViewicon.click();
	      
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
	      //Fillup the Quick view Form
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.FirstNamepopup);
	     // lead.FirstNamepopup.sendKeys(excel.GetCellData("Lead", 1, 21));
	      lead.FirstNamepopup.sendKeys(excel.getCellDataUpd("Lead", "FirstNamepopup", 1));
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.LastNamepopup);
	      //lead.LastNamepopup.sendKeys(excel.GetCellData("Lead", 1, 22));
	      lead.LastNamepopup.sendKeys(excel.getCellDataUpd("Lead", "LastNamepopup", 1));
	      
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.AccountNamepopup);
	     // lead.AccountNamepopup.sendKeys(excel.GetCellData("Lead", 1, 23));
	      lead.AccountNamepopup.sendKeys(excel.getCellDataUpd("Lead", "AccountNamepopup", 1));
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.LeadSourcepopup);
	      //new Select(lead.LeadSourcepopup).selectByVisibleText(excel.GetCellData("Lead", 1, 24));
	      new Select(lead.LeadSourcepopup).selectByVisibleText(excel.getCellDataUpd("Lead","LeadSourcepopup",1));
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.Statuspopup);
	     // new Select(lead.Statuspopup).selectByVisibleText(excel.GetCellData("Lead", 1, 25));
	      new Select(lead.Statuspopup).selectByVisibleText(excel.getCellDataUpd("Lead", "Statuspopup", 1));
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.Phonepopup);
	      //lead.Phonepopup.sendKeys(excel.GetCellData("Lead", 1, 26));
	      lead.Phonepopup.sendKeys(excel.getCellDataUpd("Lead", "Phonepopup", 1));
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.Emailpopup);
	      //lead.Emailpopup.sendKeys(excel.GetCellData("Lead", 1, 27));
	      lead.Emailpopup.sendKeys(excel.getCellDataUpd("Lead", "Emailpopup", 1));
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.Commentpopup);
	      //lead.Commentpopup.sendKeys(excel.GetCellData("Lead", 1, 28));
	      lead.Commentpopup.sendKeys(excel.getCellDataUpd("Lead", "Commentpopup", 1));
	      
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",lead.QuickViewSave);//Click the Save Button
	      //lead.SaveandNew.click();
	    
	     	      
	      //Waiting for successful conversion message
		  WebDriverWait waitsuccessmsg= new WebDriverWait (driver, 20);
		  waitsuccessmsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
		 
		  /*-----------------Quick View not generating the Lead Id in the URL-So not able to capture the value
		    String  baseurlqv=driver.getCurrentUrl();
		    String arrqv[]=baseurlqv.split("/");
			
			String Lead_ID_QV=arrqv[arrqv.length-1];
			System.out.println(Lead_ID_QV);
			
			//excel.SetCellData("ID", 1, 0, Lead_ID);
			
			SavedData.put("Lead_Id_QuickView", Lead_ID_QV);
			try {
				SavedData.store(fos, "saving");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		---------------------------------------------------------------------------------------------------*/	
		    
		  //Validation-Lead Converted successfully message is appearing
		  Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Lead Created"));
	
	}
      
}
