package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LeadPage extends Base
{
	@FindBy(id="salutation_select_drp_dwn") public WebElement Salutation;
	@FindBy(id="first_name") public WebElement FirstName;
	@FindBy(id="last_name") public WebElement LasttName;
	@FindBy(id="type_select_drp_dwn") public WebElement LeadType;
	@FindBy(id="account_name") public WebElement AcctName;
	@FindBy(id="lead_source_select_drp_dwn") public WebElement LeadSource;
	@FindBy(id="status_select_drp_dwn") public WebElement LeadStatus;
	@FindBy(id="industry_select_drp_dwn") public WebElement Industry;
	@FindBy(id="emailAddress1") public WebElement EmailAddress;
	@FindBy(xpath="//button[@type='submit']") public WebElement LeadSave;
	@FindBy(xpath="(//span[contains(text(),'Select')])[1]") public WebElement LeadListSelection;//Selecting the First Lead in the List
	@FindBy(xpath="//input[@name='name']") public WebElement TaskSubject;
	@FindBy(id="customFieldsValidation") public WebElement TaskSaveBtn;
	//Comments
	@FindBy(xpath="(//span[contains(text(),'Comments')])[1]") public WebElement CommentIcon;//Clicking the comment icon for the First Lead in List
	@FindBy(xpath="//textarea[contains(@id,'comment_list')]") public WebElement CommentTextBox;
	@FindBy(xpath="(//input[@type='button'])[1]") public WebElement CommentSaveButton;
	
	public LeadPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
