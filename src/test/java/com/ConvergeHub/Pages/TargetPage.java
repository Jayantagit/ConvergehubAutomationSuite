package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TargetPage extends Base
{
	//Add Target-
	@FindBy(id="salutation_select_drp_dwn") public WebElement Salutation;//Select
	@FindBy(id="status_select_drp_dwn") public WebElement Status;//Select
	@FindBy(id="first_name") public WebElement FirstName;//Edit
	@FindBy(id="last_name") public WebElement LastName;//Edit
	@FindBy(id="type_select_drp_dwn") public WebElement TargetType;//Select
	@FindBy(id="account_name") public WebElement CompanyName;//Edit
	@FindBy(id="industry_select_drp_dwn") public WebElement Industry;//Select
	@FindBy(id="phoneNew1") public WebElement PhoneNo;//Edit
	@FindBy(id="emailAddress1") public WebElement EmailAddress;//Edit
	@FindBy(xpath="//button[@id='accountValidation' and @type='submit']") public WebElement TargetSaveBtn;
	
	//Search-
	@FindBy(xpath="//li[@id='adv-search']") public WebElement advSearchLink;//link
	@FindBy(id="status_field") public WebElement srchStatus;//Edit
	@FindBy(id="tags_relate_adv") public WebElement srchTags;//Edit
	@FindBy(xpath="//span[contains(text(),'Select')]") public WebElement selectDropdown;
	
	public TargetPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
