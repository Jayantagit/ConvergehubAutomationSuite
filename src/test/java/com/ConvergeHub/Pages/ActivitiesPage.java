package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ActivitiesPage extends Base
{
	//Task -Elements	
	@FindBy(id="name") public WebElement taskName;//Edit
	@FindBy(id="priority_select_drp_dwn") public WebElement taskPriority;//Select
	@FindBy(id="description") public WebElement taskDescription;//TextArea
	@FindBy(id="status_select_drp_dwn") public WebElement taskStatus;//Select
	@FindBy(id="accountValidation") public WebElement btnSave;//Button
	
	//Event -Elements
	@FindBy(id="event_type_select_drp_dwn") public WebElement eventType;//Select
	@FindBy(id="name") public WebElement eventName;//Edit
	@FindBy(id="status_select_drp_dwn") public WebElement eventStatus;//Select
	
	//Notes -Elements
	@FindBy(id="subject") public WebElement noteSubject;//Edit
	
	public ActivitiesPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
