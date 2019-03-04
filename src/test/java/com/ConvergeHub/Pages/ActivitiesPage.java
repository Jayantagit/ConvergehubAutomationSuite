package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ActivitiesPage extends Base
{
	//Task -Elements	
	@FindBy(id="name") public WebElement taskName;//Edit
	@FindBy(id="priority_select_drp_dwn") public WebElement taskPriority;//Select
	@FindBy(id="description") public WebElement taskDescription;//TextArea
	@FindBy(id="status_select_drp_dwn") public WebElement taskStatus;//Select
	@FindBy(xpath="//input[@class='button fresh_green activity_add_from_module']") public WebElement btnSave;//Button
	
	//Event -Elements
	@FindBy(id="event_type_select_drp_dwn") public WebElement eventType;//Select
	@FindBy(id="name") public WebElement eventName;//Edit
	@FindBy(id="status_select_drp_dwn") public WebElement eventStatus;//Select
	@FindBy(id="description") public WebElement eventDescription;//Edit
	@FindBy(id="sendTo") public WebElement eventSendTo;//Edit
	@FindBy(id="select3_maininput") public WebElement InviteeEmail;//Edit
	@FindBy(id="priority_select_drp_dwn") public WebElement EventPriority;//Edit
	
	//Notes -Elements
	@FindBy(id="subject") public WebElement noteSubject;//Edit
	@FindBy(xpath="//button[@class='button fresh_green save_button_from_module_add']") public WebElement btnNoteSave;//Button
	
	//Tags-Elements
	@FindBy(id="name") public WebElement tagName;//Edit
	//Link-Text-+New
	@FindBy(id="category_auto") public WebElement tagCategory;//Edit
	@FindBy(xpath="//button[@id='accountValidation' and @type='submit']") public WebElement tagSavebtn;//Button
	
	//Email-Elements
	@FindBy(xpath="//ul[@id='sendTo']/li[@id='select3_annoninput']/input[@id='select3_maininput']") public WebElement emailSendToFirst;//li
	@FindBy(id="subject") public WebElement emailSubject;//Edit
	//Frame id-body_html_content_ifr
	@FindBy(xpath="//input[@class='button fresh_green' and @value='Send']") public WebElement emailSendBtn;//Button
	
	public ActivitiesPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("Activity Page Initialized.");
	}

}
