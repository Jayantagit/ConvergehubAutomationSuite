package Rough;

import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.By;

import com.ConvergeHub.Base.Base;

public class RoughOther extends Base
{
	
	public static void main(String[] args)
	{
		
		
		System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\TestData.xls");
		String DealName=excel.GetCellData("TC_AddDeal", 1, 0);
		
		System.out.println(DealName);
		
	
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
	}
}
