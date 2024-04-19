package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmtionFormPage {

	@FindBy(name = "cnfrm-submit")
	private WebElement confirmSubmitBtn;
	
	
	public ConfirmtionFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getConfirmSubmitBtn() {
		return confirmSubmitBtn;
	}
	
	
	public void validatePage(WebDriver driver) {
		String confirmTitel = driver.getTitle();

		if (confirmTitel.equals("Confirm")) {
			System.out.println("Confirmation Page is displayed");
	}
	
	

	}}
