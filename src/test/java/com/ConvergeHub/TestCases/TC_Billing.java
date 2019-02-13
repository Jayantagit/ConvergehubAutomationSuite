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
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.AccountPage;
import com.ConvergeHub.Pages.ActivitiesPage;
import com.ConvergeHub.Pages.BillingPage;
import com.ConvergeHub.Pages.CasePage;
import com.ConvergeHub.Pages.CollaborationPage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_Billing extends Base  
{    
	@Test(priority=0,groups={"Regression"},description="Create a New Product from Billing Module")
	
	public static void AddProduct() throws InterruptedException
	{
		//Initialize the Page Class
		DealPage deal=new DealPage();
		CasePage casepg=new CasePage();
		ActivitiesPage activities=new ActivitiesPage();
		BillingPage billing=new BillingPage();
	
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
	    
		//Redirecting to the Add Product Page
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/products/add/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Product Screen=====================
		
		//------Enter Product Name		
	    String prodName=excel.getCellDataUpd("Billing","productName", 1);
	    billing.productName.sendKeys(prodName);    
	   
	    //------Select the Product Type	   
	    String prodType=excel.getCellDataUpd("Billing","productType", 1);
	    new Select(billing.productType).selectByVisibleText(prodType);
	    
   
		//------Enter the Product Price
	    String prodPrice=excel.getCellDataUpd("Billing","productPrice", 1);
	    billing.productPrice.sendKeys(prodPrice);
	    
	    //------Select the Product Category   
	    String prodCategory=excel.getCellDataUpd("Billing","productCategory", 1);
	    new Select(billing.productCategory).selectByVisibleText(prodCategory);
	    
	    //------Select the Product Status   
	    String prodStatus=excel.getCellDataUpd("Billing","productStatus", 1);
	    new Select(billing.productStatus).selectByVisibleText(prodStatus);
	    
	    //Enter the Save Button
	  	billing.btnproductSave.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait waittasksave = new WebDriverWait (driver, 20);
	    waittasksave.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Created"));
	    
	  	String  baseurl=driver.getCurrentUrl();
		String arr[]=baseurl.split("/");		
		String Product_ID=arr[arr.length-1];
		TestUtil.writeProperty("Product_ID", Product_ID);  
	    	
	}
	
	@Test(priority = 1,groups={"Regression"},description="Edit a Product")

	public static void editProduct() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		CollaborationPage clb=new CollaborationPage();
		ActivitiesPage activities=new ActivitiesPage();
		BillingPage billing=new BillingPage();
		
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

	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/products/add/"+SavedData.getProperty("Product_ID"));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	     
	    //------Select the new Type	   
	    String Typenew=excel.getCellDataUpd("Billing","edtType", 1);
	    new Select(billing.productType).selectByVisibleText(Typenew);
	    
	    //------Select the new Category
	    String Categorynew=excel.getCellDataUpd("Billing","edtCategory", 1);
	    new Select(billing.productCategory).selectByVisibleText(Categorynew);
	    
		//------Enter the Product Description
	    String productDescriptionnew=excel.getCellDataUpd("Billing","edtDescription", 1);
	    billing.productDescription.clear();
	    billing.productDescription.sendKeys(productDescriptionnew);
	    
	    
	    //Click the Save button after Editing
	    billing.btnproductSave.click();
	    
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	    
	    ////Validation that Product edited successfully
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Updated"));
	 
	    
	}
	
		
}
