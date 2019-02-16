package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CollaborationPage extends Base
{
	//Add Collaborations-Elements	
	@FindBy(id="name") public WebElement partnerName;//Edit
	@FindBy(id="relation_select_drp_dwn") public WebElement partnerRelationship;//Select
	@FindBy(id="type_select_drp_dwn") public WebElement partnerType;//Select
	@FindBy(id="phoneNew1") public WebElement partnerPhno;//Edit
	@FindBy(id="emailAddress1") public WebElement partnerEmail;//Edit
	@FindBy(id="image") public WebElement partnerImg;//Edit
	
	//Mass Update
	@FindBy(id="domfield_type_select_drp_dwn") public WebElement massupdpartnerType;//Select
	@FindBy(id="domfield_relation_select_drp_dwn") public WebElement massupdRelationship;//Select
	
	//Notifcation screen
	@FindBy(id="subject") public WebElement notificationSubject;//Edit
	@FindBy(xpath="//button[@id='notificationValidationButton' and @type='submit']") public WebElement btnnotificationSend;//Button
	@FindBy(id="notify_to11_field") public WebElement notifyTo;//Edit
	@FindBy(xpath="//div[@id='alls_tab_notify_to11']/ul/li/a//span[@class='float-left ellipsis_autosugest']") public WebElement notifyNmList;
	

	
	public CollaborationPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("Collaboration Page Initialized.");
	}

}
