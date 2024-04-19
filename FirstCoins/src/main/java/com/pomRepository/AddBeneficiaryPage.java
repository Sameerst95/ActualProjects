package com.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class AddBeneficiaryPage {

	
	
	
	@FindBy(name="beneficiary_name")
	private WebElement benificaryNameTextfield;
	
	@FindBy(name="beneficiary_acno")
	private WebElement accountNumberTextField;
	
	@FindBy(name="Ifsc_code")
	private WebElement Ifsc_codeTextField;
	

	@FindBy(name="beneficiary_acc_type")
	private WebElement accountTypeDD;
	
	
	
	@FindBy(name="add_beneficiary_btn")
	private WebElement addBtn;
	
	public WebElement getFundTransfer() {
		return fundTransfer;
	}


	@FindBy(xpath= "//li[text()='Fund Transfer']")
	private WebElement fundTransfer;
	
	
	public AddBeneficiaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getBenificaryNameTextfield() {
		return benificaryNameTextfield;
	}


	public WebElement getAccountNumberTextField() {
		return accountNumberTextField;
	}


	public WebElement getIfsc_codeTextField() {
		return Ifsc_codeTextField;
	}


	public WebElement getAccountTypeDD() {
		return accountTypeDD;
	}


	public WebElement getAddBtn() {
		return addBtn;
	}
	
	public void addBenificciary(String name,String accountNumber,String ifScCode,String accntType,WebDriverUtility wUtil) {
          
		

		benificaryNameTextfield.sendKeys(name);

		accountNumberTextField.sendKeys(accountNumber);

		Ifsc_codeTextField.sendKeys(ifScCode);

		wUtil.selectFromDropDownUsingVisibleText(accountTypeDD,accntType);

		addBtn.click();

	}
	
	
	
}
