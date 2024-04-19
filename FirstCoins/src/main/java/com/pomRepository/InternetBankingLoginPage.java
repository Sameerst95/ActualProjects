package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingLoginPage {

	@FindBy(name = "customer_id")
	private WebElement customerId;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "login-btn")
	private WebElement logInButton;

	public InternetBankingLoginPage(WebDriver driver) {

	   PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerId() {
		return customerId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogInButton() {
		return logInButton;
	}
	
	public void loginToInternetBanking(String id, String pass)
	{
		 customerId.sendKeys(id);
		 password.sendKeys(pass);
		 
		 logInButton.click();
		
	}

}
