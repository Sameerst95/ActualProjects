package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {

	@FindBy(name = "oldpass")
	private WebElement oldPasswordTextField;

	@FindBy(name = "cnfrm")
	private WebElement cnfirmPasswordTextField;

	@FindBy(name = "newpass")
	private WebElement newPasswordTextField;

	@FindBy(name = "change_pass")
	private WebElement changePassBtn;

	public ChangePasswordPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getOldPasswordTextField() {
		return oldPasswordTextField;
	}

	public WebElement getCnfirmPasswordTextField() {
		return cnfirmPasswordTextField;
	}

	public WebElement getNewPasswordTextField() {
		return newPasswordTextField;
	}

	public WebElement getChangePassBtn() {
		return changePassBtn;
	}

	public void changePassword(String oldPass, String confirmPass, String newPass) {
		oldPasswordTextField.sendKeys(oldPass);
		cnfirmPasswordTextField.sendKeys(confirmPass);
		newPasswordTextField.sendKeys(newPass);

		changePassBtn.click();
	}

}
