package com.ConvergeHub.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager
{

	//builds a new report using the html template 
	private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    //helps to generate the logs in test report.
    	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+"Extent.html");
			extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
		}
		return extent;
	}
	

}
