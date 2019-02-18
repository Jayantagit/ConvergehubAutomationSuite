package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ToolsPage extends Base
{
	//Manage Duplicate -Elements	
	@FindBy(id="module_select_drp_dwn") public WebElement Module;//Select
	//By.partiallinkTest-Find Duplicate
	@FindBy(id="search_flds_email") public WebElement ManagedDuplicateEmail;//Checkbox
	//By.LinkTest-Search

	
	public ToolsPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("Tool Pages Initialized.");
	}

}
