package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MarketingPage extends Base
{
	//Add Template-
	@FindBy(id="name") public WebElement templateName;//Edit
	@FindBy(id="template_category_select_drp_dwn") public WebElement templateCategory;//TemplateCategory-Select
	@FindBy(id="category_select_drp_dwn") public WebElement Category;//Category-Select
	@FindBy(id="subject") public WebElement Subject;//Subject-Select
	@FindBy(id="module_name_select_drp_dwn") public WebElement ModuleName;//Module Name-Select for insert variable
	//LinkText-Insert
	//frame id-body_html_ifr
	@FindBy(xpath="//button[@id='accountValidation' and @type='submit']") public WebElement templateSubmit;//Submit Button
	
	
	public MarketingPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("Marketing Page Initialized.");
	}

}
