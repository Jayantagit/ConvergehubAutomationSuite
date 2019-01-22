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
import com.ConvergeHub.Pages.AccountPage;
import com.ConvergeHub.Pages.ContactPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_CreateTask_Comments_Notes_ScheduleEvent_ForAccount extends Base  
{    
	@Test(groups={"Regression"},description="Create Task for Account")
	
	public static void CreatetaskforContact() throws InterruptedException
	{
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		
		/*
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));*/
	  
	    driver.get("https://staging.convergehub.com/accounts/");
	    
	    try
	    {
	        List<WebElement> account_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(account_num.size()>0)
	        {
	        	account_num.get(0).click();//Click the First Account in the List
	        }
	        else
	        {
	        	System.out.println("No Account is present in the Account List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    account.acctSelect.click();
	    driver.findElement(By.linkText("Create Task")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    new Actions(driver).moveToElement(lead.TaskSubject).build().perform();//Set Focus on Task Subject
	    
	    lead.TaskSubject.sendKeys("New Contacts");
	    lead.TaskSaveBtn.click();
	    
	    Assert.assertNotNull(driver.findElement(By.xpath("//span[contains(text(),'Task Relation Added')]")));
	    
	}
	
	@Test(groups={"Regression"},description="Add Comment To Account")
	
	public static void AddCommentToAccount() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		ContactPage contact=new ContactPage();
		AccountPage account=new AccountPage();
		
		/*
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));*/
	  
	    driver.get("https://staging.convergehub.com/accounts/");
	    
	    try
	    {
	        List<WebElement> acct_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(acct_num.size()>0)
	        {
	        	acct_num.get(0).click();//Click the First Account in the List
	        }
	        else
	        {
	        	System.out.println("No account is present in the Account List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	   lead.CommentIcon.click();
	   lead.CommentTextBox.sendKeys("Test Comments \n Entered");
	   lead.CommentSaveButton.click();
	    
	    
	    Assert.assertNotNull(driver.findElement(By.xpath("//h1[@class='listcomment_heading']")));
	    
	}
	
	
@Test(groups={"Regression"},description="Add Note To Account")
	
	public static void AddNoteToAccount() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		
		/*
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));*/
	  
	    driver.get("https://staging.convergehub.com/accounts/");
	    
	    try
	    {
	        List<WebElement> acct_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(acct_num.size()>0)
	        {
	        	acct_num.get(0).click();//Click the First Account in the List
	        }
	        else
	        {
	        	System.out.println("No account is present in the Account List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    lead.NotesIcon.click();
	    lead.NotesSubject.sendKeys("Test Notes");
	    lead.NotesDescription.sendKeys("Sample Description /n Entered");
	    lead.NotesSaveBtn.click();
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Note Relation Added");
	    //Assert.assertNotNull(driver.findElement(By.xpath("//span[contains(text(),'Note Relation Added']")));
	    
	}

@Test(groups={"Regression"},description="Schedule Event for Account")

public static void ScheduleEventforContact() throws InterruptedException
{
	LeadPage lead=new LeadPage();
	DealPage deal=new DealPage();
	ContactPage contact=new ContactPage();
	AccountPage account=new AccountPage();
	
	/*-------------Login section needed if executed this TC separately
	LoginPage login=new LoginPage();		
	login.username.clear();
    login.username.sendKeys(config.getProperty("UserName"));
	login.password.sendKeys(config.getProperty("Password"));
    login.login.click();
    System.out.println("Successfully Logged");
    wait=new WebDriverWait(driver,20); 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
    */
  
    driver.get("https://staging.convergehub.com/accounts/");
    
    try
    {
        List<WebElement> acct_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
          
        if(acct_num.size()>0)
        {
        	acct_num.get(0).click();//Click the First Account in the List
        }
        else
        {
        	System.out.println("No account is present in the List");      
        }
    	
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    
    //Click the Select dropdown for the First Contact in the List
    lead.LeadListSelection.click();
    
    //Select the ---Schedule Event option
    driver.findElement(By.linkText("Schedule Event")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
  //Set Focus on Event Subject
    new Actions(driver).moveToElement(lead.EventSubject).build().perform();
    
  //Enter the value in the Subject
    lead.EventSubject.sendKeys("Test Event for Account");
    
  //Enter the description in Subject
    lead.EventDescription.sendKeys("Sample Description for Contact");
    
    //Click the Save button for the new Event
    lead.NotesSaveBtn.click();	
    
  //Validation Step-Event Schedule added successfully
    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Event Relation Added");
    
}
      
}
