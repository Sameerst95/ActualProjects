package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {

	WebDriver driver;

	@FindBy(name = "staff_id")
	private WebElement userNameTextField;

	@FindBy(name = "password")
	private WebElement passwordTextField;

	@FindBy(name = "staff_login-btn")
	private WebElement loginButton;

	public StaffLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void clickOnLoginButton() {

		loginButton.click();
	}

	public void validateStaffLoginPage() {
		String staffTitel = driver.getTitle();

		if (staffTitel.equals("Staff Page")) {
			System.out.println("Staff Page is displayed");
		}

	}

	public void loginToStaff(String id, String pass) {
		userNameTextField.sendKeys(id);
		passwordTextField.sendKeys(pass);
		loginButton.click();
	}

}
