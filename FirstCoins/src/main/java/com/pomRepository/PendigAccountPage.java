package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendigAccountPage { 
	
	WebDriver driver;
	@FindBy(name = "application_no")
	private WebElement applicationNumberTextFiled;

	@FindBy(name = "search_application")
	private WebElement searchButton;

	@FindBy(name = "approve_cust")
	private WebElement approveButton;

	
	public PendigAccountPage(WebDriver driver) {
		this.driver= driver;
      PageFactory.initElements(driver, this);
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getApplicationNumberTextFiled() {
		return applicationNumberTextFiled;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}


	public WebElement getApproveButton() {
		return approveButton;
	}
	
	
	
	
	
}
