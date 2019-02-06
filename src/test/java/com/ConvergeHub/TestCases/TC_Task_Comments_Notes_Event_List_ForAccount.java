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


public class TC_Task_Comments_Notes_Event_List_ForAccount extends Base  
{  
	
	
	@Test(priority = 0,groups={"Regression"},description="Create Task for Account")
	
	public static void CreatetaskForAccount() throws InterruptedException
	{
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		
		/*-------------------------Login Code
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));	  
	    driver.get("https://staging.convergehub.com/accounts/");
	    -------------------------------------------*/
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	    /*
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
	    */
		
		//From the Select dropdown -select the option-Create Task for the generated Account
		driver.findElement(By.id("mydiv"+SavedData.getProperty("Account_ID"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		 
		 
		 //Select the Option-Create task from the Select dropdown
	    driver.findElement(By.linkText("Create Task")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    new Actions(driver).moveToElement(lead.TaskSubject).build().perform();//Set Focus on Task Subject
	    
	    lead.TaskSubject.sendKeys("Follow up Account");
	    lead.TaskSaveBtn.click();
	    
	    Assert.assertNotNull(driver.findElement(By.xpath("//span[contains(text(),'Task Relation Added')]")));
	    
	}
	
	@Test(priority = 1,groups={"Regression"},description="Add Comment To Account")
		
	public static void AddCommentToAccount() throws InterruptedException
	{
		System.out.println("2nd TC");
		LeadPage lead=new LeadPage();
		ContactPage contact=new ContactPage();
		AccountPage account=new AccountPage();
		
		/*-------------------------Login Code
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));	  
	    driver.get("https://staging.convergehub.com/accounts/");	    
	    -------------------------------------------*/
		
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		/*
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
	   */
		
		 driver.findElement(By.id("mydiv"+SavedData.getProperty("Account_ID"))).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Add Comments")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		 
		 lead.CommentTextBox.sendKeys("Test Comments \n Entered");
		 lead.CommentSaveButton.click();
	    
	    
		 Assert.assertNotNull(driver.findElement(By.xpath("//h1[@class='listcomment_heading']")));
	    
	}
	
	
@Test(priority = 2,groups={"Smoke"},description="Add Note To Account")
	
	public static void AddNoteToAccount() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		
		/*-------------------------Login Code
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));	  
	    driver.get("https://staging.convergehub.com/accounts/");
	    --------------------------------------------------------*/
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 /*
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
	    */
		int rowcnt=0;
		    
		    try
		    {
		        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
		        for(int cnt=0;cnt<Leads_num.size();cnt++)
		        {
		           String val=Leads_num.get(cnt).getAttribute("value");
		           if(val.contains(SavedData.getProperty("Account_ID")))
		           {
		        	   rowcnt=cnt+1;
		        	   break;
		           }
		     
		        }
		    	
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    
		
		driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Account_ID"))).click();
		String noteicon="(//span[contains(text(),' Notes')])["+rowcnt+"]";
		System.out.println(noteicon);
		
		//Click the Note icon for the Selected Account
		driver.findElement(By.xpath(noteicon)).click();		  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
		 
	    lead.NotesSubject.sendKeys("Test Notes");
	    lead.NotesDescription.sendKeys("Sample Description /n Entered");
	    lead.NotesSaveBtn.click();
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Note Relation Added");
	    //Assert.assertNotNull(driver.findElement(By.xpath("//span[contains(text(),'Note Relation Added']")));
	    
	}

@Test(priority = 3,groups={"Regression"},description="Schedule Event For Account")

public static void ScheduleEventForAccount() throws InterruptedException
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
    driver.get("https://staging.convergehub.com/accounts/");
    ---------------------------------------------------------*/
	 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 /*------------------Commenting the Code for Clicking the Select Dropdown of the First Account in List--------------	
    
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
    
    --------------------------------------------------------------------------------*/
	//Click the Select Dropdown of the selected Contact
	driver.findElement(By.id("mydiv"+SavedData.getProperty("Account_ID"))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	 
    
    //Select the ---Schedule Event option
    driver.findElement(By.linkText("Schedule Event")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
  //Set Focus on Event Subject
    new Actions(driver).moveToElement(lead.EventSubject).build().perform();
    
  //Enter the value in the Subject
    lead.EventSubject.sendKeys("Test Event for Account");
    
  //Enter the description in Subject
    lead.EventDescription.sendKeys("Sample Description for Account");
    
    //Click the Save button for the new Event
    lead.NotesSaveBtn.click();	
    
  //Validation Step-Event Schedule added successfully
    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Event Relation Added");
    
}

@Test(priority = 4,groups={"Regression"},description="Add Account To List")

public static void AddAccountToList() throws InterruptedException
{
	LeadPage lead=new LeadPage();
	AccountPage account=new AccountPage();
	
	/*-------------------------Login Code--------------------------------------------
	LoginPage login=new LoginPage();		
	login.username.clear();
    login.username.sendKeys(config.getProperty("UserName"));
	login.password.sendKeys(config.getProperty("Password"));
    login.login.click();
    System.out.println("Successfully Logged");
    wait=new WebDriverWait(driver,20); 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));	  
   	driver.get("https://staging.convergehub.com/accounts/");
   -----------------------------------------------------------------------------*/
	//Navigating to the Account List Page
	driver.get("https://"+config.getProperty("Environment")+".convergehub.com/accounts/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	//Click the Select checkbox of the selected Account
	driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Account_ID"))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	
	//Select the Refer option from the Select Dropdown
	lead.Actiondropdown.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Add to List")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait.until(ExpectedConditions.visibilityOf(lead.ListName));
    
    //Enter the List Name	   
    String ListName=excel.getCellDataUpd("Account", "ListName", 1);
    lead.ListName.sendKeys(ListName);
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    
    //Click the Add To List Button
    lead.AddToListBtn.click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='header_notification_msg']"))));
    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Relation Added to List"));
  
    
}
      
}
