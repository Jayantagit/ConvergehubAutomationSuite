package com.ConvergeHub.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.ConvergeHub.Base.Base;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestUtil extends Base
{
    public static String screenShotPath;
    public static String screenShotName;
    public static String screenShotImageName;
    
    public static String screenShotPathashot;
    public static String screenShotNameashot;
    public static String screenShotImageNameashot;
    public static Screenshot screenshot;
    
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
	
	public static String captureScreenshotAshot() 
	{
	   try
	   {  
		   System.out.println("AShot Func entered");
		   screenShotNameashot=new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(new Date())+".png";
		  // screenShotImageNameashot=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotNameashot;
		   screenShotImageNameashot=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotNameashot;
		   System.out.println(screenShotImageNameashot);
		   //screenshot = new AShot().takeScreenshot(driver);
		   screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		   ImageIO.write(screenshot.getImage(),"PNG",new File(screenShotImageNameashot));
		 
		   System.out.println(screenShotImageNameashot);
		   log.debug("Screenshot taken: "+screenShotImageNameashot);	      
		   
	   }
		catch(Exception e) 
		{
			log.error("Issue with taking screenshot: "+e.getMessage().toString());
			screenShotImageNameashot=null;
		}
	   
	    return screenShotImageNameashot;
	   
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
	
@DataProvider(name="dp")
	
public  Object[][] getData(Method m)
{
		String sheetname=m.getName();
		int rows=excel.getRowCount(sheetname);
		int cols=excel.getColumnCount(sheetname);
		Object [][] data=new Object[rows][1];
		
		Hashtable<String,String> table=null;
		
		for(int rownum=1;rownum<=rows;rownum++)
		{
			table=new Hashtable<String,String>();
			
			for(int colnum=0;colnum<cols;colnum++)
			{
				table.put(excel.GetCellData(sheetname, 0, colnum), excel.GetCellData(sheetname, rownum, colnum));
				data[rownum-1][0]=table;
			}
		}
		
		return data;
	}
}
