package Rough;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ConvergeHub.Base.Base;

public class RoughOther extends Base
{
	
	public static void main(String[] args)
	{
		
		/*
	
		String url="https://app01.convergehub.com/leads/detail/14133283-7e2c-ccc5-cec9-5c484977b691";
		String arr[]=url.split("/");
		
		System.out.println(arr[arr.length-1]);
	*/
		/*
		List<WebElement> allOptions = element.findElements(By.xpath("//input[contains(@id,'chk_industry_leads')]"));
		for (WebElement option : allOptions) {
			   System.out.println("Option value "+option.getText());
			        if (valueToSelect.equals(option.getText())) {
			            option.click();
			            break;
			        }
			    }
			    
	   */	
		
	    List<WebElement> notifyToList=driver.findElements(By.xpath("//div[@id='alls_tab_notify_to11']/ul/li/a"));
	    for(WebElement lst:notifyToList)
	    {
	    	String notifyToName=lst.getText();
	    	System.out.println(notifyToName);
	    }
	
	}
}
