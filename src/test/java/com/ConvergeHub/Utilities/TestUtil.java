package com.ConvergeHub.Utilities;

import java.io.File;
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
}
