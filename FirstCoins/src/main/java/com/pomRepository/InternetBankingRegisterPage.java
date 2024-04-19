package com.pomRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingRegisterPage {

	@FindBy(name = "holder_name")
	private WebElement accountHolderNameTextField;

	@FindBy(name = "accnum")
	private WebElement accountNumTextField;

	@FindBy(name = "dbtcard")
	private WebElement debitCardNumberTextField;

	@FindBy(name = "dbtpin")
	private WebElement debitCardPinTextField;

	@FindBy(name = "mobile")
	private WebElement mobileNumberTextField;

	@FindBy(name = "pan_no")
	private WebElement panTextField;

	@FindBy(name = "dob")
	private WebElement dobTextField;

	@FindBy(name = "last_trans")
	private WebElement lastTransactionTextField;

	@FindBy(name = "password")
	private WebElement passwordTextField;

	@FindBy(name = "cnfrm_password")
	private WebElement confirmPasswordTextField;

	@FindBy(name = "submit")
	private WebElement submitTextField;

	public InternetBankingRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountHolderNameTextField() {
		return accountHolderNameTextField;
	}

	public WebElement getAccountNumTextField() {
		return accountNumTextField;
	}

	public WebElement getDebitCardNumberTextField() {
		return debitCardNumberTextField;
	}

	public WebElement getDebitCardPinTextField() {
		return debitCardPinTextField;
	}

	public WebElement getMobileNumberTextField() {
		return mobileNumberTextField;
	}

	public WebElement getPanTextField() {
		return panTextField;
	}

	public WebElement getDobTextField() {
		return dobTextField;
	}

	public WebElement getLastTransactionTextField() {
		return lastTransactionTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getSubmitTextField() {
		return submitTextField;
	}

	public void fillTheDob() throws AWTException {
		dobTextField.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_3);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_3);

	}

	public void registerForInternetBanking(String accountHolderName, String accntNumber, String debitCardNumber,
			String debitCardPin, String mobileNum, String pan, String password, String confirmPasword) throws AWTException {

		accountHolderNameTextField.sendKeys(accountHolderName);

		accountNumTextField.sendKeys(accntNumber);

		debitCardNumberTextField.sendKeys(debitCardNumber);

		debitCardPinTextField.sendKeys(debitCardPin);

        mobileNumberTextField.sendKeys(mobileNum);

		panTextField.sendKeys(pan);

		fillTheDob();

		lastTransactionTextField.sendKeys("0");

         passwordTextField.sendKeys(password);

		confirmPasswordTextField.sendKeys(confirmPasword);

		submitTextField.click();

	}

}
