package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LeadPage extends Base
{
	//Create Lead
	@FindBy(id="salutation_select_drp_dwn") public WebElement Salutation;
	@FindBy(id="first_name") public WebElement FirstName;
	@FindBy(id="last_name") public WebElement LasttName;
	@FindBy(id="type_select_drp_dwn") public WebElement LeadType;
	@FindBy(id="account_name") public WebElement AcctName;
	@FindBy(id="lead_source_select_drp_dwn") public WebElement LeadSource;
	@FindBy(id="status_select_drp_dwn") public WebElement LeadStatus;
	@FindBy(id="industry_select_drp_dwn") public WebElement Industry;
	@FindBy(id="phoneNew1") public WebElement PhoneNo;
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
	
	//Schedule Events
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
	
	//Advance Search
	@FindBy(id="adv-search") public WebElement AdvSearchBtn;
	@FindBy(id="first_name_adv") public WebElement AdvSearchFirstNm;
	@FindBy(id="last_name_adv") public WebElement AdvSearchLastNm;
	@FindBy(id="account_name_adv") public WebElement AdvSearchAcctNm;
	@FindBy(id="lead_source_field") public WebElement AdvSearchLeadSrc;
	@FindBy(id="status_field") public WebElement AdvSearchStatus;
	@FindBy(id="industry_field") public WebElement AdvSearchIndustry;
	@FindBy(id="type_field") public WebElement AdvSearchLeadType;
	@FindBy(xpath="//div[@class='advanced-search-panel']/ul[4]/li[1]/a[@class='button fresh_green']") public WebElement AdvSearchButton;
	
	//Edit Lead
	@FindBy(id="Edit") public WebElement EditIcon;
	
	//Edit Lead
	@FindBy(id="Searchtxt") public WebElement BasicSearchTxt;
	@FindBy(xpath="(//a[contains(text(),'Go')])[2]") public WebElement Gobtn;
	
	//Mass Update
	@FindBy(id="action_html") public WebElement Actiondropdown;
	@FindBy(id="domfield_lead_source_select_drp_dwn") public WebElement MassUpdLeadSource;//Select
	@FindBy(id="domfield_status_select_drp_dwn") public WebElement MassUpdLeadStatus;//Select
	@FindBy(id="domfield_industry_select_drp_dwn") public WebElement MassUpdLeadIndustry;//Select
	@FindBy(id="sales_process_select_drp_dwn") public WebElement MassUpdSalesProcess;//Select
	@FindBy(xpath="//input[@id='mass_text_con_1']") public WebElement MassUpdDepartment;
	@FindBy(xpath="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']") public WebElement MassUpdSave;
	@FindBy(id="ui-dialog-title-common_popup_above_popup") public WebElement MassUpdConfirmation;//Popup-Mass Update Confirmation
	//@FindBy(xpath="(//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])[2]") public WebElement MassUpdUpdateBtn;//Update button
	@FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/div[3]/div[1]/button[1]/span[contains(text(),'Update')]") public WebElement MassUpdUpdateBtn;//Update button
	@FindBy(id="header_notification_msg") public WebElement HeaderNotificationMsg;
	
	//Convert Lead
	@FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']") public WebElement ConvertLeadPopup;
	@FindBy(id="account_account_name") public WebElement ConvertLeadAcctName;
	@FindBy(id="create_contact") public WebElement ConvertLeadCreateContact;
	@FindBy(id="contact_first_name") public WebElement ConvertLeadContactFirstNm;
	@FindBy(id="contact_last_name") public WebElement ConvertLeadContactLastNm;
	@FindBy(id="emailAddress1") public WebElement ConvertLeadContactEmail;
	@FindBy(id="create_deal") public WebElement ConvertLeadCreateDeal;
	@FindBy(id="deal_name") public WebElement ConvertLeadDealName;
	@FindBy(id="deal_estimated_amount") public WebElement ConvertLeadDealEstimatedAmt;
	@FindBy(id="comment_text") public WebElement ConvertLeadComment;
	@FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/div[3]/div[1]/button[1]/span[contains(text(),'Convert')]") public WebElement ConvertLeadConvertBtn;
	
	//Merge Duplicate
	@FindBy(id="merge_save_records") public WebElement MergeSaveRecord;
	
	public LeadPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
