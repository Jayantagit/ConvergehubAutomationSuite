package com.ConvergeHub.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.MarketingPage;
import com.ConvergeHub.Pages.CasePage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_Marketing extends Base  
{    
	@Test(priority=0,groups={"Regression"},description="Create a New Template")
	
	public static void templateCreation() throws InterruptedException
	{
		//Initialize the Page Class
		DealPage deal=new DealPage();
		CasePage casepg=new CasePage();
		MarketingPage mp=new MarketingPage();
		
	
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
	    
		//Redirecting to the Add Template Page
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/templates/add/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Template Screen=====================
		
		//------Enter the Template Name		
	    String templateName=excel.getCellDataUpd("Marketing","TemplateName", 1);
	    mp.templateName.sendKeys(templateName);
	    
		//------Enter the Template Subject	
	    String templateSubject=excel.getCellDataUpd("Marketing","TemplateSubject", 1);
	    mp.Subject.sendKeys(templateSubject);	    
   
		//------Enter the Template Body
	    driver.switchTo().frame("body_html_ifr");
	    String templateBody=excel.getCellDataUpd("Marketing", "TemplateBody", 1);
	  	driver.findElement(By.cssSelector("body")).sendKeys(templateBody);
	  	driver.switchTo().defaultContent();
	    
	    //Enter the Save Button
	  	mp.templateSubmit.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Created"));
	    
	  	String  baseurl=driver.getCurrentUrl();
		String arr[]=baseurl.split("/");		
		String Template_ID=arr[arr.length-1];
		TestUtil.writeProperty("Template_ID", Template_ID);  
	    	
	}
	

}
