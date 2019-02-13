package com.ConvergeHub.Pages;

import com.ConvergeHub.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BillingPage extends Base
{
	//Products-Elements	
	@FindBy(id="type_select_drp_dwn") public WebElement productType;//Select
	@FindBy(id="name") public WebElement productName;//Edit
	@FindBy(id="unit_price") public WebElement productPrice;//Edit
	@FindBy(id="category_select_drp_dwn") public WebElement productCategory;//Select
	@FindBy(id="status_select_drp_dwn") public WebElement productStatus;//Select
	@FindBy(id="description") public WebElement productDescription;//Edit
	@FindBy(id="usage_unit_select_drp_dwn") public WebElement Unit;//Select
	@FindBy(id="stock_no") public WebElement productStock;//Edit
	@FindBy(xpath="//button[@id='productValidation' and @type='submit']") public WebElement btnproductSave;//Button
	
	
	
	public BillingPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("Billing Page Initialized.");
	}

}
