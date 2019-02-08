package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CollaborationPage extends Base
{
	//Add Collaborations-Elements	
	@FindBy(id="name") public WebElement partnerName;//Edit
	@FindBy(id="relation_select_drp_dwn") public WebElement partnerRelationship;//Select


	
	public CollaborationPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
