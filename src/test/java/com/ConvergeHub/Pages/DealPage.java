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
	
	//Search
	@FindBy(id="adv-search") public WebElement AdvSearchBtn;
	@FindBy(id="name_adv") public WebElement SrchName;
	@FindBy(id="account_id_relate_adv_field") public WebElement SrchAcctName;
	@FindBy(id="//div[@id='alls_tab_account_id_relate_adv']/ul/li[1]") public WebElement FirstAcctName;//Select All
	@FindBy(id="deal_type_field") public WebElement SrchDealType;
	@FindBy(id="lead_source_field") public WebElement SrchLeadSource;
	@FindBy(id="sales_stage_field") public WebElement SrchSalesStage;
	@FindBy(id="Searchtxt") public WebElement SrchQuiclSearch;
	
	
	public DealPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
