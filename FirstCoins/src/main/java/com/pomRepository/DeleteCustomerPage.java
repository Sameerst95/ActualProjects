package com.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

	@FindBy(name="Cust_ac_no")
	private WebElement customerAccountNumberTextField;
	
	

	@FindBy(name="Cust_ac_Id")
	private WebElement customerAccountId;
	
	

	@FindBy(name="reason")
	private WebElement resonTextField;
	
	
	@FindBy(name="delete")
	private WebElement deleteBtn;
	
	public DeleteCustomerPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerAccountNumberTextField() {
		return customerAccountNumberTextField;
	}

	public WebElement getCustomerAccountId() {
		return customerAccountId;
	}

	public WebElement getResonTextField() {
		return resonTextField;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	public void deleteTheAccount(String accNo,String id,String reson ) {
		customerAccountNumberTextField.sendKeys(accNo);
		customerAccountId.sendKeys(id);
		resonTextField.sendKeys(reson);
		deleteBtn.click();
	}
	
   
	
}


