package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_Add_Comment_NoteToDeal extends Base  
{    
	@Test(groups={"Regression"},description="Add Comment Deal")
	
	public static void AddCommentToDeal() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		
		/*
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));*/
	  
	    driver.get("https://staging.convergehub.com/deals/");
	    
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
	    
	   lead.CommentIcon.click();
	   lead.CommentTextBox.sendKeys("Test Comments\n Entered for the Deal");
	   lead.CommentSaveButton.click();
	    
	    
	    Assert.assertNotNull(driver.findElement(By.xpath("//h1[@class='listcomment_heading']")));
	    
	}
	
	
@Test(groups={"Regression"},description="Add Note To Deal")
	
	public static void AddNoteToDeal() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		
		/*
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));*/
	  
	    driver.get("https://staging.convergehub.com/deals/");
	    
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>0)
	        {
	        	Leads_num.get(0).click();//Click the First Deal in the List
	        }
	        else
	        {
	        	System.out.println("No Deal is present in the Deal List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    lead.NotesIcon.click();
	    lead.NotesSubject.sendKeys("Test Notes for Deal");
	    lead.NotesDescription.sendKeys("Sample Description /n Entered");
	    lead.NotesSaveBtn.click();
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Note Relation Added");
	    //Assert.assertNotNull(driver.findElement(By.xpath("//span[contains(text(),'Note Relation Added']")));
	    
	}
      
}
