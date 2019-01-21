package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DealPage extends Base
{
	//Add Deal-
	@FindBy(id="name") public WebElement DealName;
	@FindBy(id="deal_type_select_drp_dwn") public WebElement DealType;//Select Dropdown
	@FindBy(id="account_name_field") public WebElement DealAccountNm;
	@FindBy(xpath="(//span[@class='float-left ellipsis_autosugest'])[1]") public WebElement DealAccountNmFirst;//First account name in the List
	@FindBy(id="currency_id_select_drp_dwn") public WebElement DealCurrency;//Select Dropdown
	@FindBy(id="amount") public WebElement DealAmount;
	@FindBy(id="lead_source_select_drp_dwn") public WebElement DealLeadSource;//Select Dropdown
	@FindBy(id="sales_stage_select_drp_dwn") public WebElement DealSalesStage;//Select Dropdown
	@FindBy(id="description") public WebElement DealDescription;
	@FindBy(xpath="//button[@id='accountValidation' and @type='submit']") public WebElement DealSaveBtn;
	@FindBy(id="header_notification_msg") public WebElement SuccessNotificationMsg;
	
	public DealPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
