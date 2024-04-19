package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditAmountPage {

	@FindBy(name="customer_account_no")
	private WebElement customerAccoountNumberTextField;
	
	@FindBy(name="credit_amount")
	private WebElement creditAmmountTextField;

		
	@FindBy(name="credit_btn")
	private WebElement creditAmmountBTn;
	
	public CreditAmountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerAccoountNumberTextField() {
		return customerAccoountNumberTextField;
	}

	public WebElement getCreditAmmountTextField() {
		return creditAmmountTextField;
	}

	public WebElement getCreditAmmountBTn() {
		return creditAmmountBTn;
	}
	
	
	public void creditOnCustomerAccount(String accNum) {
	
	    customerAccoountNumberTextField.sendKeys(accNum);
		creditAmmountTextField.sendKeys("100000");
		creditAmmountBTn.click();
	}
	
}
