package com.ConvergeHub.Listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.ConvergeHub.Utilities.TestUtil;
import com.aventstack.extentreports.Status;
import com.ConvergeHub.Base.Base;
import com.ConvergeHub.Utilities.MonitoringMail;
import com.ConvergeHub.Utilities.SendEmail;
import com.ConvergeHub.Utilities.TestConfig;

public class CustomListeners extends Base implements ITestListener,ISuiteListener
{
	//public 	String messageBody;
	
	public void onFinish(ISuite arg0) 
	{
		/*---------------To Trigger the Jenkins Job
		MonitoringMail mail = new MonitoringMail();
		 
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DataDrivenLiveProject/Extent_Reports/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//SendEmail.sendEmail();
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
