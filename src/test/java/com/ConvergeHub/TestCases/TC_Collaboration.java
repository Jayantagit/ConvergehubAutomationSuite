package com.ConvergeHub.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.AccountPage;
import com.ConvergeHub.Pages.CollaborationPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_Collaboration extends Base  
{   
	static AtomicInteger sequence = new AtomicInteger(0);
	@Test(priority = 0,groups={"Regression"},description="Create New Partner",invocationCount=2)
	
	public static void AddPartner() throws InterruptedException
	{	
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		CollaborationPage clb=new CollaborationPage();
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
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='icon search-top']")));
	   driver.get("https://staging.convergehub.com/leads/add");
		-------------------------------------------*/
	   
		
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/partner/add/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Partner Screen=====================
	    
	    //------Enter the Partner Name
	    String partnerName=excel.getCellDataUpd("Collaboration", "Name", 1);	    
	    clb.partnerName.click();
	    clb.partnerName.sendKeys(partnerName);
	    
	    //------Select the Partner RelationShip
	    String Relationship=excel.getCellDataUpd("Collaboration", "Relationship", 1);
	    new Select(clb.partnerRelationship).selectByVisibleText(Relationship);
	    
	    //------Select the Partner  Type
	    String partnerType=excel.getCellDataUpd("Collaboration", "Type", 1);//Fetch the value of Partner Type from Test Data
	    new Select(clb.partnerType).selectByVisibleText(partnerType);
	    
	    //------Enter the Partner Phone
	    String partnerPh=excel.getCellDataUpd("Collaboration", "Phone", 1);//Fetch the value of Partner Phone from Test Data
	    clb.partnerPhno.sendKeys(partnerPh);
	    
 	    
	    //------Enter the Email Address
        Random rand = new Random(); 
        
        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(1000); 
	    clb.partnerEmail.clear();
	   // String emailVal=excel.getCellDataUpd("Collaboration", "Email", 1);//Fetch the value of Partner email address from Test Data
	    clb.partnerEmail.sendKeys("Test"+rand_int1+"@mailinator.com");
	    
	    //--------Select the Partner Image
	    
	   // clb.partnerImg.click();
	    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ImgPath=System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\"+excel.getCellDataUpd("Collaboration", "ImagePath", 1);
		System.out.println(ImgPath);
		WebElement elementPartner= driver.findElement(By.id("image"));	
	
		elementPartner.sendKeys(ImgPath);
		//clb.partnerImg.sendKeys(ImgPath);
		
		 // hit enter	 
		/*
			try 
			{
				Robot r1 = new Robot();
				r1.keyPress(KeyEvent.VK_ENTER);
			  	r1.keyRelease(KeyEvent.VK_ENTER);
			} 
			catch (AWTException e) 
			{
				
				e.printStackTrace();
			}
			*/
	    
	    //Enter the Save Button
		account.acctSaveBtn.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    int currentCountAccount= sequence.addAndGet(1);
	    
	    
	    String  baseurl=driver.getCurrentUrl();
	    String arr[]=baseurl.split("/");
		
		String Partner_ID=arr[arr.length-1];
		System.out.println(Partner_ID);
		
		System.out.println(currentCountAccount);
		if(currentCountAccount>1)
		{
			TestUtil.writeProperty("Partner_ID_New", Partner_ID);
		}
		else
		{
			TestUtil.writeProperty("Partner_ID", Partner_ID);
		}
	    
		//Verification Statement added for Partner Creation
	     Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Partner Created"));
	    	
	
	}
	
@Test(priority = 1,groups={"Regression"},description="Add Partner To List")
	
	public static void AddPartnerToList() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		AccountPage account=new AccountPage();
		CollaborationPage clb=new CollaborationPage();
		
	  
	   //Navigate to the Partner List page
		 driver.get("https://"+config.getProperty("Environment")+".convergehub.com/partner/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Click the Select checkbox of the selected Partner
		driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Partner_ID"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//Select the Add To List option from the Select Dropdown
		lead.Actiondropdown.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Add to List")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.visibilityOf(lead.ListName));
	    
	    //Enter the List Name
	   
	    String ListName=excel.getCellDataUpd("Collaboration", "ListName", 1);
	    lead.ListName.sendKeys(ListName);
	    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	    
	    //Click the Add To List Button
	    lead.AddToListBtn.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='header_notification_msg']"))));
	    
	    //Verification point-Successful message of adding to List
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText().contains("Relation Added to List"));
	   
	    
	}

@Test(priority = 2,groups={"Regression"},description="Edit a Partner")

public static void editPartner() throws InterruptedException
{
	LeadPage lead=new LeadPage();
	AccountPage account=new AccountPage();
	CollaborationPage clb=new CollaborationPage();
	
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

    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/partner/add/"+SavedData.getProperty("Partner_ID"));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
     
    //Change the Relationship Status
    String RelationshipNew=excel.getCellDataUpd("Collaboration", "EditRelationship", 1);
    new Select(clb.partnerRelationship).selectByVisibleText(RelationshipNew);
    
    
    //Select the new  Type
 
    String TypeNew=excel.getCellDataUpd("Collaboration", "EditType ", 1);
    new Select(clb.partnerType).selectByVisibleText(TypeNew);
    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    
    
    //Click the Save button after Editing
    account.acctSaveBtn.click();
    
    WebDriverWait wait = new WebDriverWait (driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
    
    ////Validation that Partner edited successfully
    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Updated");
    
}

@Test(priority=3,groups={"Regression"},description="Mass Update for Partner")

public static void MassUpdateForPartner() throws InterruptedException
{
	LeadPage lead=new LeadPage();
	DealPage deal=new DealPage();
	CollaborationPage clb=new CollaborationPage();
	
	
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
	
    	driver.get("https://"+config.getProperty("Environment")+".convergehub.com/partner/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Partner_ID"))).click();
		driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Partner_ID_New"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    lead.Actiondropdown.click(); //Click the Action dropdown
	    driver.findElement(By.linkText("Mass Update")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    //Update the Partner Type
	    String massupdType=excel.getCellDataUpd("Collaboration", "MassUpdPartnerType", 1);
	    new Select(clb.massupdpartnerType).selectByVisibleText(massupdType);
	    
	    //Update the Lead Source
	    String massupdRelation=excel.getCellDataUpd("Collaboration", "MassUpdRelation", 1);
	    new Select(clb.massupdRelationship).selectByVisibleText(massupdRelation);
	    
	
	    //Click the save button
	    lead.MassUpdSave.click();
    
    
    for (String winHandle : driver.getWindowHandles()) 
    { 

    	driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle 

        WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(lead.MassUpdUpdateBtn));
	    lead.MassUpdUpdateBtn.click();//Click the Update Button on the Mass Update Confirmation Popup

   
    }
    
   	    
    WebDriverWait wait1 = new WebDriverWait (driver, 20);
    wait1.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
    
    
    Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Partner Updated"));
    
}
      
}
