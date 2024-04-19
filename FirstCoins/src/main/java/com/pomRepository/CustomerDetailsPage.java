package com.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetailsPage {

	@FindBy(name="account_no")
	private WebElement accountNumberTextField;
	
	
	@FindBy(name="submit_view")
	private WebElement submitBtn;
	

	@FindBy(xpath="//label[contains(text(),'Account Name')]")
	private WebElement accountHolderName;
	
	 
	
	public WebElement getAccountHolderName() {
		return accountHolderName;
	}

	public CustomerDetailsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountNumberTextField() {
		return accountNumberTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	public void viewDetails(String number) {
		accountNumberTextField.sendKeys(number);
		submitBtn.click();
	}
	
	
}
