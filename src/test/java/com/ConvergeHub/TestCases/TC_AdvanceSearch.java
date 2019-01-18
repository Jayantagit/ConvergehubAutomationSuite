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
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_AdvanceSearch extends Base  
{    
	@Test(groups={"Regression"},description="Advance Search for Lead")
	
	public static void AdvanceSearch() throws InterruptedException
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
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    */
	   
	  
	    driver.get("https://staging.convergehub.com/leads");
	    
	    lead.AdvSearchBtn.click();
	    //Enter/Select the search Filters
	    lead.AdvSearchFirstNm.sendKeys("Test");
	    lead.AdvSearchLastNm.sendKeys("Test");
	    lead.AdvSearchAcctNm.sendKeys("Test");
	    
	    //Select the Search Filter for Lead source
	    lead.AdvSearchLeadSrc.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    WebElement SrchLeadSource=driver.findElement(By.id("chk_lead_source_leads_"+config.getProperty("LeadSource")));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",SrchLeadSource);
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	  
	    
	  //Select the Search Filter for Status
	    lead.AdvSearchStatus.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    WebElement SrchStatus=driver.findElement(By.id("chk_status_leads_"+config.getProperty("SrchStatus")));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",SrchStatus);
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    
	    //Select the Search Filter for Industry
	    
	    lead.AdvSearchIndustry.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    WebElement IndustrySel=driver.findElement(By.id("chk_industry_leads_"+config.getProperty("SrchIndustry")));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",IndustrySel);	     
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    
	    //Select the Search Filter for LeadType
	    lead.AdvSearchLeadType.click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    WebElement LeadType= driver.findElement(By.id("chk_type_leads_"+config.getProperty("SrchLeadType")));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",LeadType);
	   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	    
	    //-------Click the Advanced Search Button
	   //new Actions(driver).moveToElement(lead.AdvSearchButton).build().perform();
	    lead.AdvSearchButton.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	     
	    
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath("//input[@class='list_checkbox']"));
	          
	        if(Leads_num.size()>0)
	        {
	        	System.out.println("Advanced Search return result  :"+Leads_num.size());  
	        }
	        else
	        {
	        	System.out.println("No records found for the selected search criteras");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Record found for the Search");  
	    	e.printStackTrace();
	    	
	    }
	    

	    //Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Event Relation Added");//Validation Step-Event Schedule added successfully
	    
	}
      
}
