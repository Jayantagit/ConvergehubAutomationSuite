package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactPage extends Base
{
	//Add Contact-
	@FindBy(id="salutation_select_drp_dwn") public WebElement Salutation;
	@FindBy(id="first_name") public WebElement FirstName;
	@FindBy(id="last_name") public WebElement LastName;
	@FindBy(xpath="//div[@class='selectbox' and @xpath='3']") public WebElement ContactPhoneType;
	@FindBy(id="phoneNew1") public WebElement PhoneNo;
	@FindBy(id="emailAddress1") public WebElement EmailAddress;
	@FindBy(xpath="//button[@id='accountValidation' and @type='submit']") public WebElement ContactSaveBtn;
	
	
	public ContactPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
