package com.ConvergeHub.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ConvergeHub.Pages.LeadPage;
import com.ConvergeHub.Pages.LoginPage;
import com.ConvergeHub.Utilities.ExcelReader;
import com.ConvergeHub.Utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Base
{
	
	public static  WebDriver driver;
		
	 public static  Properties config=new Properties();
	 public static  Properties OR=new Properties();
	 public static  Properties SavedData=new Properties();
	 public static  Properties Deal=new Properties();
	 public static  FileInputStream fis;
	 public static  FileOutputStream fos;
	 public static  FileOutputStream fosDeal;
	 public static WebDriverWait wait;
	 public static WebElement dropdown;
	 public static String browser;
	// public static String TestDataPath=System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xls"; 
	 public static Logger log=Logger.getLogger("rootLogger");
	 public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xls");
	 public static ExtentReports rep=ExtentManager.getInstance();
	 public static ExtentTest test;
	 
	 
	 @BeforeSuite
		public void setUp()
		{
			if(driver==null)
			{
				    try 
				    {
						fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
						
					} 
				    catch (FileNotFoundException e) 
				    {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	   try 
		    	   {
					config.load(fis);
					log.debug("Config File Loaded");
				   } 
		    	   catch (IOException e) 
		    	   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
		    	   
		    	   System.out.println(config.getProperty("Browser"));
		    	   
		    	   try 
		    	   {
					fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
					//fos=new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
				   } 
		    	   catch (FileNotFoundException e) 
		    	   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				   }
		    	   try
		    	   {
					OR.load(fis);
					log.debug("OR File Loaded");
				  } 
		    	   catch (IOException e) 
		    	   {
					e.printStackTrace();
				  }
		    	   
		    	  /*--------------------
		    	   try 
		    	   {
					fos=new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\SavedVal.properties",false);
					//SavedData.clear(); 
					
				   } 
		    	   catch (FileNotFoundException e) 
		    	   {
					e.printStackTrace();
				   }
				   
				   ------------------------------*/
		    	   
		    	   /*--------------------
		    	   //----------------------Open the Property File for Deal-----------------------------------------------------		    	   
		    	   try 
		    	   {
					fosDeal=new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Deal.properties",false);
					//Deal.clear(); 
					
				   } 
		    	   catch (FileNotFoundException e) 
		    	   {
					e.printStackTrace();
				   }
				   
				   ------------------------------*/
		    	   //----------------------Checking the Browser value------------------------------------------------------------
		    	   if(System.getenv("Browser")!=null && !System.getenv("Browser").isEmpty())
		    	   {
		    		   browser=System.getenv("Browser");
		    	   }
		    	   else
		    	   {
		    		   browser=config.getProperty("Browser");
		    	   }
		    	   
		    	   config.setProperty("Browser", browser);
		    		  
		    	   if(config.getProperty("Browser").equals("Chrome"))
		    	   {
		    		  // System.out.println(System.getProperty("user.dir")+"executables\\chromedriver.exe");
		    		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
		    		   driver=new ChromeDriver();
		    		   System.out.println("Chrome Driver Luanched");
		    	   }
		    	   
		    	   driver.get(config.getProperty("TestsuiteURL"));
		    	   driver.manage().window().maximize();
		    	   driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("ImplicitTime")), TimeUnit.SECONDS);
		    	   wait=new WebDriverWait(driver,5);  
		    	
		    	//***************LOGIN CODE-START
		    	LoginPage login=new LoginPage();   
		    	login.username.clear();
		   	    login.username.sendKeys(config.getProperty("UserName"));
		   		login.password.sendKeys(config.getProperty("Password"));
		   	    login.login.click();
		   	    System.out.println("Successfully Logged");
		   	    wait=new WebDriverWait(driver,30); 
		   	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='icon search-top']")));
		   	    //********************LOGIN CODE-END
		    	   
			}
		}
		
		public boolean IsElementPresence(By by)
		{
			try
			{
				driver.findElement(by);
				return true;
			}
			catch(NoSuchElementException e)
			{
				return false;
			}
			
		}
		
		public void click(String locator)
		{
			if(locator.endsWith("_CSS"))
			{			
			  driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			  
			}
			else if(locator.endsWith("_XPATH"))
			{
				driver.findElement(By.xpath(OR.getProperty(locator))).click();
			}
			test.log(Status.INFO, "Clicking on :"+locator);
		}
		
		public void SendKeys(String locator,String value)
		{
			if(locator.endsWith("_CSS"))
			{	
			   driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			   
			}  
			else if(locator.endsWith("_XPATH"))
			{
				driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			}
			test.log(Status.INFO, "Type in :"+locator +"Entered value as :"+value);
		}
		
		public void select(String locator,String value)
		{
			if(locator.endsWith("_CSS"))
			{	
			   dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
			   
			}  
			else if(locator.endsWith("_XPATH"))
			{
				dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
			}
			
			Select s=new Select(dropdown);
			s.selectByVisibleText(value);
			
			test.log(Status.INFO, "Selected from :"+locator +"value as :"+value);
		}
	
		@AfterSuite
		public void TearDown()
		{
			System.out.println("Test Execution Completed");
			if(driver !=null)
			{  
				System.out.println("Test Execution Completed");
				driver.get("https://"+config.getProperty("Environment")+".convergehub.com/users/logout");
				/*
				try 
				{
					fis.close();
					fos.close();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				
				driver.quit();
			    log.debug("Driver Closed");
			}
		}
	
}
