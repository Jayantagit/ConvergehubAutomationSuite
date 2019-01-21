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
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AdvanceSearch_Deal extends Base  
{    
	@Test(groups={"Regression"},description="Advance Search for Lead")
	
	public static void AdvanceSearch() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		
	   /*-------------Login section needed if executed this TC separately   */
		/*
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    */
	  
	  
	    driver.get("https://staging.convergehub.com/deals/");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    //Click the Advanced Search button
	    deal.AdvSearchBtn.click();
	    
	    //Enter/Select the search Filters	       
	    String SrchDealNm=excel.GetCellData("Deal", 1, 4);
	    deal.SrchName.sendKeys(SrchDealNm);
	    
	        
	    //Select the Search Filter for Account Name
	    deal.SrchAcctName.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",deal.DealAccountNmFirst);
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	      
	     //Select the Search Filter for DealType
	    deal.SrchDealType.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    String srcdealType=excel.GetCellData("Deal", 1, 5);
	    WebElement SrchDealTypeval=driver.findElement(By.id("chk_deal_type_deals_"+srcdealType));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",SrchDealTypeval);
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    
	    //Select the Search Filter for LeadSource
	    deal.SrchLeadSource.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    String srcLeadSource=excel.GetCellData("Deal", 1, 6);
	    WebElement srcLeadSourceval=driver.findElement(By.id("chk_lead_source_deals_"+srcLeadSource));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",srcLeadSourceval);	     
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    
	    //Select the Search Filter for Sales Stage
	    deal.SrchSalesStage.click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    String srcSalesstageval=excel.GetCellData("Deal", 1, 7);
	    WebElement SalesStage= driver.findElement(By.id("chk_sales_stage_deals_"+srcSalesstageval));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",SalesStage);
	   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	    
	    //-------Click the Advanced Search Button
	    lead.AdvSearchButton.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	     
	    
	    try
	    {
	        List<WebElement> deals_num=driver.findElements(By.xpath("//input[@class='list_checkbox']"));
	          
	        if(deals_num.size()>0)
	        {
	        	System.out.println("Advanced Search return result  :"+deals_num.size());  
	        }
	        else
	        {
	        	System.out.println("No Deals found for the selected search criteras");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Deal found for the Search");  
	    	e.printStackTrace();
	    	
	    }
	    

	    //Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Event Relation Added");//Validation Step-Event Schedule added successfully
	    
	}
      
}
