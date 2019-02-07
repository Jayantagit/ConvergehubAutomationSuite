package com.ConvergeHub.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Pages.DealPage;
import com.ConvergeHub.Pages.CasePage;
import com.ConvergeHub.Utilities.TestUtil;


public class TC_Add_Case extends Base  
{    
	@Test(groups={"Regression"},description="Create a New Case")
	
	public static void CaseCreation() throws InterruptedException
	{
		//Initialize the Page Class
		DealPage deal=new DealPage();
		CasePage casepg=new CasePage();
		
	
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
	    
		//Redirecting to the Add Case Page
		driver.get("https://"+config.getProperty("Environment")+".convergehub.com/cases/add");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    
	    //===========Filled up the Add Case Screen=====================
		
		//------Enter the Subject
		//casepg.caseSubject.clear();
	    String caseSubject=excel.getCellDataUpd("Case","Subject", 1);
	    casepg.caseSubject.sendKeys(caseSubject);
	    
	    //Select the Account Name
	    casepg.caseAcctName.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    /*
	    String caseacctName="(//span[contains(@class,'float-left ellipsis_autosugest') and contains(@title,"+"\'"+excel.getCellDataUpd("Case","AccountName", 1)+"\'"+")])[1]";
	    System.out.println(caseacctName);
	    WebElement element=driver.findElement(By.xpath(caseacctName));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    */
	    String acctNameData=excel.getCellDataUpd("Case","AccountName", 1);
	    WebElement acctname= driver.findElement(By.xpath("//div[@id='alls_tab_account_name']/ul"));
	    List<WebElement> nameList=acctname.findElements(By.tagName("li"));
	    for (WebElement li : nameList) 
	    {
	    if (li.getText().equals(acctNameData)) 
	    {
	         li.click();
	         break;
	       }
	    }
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	    //casepg.caseAcctName.sendKeys(Keys.ENTER);
	    
	    //------Select the Case Origin
	    casepg.caseOrigin.click();
	    String caseOrigin=excel.getCellDataUpd("Case", "Origin", 1);
	    new Select(casepg.caseOrigin).selectByVisibleText(caseOrigin);
	    
	    //------Select the Case Category
	    String caseCategory=excel.getCellDataUpd("Case", "Category", 1);
	    new Select(casepg.caseCategory).selectByVisibleText(caseCategory);
	    
	  
	    
	    //------Select the Case Priority
	    String casePriority=excel.getCellDataUpd("Case", "Priority", 1);
	    new Select(casepg.casePriority).selectByVisibleText(casePriority);
	    
   
		//------Enter the Case subject
	    driver.switchTo().frame("case_comment_save_ifr");
	    String caseDescription=excel.getCellDataUpd("Case", "Description", 1);
	  	driver.findElement(By.cssSelector("body")).sendKeys(caseDescription);
	  	driver.switchTo().defaultContent();
	    
	    //Enter the Save Button
	  	casepg.caseSaveBtn.click();
	    
	    //Assertion statement added for the verification
	    WebDriverWait wait1 = new WebDriverWait (driver, 20);
	    wait1.until(ExpectedConditions.visibilityOf(deal.SuccessNotificationMsg));
	    
	    Assert.assertTrue(deal.SuccessNotificationMsg.getText().toString().contains("Created"));
	    
	  	String  baseurl=driver.getCurrentUrl();
		String arr[]=baseurl.split("/");		
		String Case_ID=arr[arr.length-1];
		TestUtil.writeProperty("Case_ID", Case_ID);  
	    	
	}
	

}
