package com.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {

	
	@FindBy(name="add_beneficiary")
	private WebElement addBeneficiaryBtn;
	
	
	@FindBy(name="beneficiary")
	private WebElement benificiaryDD;
	

	@FindBy(name="trnsf_amount")
	private WebElement transferAmountTextField;

	@FindBy(name="trnsf_remark")
	private WebElement transferRemarkTextField;
	
	@FindBy(name="fnd_trns_btn")
	private WebElement tranferBtn;

  
	
	
	public WebElement getBenificiaryDD() {
		return benificiaryDD;
	}

	public WebElement getTransferAmountTextField() {
		return transferAmountTextField;
	}

	public WebElement getTransferRemarkTextField() {
		return transferRemarkTextField;
	}

	public WebElement getTranferBtn() {
		return tranferBtn;
	}

	public FundTransferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddBeneficiaryBtn() {
		return addBeneficiaryBtn;
	}
	
	
	
	
	

}
