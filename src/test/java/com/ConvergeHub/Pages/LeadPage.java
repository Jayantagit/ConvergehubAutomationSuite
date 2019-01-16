package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LeadPage extends Base
{
	@FindBy(xpath="//input[@type='text' and @class='_2zrpKA']") public WebElement username;
	@FindBy(xpath="//input[@type='password']") public WebElement password;
	public LeadPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
