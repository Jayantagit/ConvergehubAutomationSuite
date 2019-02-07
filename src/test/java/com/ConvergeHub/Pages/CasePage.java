package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CasePage extends Base
{
	//Add Cases-
	@FindBy(id="name") public WebElement caseSubject;//Edit
	@FindBy(id="account_name_field") public WebElement caseAcctName;//Edit
	@FindBy(id="contact_name_field") public WebElement caseContactName;//Edit
	@FindBy(id="category_select_drp_dwn") public WebElement caseCategory;//Select
	@FindBy(id="case_origin_select_drp_dwn") public WebElement caseOrigin;//Select
	@FindBy(id="priority_select_drp_dwn") public WebElement casePriority;//Select
	@FindBy(xpath="(//button[@id='accountValidation'])[3]") public WebElement caseSaveBtn;//Select
	
	
	public CasePage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
		//driver.switchTo().frame("case_comment_save_ifr");
		//driver.findElement(By.cssSelector("body")).sendKeys("your data");
	}

}
