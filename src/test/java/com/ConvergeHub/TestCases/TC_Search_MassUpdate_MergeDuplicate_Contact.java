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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.ContactPage;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_Search_MassUpdate_MergeDuplicate_Contact extends Base  
{    
	@Test(priority = 0,groups={"Smoke"},description="Advance Search for Contact")
	
	public static void ContactAdvanceSearch() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		
	   /*-------------Login section needed if executed this TC separately 
	
		LoginPage login=new LoginPage();		
		login.username.clear();
	    login.username.sendKeys(config.getProperty("UserName"));
		login.password.sendKeys(config.getProperty("Password"));
	    login.login.click();
	    System.out.println("Successfully Logged");
	    wait=new WebDriverWait(driver,20); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Dashboard')]")));
	    driver.get("https://staging.convergehub.com/deals/");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   ---------------------------------------------------------------------- */	    
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/contacts/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Click the Advanced Search button
	    deal.AdvSearchBtn.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    //Enter the Search criteria for First and Last Name	       
	    lead.AdvSearchFirstNm.sendKeys(excel.getCellDataUpd("Contact", "AdvSearchFirstNm", 1));
	    lead.AdvSearchLastNm.sendKeys(excel.getCellDataUpd("Contact", "AdvSearchLastNm", 1));
	    
	    
	    //Select the Search Filter for Lead source
	  
	    lead.AdvSearchLeadSrc.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	   
	    WebElement SrchLeadSource=driver.findElement(By.id("chk_lead_source_contacts_"+excel.getCellDataUpd("Contact", "AdvSearchLeadSource", 1)));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();",SrchLeadSource);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
   
	    //-------Click the Advanced Search Button
	    lead.AdvSearchButton.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	     
	    
	    try
	    {
	        List<WebElement> contacts_num=driver.findElements(By.xpath("//input[@class='list_checkbox']"));
	          
	        if(contacts_num.size()>0)
	        {
	        	System.out.println("Advanced Search return result  :"+contacts_num.size());  
	        }
	        else
	        {
	        	System.out.println("No Contacts found for the selected search criteras");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Deal found for the Search");  
	    	e.printStackTrace();
	    	
	    }
	    

	    //Assert.assertEquals(driver.findElement(By.xpath("//span[@id='header_notification_msg']")).getText(), "Event Relation Added");//Validation Step-Event Schedule added successfully
	    
	}
	
@Test(priority = 1,groups={"Regression"},description="Basic Search")
	
	public static void ContactBasicSearch() throws InterruptedException
	{
		LeadPage lead=new LeadPage();
		DealPage deal=new DealPage();
		ContactPage contact=new ContactPage();
		
	   	//Navigate to the Contacts Page  
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/contacts/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		//Clear the Search field and Enter the Search Text for Quick Search
        deal.SrchQuiclSearch.clear();
       
        String quiclsearchVal=excel.getCellDataUpd("Contact", "QuickSearch", 1);
        deal.SrchQuiclSearch.sendKeys(quiclsearchVal);
	    
	    //Click the Go button
	    lead.Gobtn.click();
	    WebDriverWait wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current Search:')]")));
	     
	    
	    try
	    {
	        List<WebElement> contacts_no=driver.findElements(By.xpath("//input[@class='list_checkbox']"));
	          
	        if(contacts_no.size() >0)
	        {
	        	System.out.println("Basic Search return result - :"+contacts_no.size());  
	        }
	        else
	        {
	        	System.out.println("No contacts found for the selected search criteras for Quick search");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No contacts found for the Search");  
	    	e.printStackTrace();
	    	
	    }    
	    
	}

@Test(priority = 2,groups={"Regression"},description="Mass Update for Contacts")

public static void MassUpdateForContacts() throws InterruptedException
{
	LeadPage lead=new LeadPage();
	DealPage deal=new DealPage();
	ContactPage contact=new ContactPage();
	
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

	//Navigating to the Contact List Page
    driver.get("https://"+config.getProperty("Environment")+".convergehub.com/contacts/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Contact_ID"))).click();
	driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Contact_ID_New"))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    lead.Actiondropdown.click(); //Click the Action dropdown
    driver.findElement(By.linkText("Mass Update")).click();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
   
    //Select the Lead Source value
    String massupdLeadSrc=excel.getCellDataUpd("Contact", "MassUpdLeadSrc", 1);
    new Select(contact.massUpdLeadSrc).selectByVisibleText(massupdLeadSrc);
    
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
    
    
    Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Updated"));
    
}

@Test(priority=3,groups={"Regression"},description="Merge Duplicates-Contacts")

public static void MergeContacts() throws InterruptedException
{
	LeadPage lead=new LeadPage();
	DealPage deal=new DealPage();
	ContactPage contact=new ContactPage();
	
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
	
  //Navigate to the Contact List Page   
   driver.get("https://"+config.getProperty("Environment")+".convergehub.com/contacts");
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   

   //Select the Contacts already created from the List
    driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Contact_ID"))).click();
	driver.findElement(By.id("list_checkbox_"+SavedData.getProperty("Contact_ID_New"))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
	//Click the Action DropDown
    lead.Actiondropdown.click(); 
    driver.findElement(By.linkText("Merge Duplicates")).click();
    WebDriverWait mergebtn = new WebDriverWait (driver, 20);
    mergebtn.until(ExpectedConditions.visibilityOf(lead.MergeSaveRecord));
    
    //Click the save button
    lead.MergeSaveRecord.click();
    
    WebDriverWait successMsg = new WebDriverWait (driver, 20);
    successMsg.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
   
    //Verification Step-Selected Contacts are successfully merged
  	Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("successfully merged."));
    
}

      
}
