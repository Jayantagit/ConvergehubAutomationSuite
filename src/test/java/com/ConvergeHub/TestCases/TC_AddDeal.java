package com.ConvergeHub.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AddDeal extends Base  
{    
	@Test(groups={"Regression"},description="Create a New Deal")
	
	public static void DealCreation() throws InterruptedException
	{
		
		DealPage deal=new DealPage();
		
		//Login Function-Start
		LoginPage login=new LoginPage();
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    //Login Code-End
	  
	    //Navigate to the Deals Add Page
	    driver.get("https://staging.convergehub.com/deals/add");
	    
	    //===========Filled up the Add Deal Screen=====================
	    //------Enter the Deal Name
	    deal.DealName.clear();
	    String DealNm=excel.GetCellData("Deal", 1, 0);
	    deal.DealName.sendKeys(DealNm);
	    
	  //------Enter the Deal Type
	    String DealType=excel.GetCellData("Deal", 1, 1);
	    new Select(deal.DealType).selectByVisibleText(DealType);
	    
	  //------Select the First Account Name in the Dropdown list
	    deal.DealAccountNm.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(deal.DealAccountNmFirst));
	    deal.DealAccountNmFirst.click();
	    
	  //------Select the Deal Currency as USD
	    new Select(deal.DealCurrency).selectByVisibleText("USD");
	  
	  //------Enter the Deal Amount
	    deal.DealAmount.sendKeys("100");
	    
	  //------Select the Lead Source of the Deal
	    String LeadSource=excel.GetCellData("Deal", 1, 2);
	    new Select(deal.DealLeadSource).selectByVisibleText(LeadSource);
	    
	    //------Select the Stage Stage of the Deal
	    String SalesStage=excel.GetCellData("Deal", 1, 3);
	    new Select(deal.DealSalesStage).selectByVisibleText(SalesStage);
	    
	    //Enter the Comment
	    deal.DealDescription.sendKeys("Sample Test");
	    deal.DealSaveBtn.click();
	    
	    //Assertion statement to be added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Deal Created"));
	    
	
	}
      
}
