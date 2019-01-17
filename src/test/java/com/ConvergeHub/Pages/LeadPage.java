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
	
	//Notes
	@FindBy(xpath="(//span[contains(text(),' Notes')])[1]") public WebElement NotesIcon;
	@FindBy(xpath="//input[@name='subject']") public WebElement NotesSubject;
	@FindBy(xpath="//textarea[@id='description']") public WebElement NotesDescription;
	@FindBy(id="customFieldsValidation") public WebElement NotesSaveBtn;
	
	//Events
	@FindBy(xpath="//input[@name='name']") public WebElement EventSubject;
	@FindBy(xpath="//textarea[@id='description']") public WebElement EventDescription;
	
	//Lead-Quick View
	@FindBy(xpath="//a[@class='icon edit-icon']") public WebElement QuickViewicon;
	@FindBy(id="first_name_popup") public WebElement FirstNamepopup;
	@FindBy(id="last_name_popup") public WebElement LastNamepopup;
	@FindBy(id="account_name_popup") public WebElement AccountNamepopup;
	@FindBy(id="lead_source_popup_select_drp_dwn") public WebElement LeadSourcepopup;
	@FindBy(id="status_popup_select_drp_dwn") public WebElement Statuspopup;
	@FindBy(id="phoneNew1_popup") public WebElement Phonepopup;
	@FindBy(id="emailAddress1_popup") public WebElement Emailpopup;
	@FindBy(id="comment") public WebElement Commentpopup;
	@FindBy(xpath="(//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])[2]") public WebElement SaveandNew;
	
	//Refer a Lead
	@FindBy(id="selectFromLibrary") public WebElement ReferBtn;
	@FindBy(id="select3_maininput") public WebElement ReferTo;
	@FindBy(xpath="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']") public WebElement ReferBtnpopup;
	
	
	
	public LeadPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
