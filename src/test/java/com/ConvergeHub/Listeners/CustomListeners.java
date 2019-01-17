package com.ConvergeHub.Listeners;

import java.io.IOException;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Utilities.TestUtil;
import com.aventstack.extentreports.Status;


public class CustomListeners extends Base implements ITestListener,ISuiteListener
{

	public void onFinish(ISuite arg0) 
	{

		
	}

	public void onStart(ISuite arg0) 
	{
		
		
	}

	public void onFinish(ITestContext arg0) 
	{
		
		
	}

	public void onStart(ITestContext arg0) 
	{
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{
		
		
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Case Failed");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Cpaturing Screenshot");
		log.debug(result.getName().toUpperCase()+"Failed");
		
		try 
		{
			test.fail("Screen Shot : " + test.addScreenCaptureFromPath(TestUtil.captureScreenshot()));
			
			Reporter.log("<a target=\"_blank\" href="+TestUtil.captureScreenshot()+">Screenshot</a>");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		rep.flush();		
	}

	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, result.getName().toUpperCase()+"Test Skipped");
		
		rep.flush();
		
	}

	public void onTestStart(ITestResult result) 
	{
		
		test=rep.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		
		test.log(Status.PASS, result.getName().toString().toUpperCase()+"Passed");
		try 
		{
			//Date d=new Date();
			test.pass("Screen Shot : " + test.addScreenCaptureFromPath(TestUtil.captureScreenshot()));
			Reporter.log("<a target=\"_blank\" href=\""+TestUtil.captureScreenshot()+"\">Screenshot</a>");
			System.out.println("<a target=\"_blank\" href=\""+TestUtil.captureScreenshot()+"\">Screenshot</a>");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		rep.flush();
	}
	
}
