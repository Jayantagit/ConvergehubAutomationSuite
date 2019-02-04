package com.ConvergeHub.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LoginPage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_AddDeal extends Base  
{   
	
	static AtomicInteger sequenceDeal = new AtomicInteger(0);
	
	@Test(groups={"Regression"},description="Create a New Deal",invocationCount=2)
	
	public static void DealCreation() throws InterruptedException
	{
		
		DealPage deal=new DealPage();
		
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
	  
	    //Navigate to the Deals Add Page
	    //driver.get("https://staging.convergehub.com/deals/add");
		
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/deals/add");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //===========Filled up the Add Deal Screen=====================
	    //------Enter the Deal Name
	    deal.DealName.clear();
	    //String DealNm=excel.GetCellData("Deal", 1, 0);
	    String DealNm=excel.getCellDataUpd("Deal","DealName", 1);
	    deal.DealName.sendKeys(DealNm);
	    
	  //------Enter the Deal Type
	    //String DealType=excel.GetCellData("Deal", 1, 1);
	    String DealType=excel.getCellDataUpd("Deal","DealType",1);
	    new Select(deal.DealType).selectByVisibleText(DealType);
	    
	  //------Select the First Account Name in the DropDown list
	    deal.DealAccountNm.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(deal.DealAccountNmFirst));
	    deal.DealAccountNmFirst.click();
	    
	  //------Select the Deal Currency as USD
	    String dealCurrency=excel.getCellDataUpd("Deal","Currency", 1);
	    new Select(deal.DealCurrency).selectByVisibleText(dealCurrency);
	  
	  //------Enter the Deal Amount
	    deal.DealAmount.sendKeys("100");
	    
	  //------Select the Lead Source of the Deal
	    //String LeadSource=excel.GetCellData("Deal", 1, 2);
	    String LeadSource=excel.getCellDataUpd("Deal","LeadSource", 1);
	    new Select(deal.DealLeadSource).selectByVisibleText(LeadSource);
	    
	    //------Select the Stage Stage of the Deal
	     // String SalesStage=excel.GetCellData("Deal", 1, 3);
	    String SalesStage=excel.getCellDataUpd("Deal", "SalesStage", 1);
	    new Select(deal.DealSalesStage).selectByVisibleText(SalesStage);
	    
	    //Enter the Comment
	    deal.DealDescription.sendKeys("Sample Test");
	    deal.DealSaveBtn.click();
	    
	    //Assertion statement to be added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    //Verification Statement-Deal successful creation
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Deal Created"));
	    
	    //Updating the Property file
	    int currentCountDeal= sequenceDeal.addAndGet(1);
	    String  baseurlDeal=driver.getCurrentUrl();
	    String arrDeal[]=baseurlDeal.split("/");
		
		String Deal_ID=arrDeal[arrDeal.length-1];
		System.out.println(Deal_ID);
		
		
		System.out.println(currentCountDeal);
		if(currentCountDeal>1)
		{
			//Deal.setProperty("Deal_Id_New", Deal_ID);
			TestUtil.writeProperty("Deal_Id_New", Deal_ID);
		}
		else
		{
			//Deal.setProperty("Deal_Id", Deal_ID);
			TestUtil.writeProperty("Deal_Id", Deal_ID);
		}
		
		/*
		try 
		{			
			Deal.store(fosDeal,"Saved");
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		*/
	    
	
	}
      
}
