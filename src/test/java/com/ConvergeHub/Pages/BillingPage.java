package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BillingPage extends Base
{
	//Products-Elements	
	@FindBy(id="name") public WebElement partnerName;//Edit

	
	public BillingPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("Billing Page Initialized.");
	}

}
