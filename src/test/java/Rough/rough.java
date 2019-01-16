package Rough;

import java.util.Date;

public class rough
{
	  public static String screenShotPath;
	  public static String screenShotName;

	public static void Screenshot() 
	{
		Date d=new Date();
		screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		screenShotPath=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName;
		System.out.println(screenShotPath);
		
	}

}
