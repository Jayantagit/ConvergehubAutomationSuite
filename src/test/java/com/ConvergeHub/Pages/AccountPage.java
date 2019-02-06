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
	
	//Listing Page
	@FindBy(xpath="(//span[contains(text(),'Select')])[1]") public WebElement acctSelect;//First select statement in the List
	@FindBy(xpath="(//input[@name='list_checkbox[]'])[1]") public WebElement acctCheckbox;//First checkbox  in the List
	@FindBy(xpath="(//a[@title='Mass Delete'])[1]") public WebElement acctMassDelicon;//First MassDelete icon in the List
	
	//Quick View
	@FindBy(xpath="//a[@class='icon edit-icon'and @title='Create Account in Quick View']") public WebElement quickViewIcon;
	@FindBy(id="name_popup") public WebElement qvacctName;//Edit
	@FindBy(id="account_type_popup_select_drp_dwn") public WebElement qvacctType;//Select
	@FindBy(id="account_status_popup_select_drp_dwn") public WebElement qvacctStatus;//Select
	@FindBy(id="lead_source_popup_select_drp_dwn") public WebElement qvacctLeadSrc;//Select
	@FindBy(id="comment") public WebElement qvacctComments;//TextArea
	@FindBy(id="emailAddress1_popup") public WebElement qvacctEmailAddr;//Edit
	@FindBy(id="phoneNew1_popup") public WebElement qvacctPhone;//Edit
	
	//Search Page
	@FindBy(id="name_adv") public WebElement srchAcctName;//Edit
	@FindBy(id="industry_field") public WebElement srchIndustry;//
	@FindBy(id="account_type_field") public WebElement srchAccountType;//
	
	//Mass Update
	@FindBy(id="domfield_account_type_select_drp_dwn") public WebElement massupdAccountType;//Select
	@FindBy(id="domfield_industry_select_drp_dwn") public WebElement massupdIndustry;//Select
	
	
	public AccountPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
