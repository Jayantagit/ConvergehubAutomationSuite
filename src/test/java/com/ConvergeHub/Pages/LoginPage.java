package com.ConvergeHub.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ConvergeHub.Base.Base;

public class LoginPage extends Base
{
	@FindBy(id="username") public WebElement username;
	@FindBy(id="password") public WebElement password;
	@FindBy(id="loginb")   public WebElement login;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("Login Page Initialized.");
	}


}
