package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_EditLead extends Base  
{    
	@Test(groups={"Regression"},description="Edit a Lead")
	
	public static void editLead() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		
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
		
		System.out.println("https://"+config.getProperty("Environment")+".convergehub.com/leads/add/"+SavedData.getProperty("Lead_Id"));
	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/leads/add/"+SavedData.getProperty("Lead_Id"));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    /*
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>0)
	        {
	        	Leads_num.get(0).click();//Click the First Lead in the List
	        }
	        else
	        {
	        	System.out.println("No Lead is present in the Lead List"); 
	        	
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    lead.EditIcon.click();
	    
	   
	    int random = (int )(Math.random() * 50 + 1); 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	    lead.FirstName.clear(); //Clear the existing value in First Name
	    lead.FirstName.sendKeys("Test"+String.valueOf(random)); //Update First Name
	    
	    lead.LasttName.clear(); //Clear the existing value in Last Name
	    lead.LasttName.sendKeys("Test"+String.valueOf(random)); //Update Last Name
	    
	    lead.EmailAddress.clear();//Clear the existing value in Last Name
	    lead.EmailAddress.sendKeys("Test"+String.valueOf(random)+"@test.com"); //Update Email Address
	    	    
	    */
	    
	    //Select the new  Lead Status
	    lead.LeadStatus.click();
	    //String LeadStatusNew=excel.GetCellData("Lead", 1, 10);
	    String LeadStatusNew=excel.getCellDataUpd("Lead", "LeadStatusNew", 1);
	    new Select(lead.LeadStatus).selectByVisibleText(LeadStatusNew);
	    
	    //Enter the new Email address
	    lead.EmailAddress.clear();
	    //String LeadEmailNew=excel.GetCellData("Lead", 1, 11);
	    String LeadEmailNew=excel.getCellDataUpd("Lead", "LeadEmailNew", 1);
	    lead.EmailAddress.sendKeys(LeadEmailNew);
	    
	    //Select the new  Industry
	   // String LeadIndustryNew=excel.GetCellData("Lead", 1, 12);
	    String LeadIndustryNew=excel.getCellDataUpd("Lead", "LeadIndustryNew", 1);
	    new Select(lead.Industry).selectByVisibleText(LeadIndustryNew);
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    
	    
	    //Click the Save button after Editing
	    lead.LeadSave.click();
	    
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	     
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Lead Updated");//Validation that Lead edited successfully
	    
	}
      
}
