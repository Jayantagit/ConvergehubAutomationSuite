package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DealPage extends Base
{
	/*
	@FindBy(id="salutation_select_drp_dwn") public WebElement Salutation;
	@FindBy(xpath="//button[@type='submit']") public WebElement LeadSave;
	*/
	
	
	public DealPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
