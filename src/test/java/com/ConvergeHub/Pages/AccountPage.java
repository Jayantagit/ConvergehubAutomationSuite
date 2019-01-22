package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage extends Base
{
	//Add Account-Elements	
	@FindBy(id="name") public WebElement acctName;//Edit
	@FindBy(id="industry_select_drp_dwn") public WebElement acctIndustry;//Select
	@FindBy(id="account_type_select_drp_dwn") public WebElement acctType;//Select
	@FindBy(id="account_status_select_drp_dwn") public WebElement acctStatus;//Select
	@FindBy(id="parent_account_field") public WebElement acctParent;
	@FindBy(id="phoneNew1") public WebElement acctPhone;//Edit
	@FindBy(id="emailAddress1") public WebElement acctEmail;//Edit
	@FindBy(xpath="//button[@id='accountValidation' and @type='submit']") public WebElement acctSaveBtn;
	
	
	public AccountPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
