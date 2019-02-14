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

	
	
	//Quotes-Elements
	@FindBy(id="account_name_field") public WebElement accountName;//Edit
	@FindBy(id="valid_till") public WebElement validTill;//Edit
	@FindBy(id="terms_conditions") public WebElement TermsandCondition;//Edit
	@FindBy(id="description") public WebElement QuotesDescription;//Edit
	@FindBy(id="bean_id_1_name") public WebElement QuotesProduct;//Edit----After Selecting Product from TestData Click on Qty Field
	@FindBy(id="quantity_1") public WebElement Quanitity;//Edit
	@FindBy(id="list_price_1") public WebElement Rate;//Edit
	@FindBy(id="currency_id_select_drp_dwn") public WebElement Currency;//Select
	@FindBy(xpath="//button[@id='accountValidation'and @type='submit']") public WebElement btnSave;//Button
	@FindBy(xpath="//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-month']") public WebElement calMonth;//Select
	@FindBy(xpath="//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-year']") public WebElement calYear;//Select
	
	
	/*
	//-------------For Selecting the Day
	List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
	
	for(WebElement ele:allDates)
	{
		
		String date=ele.getText();
		
		if(date.equalsIgnoreCase("28"))
		{
			ele.click();
			break;
		}
		
	}
	//----------For Selecting the Month
	//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-month']
	
	//----------For Selecting the Year 
	//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-year']
	
	*/
	
	//Invoice-Elements
	@FindBy(id="invoice_date") public WebElement invoiceDate;//DatePicker
	@FindBy(id="due_date") public WebElement dueDate;//DatePicker
	@FindBy(id="status_select_drp_dwn") public WebElement invStatus ;//Select
	
	
	
	//Payment-Elements
	
	
	
	public BillingPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("Billing Page Initialized.");
	}

}
