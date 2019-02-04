package com.ConvergeHub.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ConvergeHub.Base.Base;

public class TestUtil extends Base
{
    public static String screenShotPath;
    public static String screenShotName;
    public static String screenShotImageName;
    
	public static String captureScreenshot() 
	{
	   try
	   {   Date d=new Date();
		   screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		   screenShotPath=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\";
		   screenShotImageName=screenShotPath+screenShotName;
		     
		   File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)	;
		   
		   FileUtils.copyFile(srcFile, new File(screenShotImageName));
	   }
		catch(Exception e) 
		{
			log.error("Issue with taking screenshot: "+e.getMessage().toString());
			
		}
	   
	    return screenShotImageName;
	   
	}
	
	public static void writeProperty(String key,String value)
	{
 	   try 
 	   {
			fos=new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\SavedVal.properties",false);
			//SavedData.clear(); 
			
 	   } 
 	   catch (FileNotFoundException e) 
 	   {
			e.printStackTrace();
		}
		SavedData.setProperty(key,value);
		try 
		{
			SavedData.store(fos,"Saved");
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			fos.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
