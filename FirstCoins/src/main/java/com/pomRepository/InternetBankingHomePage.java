package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingHomePage {

	@FindBy(name = "logout_btn")
	private WebElement logOutBtn;

	@FindBy(xpath= "//li[text()='Fund Transfer']")
	private WebElement fundTransfer;
	
	@FindBy(xpath="//li[text()='Change Password']")
	private WebElement changePasswordBTN;

	public InternetBankingHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public WebElement getFundTransfer() {
		return fundTransfer;
	}

	public WebElement getChangePasswordBTN() {
		return changePasswordBTN;
	}

}
