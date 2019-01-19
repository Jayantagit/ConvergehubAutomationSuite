package com.ConvergeHub.TestCases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;


public class TC_MassUpdateForLead extends Base  
{    
	@Test(groups={"Regression"},description="Mass Update for Lead")
	
	public static void MassUpdateforlead() throws InterruptedException
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
	    
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath(OR.getProperty("LeadCheckbox")));
	          
	        if(Leads_num.size()>1)
	        {
	        	Leads_num.get(0).click();//Click the First Lead in the List
	        	Leads_num.get(1).click();//Click the Second Lead in the List
	        }
	        else
	        {
	        	System.out.println("No or only One Lead is present in the Lead List");      
	        }
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    lead.Actiondropdown.click(); //Click the Action dropdown
	    driver.findElement(By.linkText("Mass Update")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    //Set the department value
	    int nm=(int) (Math.random()*50+1);
	    lead.MassUpdDepartment.sendKeys("Test_"+String.valueOf(nm));
	    
	    //Select the Industry value
	    new Select(lead.MassUpdLeadIndustry).selectByVisibleText(config.getProperty("SrchIndustry"));
	    
	    //Click the save button
	    lead.MassUpdSave.click();
	    
		    
	    /*Alert alert=driver.switchTo().alert();
	    alert.accept();
	    Set<String> myWindowHandle = driver.getWindowHandles();
	    Iterator<String> iterator = myWindowHandle.iterator();
	    while(iterator.hasNext())
	    {
	    	driver.switchTo().window(iterator.next());
	    	String CurrentURL=driver.getTitle().toString();
	    	System.out.println(CurrentURL);
	    	boolean retval1=CurrentURL.equalsIgnoreCase("Mass Update Confirmation");
	    	if(retval1)
	    	{
	    		lead.MassUpdUpdateBtn.sendKeys(Keys.ENTER);
	    		break;
	    	}
	    
	    }
	    */
	    
	    for (String winHandle : driver.getWindowHandles()) 
	    { 

	    	driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle 

	        WebDriverWait wait = new WebDriverWait (driver, 20);
		    wait.until(ExpectedConditions.visibilityOf(lead.MassUpdUpdateBtn));
		    lead.MassUpdUpdateBtn.click();//Click the Update Button on the Mass Update Confirmation Popup

	   
	    }
	    
	   	    
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(lead.HeaderNotificationMsg));
	    
	    
	    Assert.assertTrue(lead.HeaderNotificationMsg.getText().toString().contains("Leads Updated"));
	    
	}


}
