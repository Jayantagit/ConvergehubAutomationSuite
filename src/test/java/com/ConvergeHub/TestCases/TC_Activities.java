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
import com.ConvergeHub.Pages.CasePage;
import com.ConvergeHub.Pages.CollaborationPage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_Activities extends Base  
{    
	@Test(priority=0,groups={"Regression"},description="Create a New Task from Activity Module")
	
	public static void ActivitiesTaskCreation() throws InterruptedException
	{
		//Initialize the Page Class
		DealPage deal=new DealPage();
		CasePage casepg=new CasePage();
		ActivitiesPage activities=new ActivitiesPage();
		
	
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
	    
		//Redirecting to the Add Task Page
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/tasks/add");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Task Screen=====================
		
		//------Enter Task Name		
	    String taskName=excel.getCellDataUpd("Activities","TaskName", 1);
	    activities.taskName.sendKeys(taskName);	    
	   
	    //------Select the Task Priority	   
	    String taskPriority=excel.getCellDataUpd("Activities","TaskPriority", 1);
	    new Select(activities.taskPriority).selectByVisibleText(taskPriority);
	    
	    //------Select the Task Status
	    String taskStatus=excel.getCellDataUpd("Activities","TaskStatus", 1);
	    new Select(activities.taskStatus).selectByVisibleText(taskStatus);
	    
		//------Enter the Task Description
	    String taskDescription=excel.getCellDataUpd("Activities","TaskDescription", 1);
	    activities.taskDescription.sendKeys(taskDescription);
	    
	    //Enter the Save Button
	  	activities.btnSave.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait waittasksave = new WebDriverWait (driver, 20);
	    waittasksave.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Created"));
	    
	  	String  baseurl=driver.getCurrentUrl();
		String arr[]=baseurl.split("/");		
		String Event_Task_ID=arr[arr.length-1];
		TestUtil.writeProperty("Event_Task_ID", Event_Task_ID);  
	    	
	}
	
	@Test(priority = 1,groups={"Regression"},description="Edit a Task under Activity Module")

	public static void editActivityTask() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		CollaborationPage clb=new CollaborationPage();
		ActivitiesPage activities=new ActivitiesPage();
		
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

	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/tasks/add/"+SavedData.getProperty("Event_Task_ID"));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	     
	    //------Select the Task Priority	   
	    String taskPrioritynew=excel.getCellDataUpd("Activities","EdtTaskPriority", 1);
	    new Select(activities.taskPriority).selectByVisibleText(taskPrioritynew);
	    
	    //------Select the Task Status
	    String taskStatusnew=excel.getCellDataUpd("Activities","EdtTaskStatus", 1);
	    new Select(activities.taskStatus).selectByVisibleText(taskStatusnew);
	    
		//------Enter the Task Description
	    String taskDescriptionnew=excel.getCellDataUpd("Activities","EdtTaskDescription", 1);
	    activities.taskDescription.clear();
	    activities.taskDescription.sendKeys(taskDescriptionnew);
	    
	    
	    //Click the Save button after Editing
	    activities.btnSave.click();
	    
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	    
	    ////Validation that Partner edited successfully
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Updated"));
	   // Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Updated");
	    
	}
	
	@Test(priority=2,groups={"Regression"},description="Create a New Note from Activity Module")
	
	public static void ActivitiesNoteCreation() throws InterruptedException
	{
		//Initialize the Page Class
		DealPage deal=new DealPage();
		CasePage casepg=new CasePage();
		ActivitiesPage activities=new ActivitiesPage();
		
	
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
	    
		//Redirecting to the Add Note Page
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/notes/add");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Note Screen=====================
		
		//------Enter Note Subject		
	    String noteSubject=excel.getCellDataUpd("Activities","NoteSubject", 1);
	    activities.noteSubject.sendKeys(noteSubject);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	  //------Enter the Note Description
	    driver.switchTo().frame("notes_description_ifr");
	    String noteDescription=excel.getCellDataUpd("Activities","NoteDescription", 1);
	  	driver.findElement(By.cssSelector("body")).sendKeys(noteDescription);
	  	driver.switchTo().defaultContent();
	    
	    //Enter the Save Button
	  	activities.btnNoteSave.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait waitnoteSave = new WebDriverWait (driver, 20);
	    waitnoteSave.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Created"));
	    
	  	String  baseurl=driver.getCurrentUrl();
		String arr[]=baseurl.split("/");		
		String Activity_Note_ID=arr[arr.length-1];
		TestUtil.writeProperty("Activity_Note_ID", Activity_Note_ID);  
	    	
	}
	
	@Test(priority = 3,groups={"Regression"},description="Edit a Note under Activity Module")

	public static void editActivityNote() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		CollaborationPage clb=new CollaborationPage();
		ActivitiesPage activities=new ActivitiesPage();
		
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

	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/notes/add/"+SavedData.getProperty("Activity_Note_ID"));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	     
		//------Edit Note Subject		
	    String noteSubjectedt=excel.getCellDataUpd("Activities","EdtNoteSubject", 1);
	    activities.noteSubject.clear();
	    activities.noteSubject.sendKeys(noteSubjectedt);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	  //------Edit Note Description
	    driver.switchTo().frame("notes_description_ifr");
	    String noteDescriptionedt=excel.getCellDataUpd("Activities","EdtNoteDescription", 1);
	    driver.findElement(By.cssSelector("body")).clear();
	  	driver.findElement(By.cssSelector("body")).sendKeys(noteDescriptionedt);
	  	driver.switchTo().defaultContent();
	    
	    
	    //Click the Save button after Editing
	    activities.btnNoteSave.click();
	    
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	    
	    ////Validation that Note edited successfully
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Updated"));
	   
	    
	}
	
	@Test(priority=4,groups={"Regression"},description="Create a New Event from Activity Module")
	
	public static void ActivitiesEventCreation() throws InterruptedException
	{
		//Initialize the Page Class
		DealPage deal=new DealPage();
		CasePage casepg=new CasePage();
		ActivitiesPage activities=new ActivitiesPage();
		
	
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
	    
		//Redirecting to the Add Event Page
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/events/add/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Event Screen=====================
		
		//------Select Event Type	
	    String eventType=excel.getCellDataUpd("Activities","EventType", 1);
	    new Select(activities.eventType).selectByVisibleText(eventType);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
		//------Enter Event Name	
	    String eventName=excel.getCellDataUpd("Activities","EventName", 1);
	    activities.eventName.sendKeys(eventName);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
		//------Select Event Status	
	    String eventStatus=excel.getCellDataUpd("Activities","EventStatus", 1);
	    new Select(activities.eventStatus).selectByVisibleText(eventStatus);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//------Enter Event Description	
	    String eventDescription=excel.getCellDataUpd("Activities","EventDescription", 1);
	    activities.eventDescription.sendKeys(eventDescription);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    //Click the Invitee Tab
	    driver.findElement(By.linkText("Invitees")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Enter the Invitee email
	    activities.eventSendTo.click();
	    String eventInvitee=excel.getCellDataUpd("Activities","Invitees", 1);
	    activities.InviteeEmail.sendKeys(eventInvitee);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    
	    //Click the Save Button
	  	activities.btnSave.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait waitnoteSave = new WebDriverWait (driver, 30);
	    waitnoteSave.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Created"));
	    
	  	String  baseurl=driver.getCurrentUrl();
		String arr[]=baseurl.split("/");		
		String Activity_Event_ID=arr[arr.length-1];
		TestUtil.writeProperty("Activity_Event_ID", Activity_Event_ID);  
	    	
	}	
	
	@Test(priority = 5,groups={"Regression"},description="Edit a Event under Activity Module")

	public static void editActivityEvent() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		CollaborationPage clb=new CollaborationPage();
		ActivitiesPage activities=new ActivitiesPage();
		
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

	    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/events/add/"+SavedData.getProperty("Activity_Event_ID"));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    //Edit Event Status
	    String eventstatusUpd=excel.getCellDataUpd("Activities","EdtEventStatus", 1);
	    new Select(activities.eventStatus).selectByVisibleText(eventstatusUpd);
	    
	    //Edit Event Priority
	    String eventpriorityUpd=excel.getCellDataUpd("Activities","EdtEventPriority", 1);
	    new Select(activities.EventPriority).selectByVisibleText(eventpriorityUpd);
	     
		//------Edit Event Description		
	    String eventDescriptionupd=excel.getCellDataUpd("Activities","EdtEventDescription", 1);
	    activities.eventDescription.clear();
	    activities.eventDescription.sendKeys(eventDescriptionupd);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	   
      
	    //Click the Save button after Editing
	    activities.btnSave.click();
	    
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	    
	    ////Validation that Note edited successfully
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Updated"));
	   
	    
	}
	
}
