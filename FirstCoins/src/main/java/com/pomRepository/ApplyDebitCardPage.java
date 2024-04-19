package com.pomRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage {

	@FindBy(name="holder_name")
	private WebElement accountHolderNameTextField;
	
	@FindBy(name="dob")
	private WebElement dobField;
	
	
	@FindBy(name="pan")
	private WebElement panTextField;

	@FindBy(name="mob")
	private WebElement mobileNumTextField;


	
	@FindBy(name="acc_no")
	private WebElement accountNumberTextField;


	
	@FindBy(name="dbt_crd_submit")
	private WebElement submitBtn;

     public ApplyDebitCardPage(WebDriver driver ) {
		PageFactory.initElements(driver,this);
	}
	
     
     
	
	public WebElement getAccountHolderNameTextField() {
		return accountHolderNameTextField;
	}




	public WebElement getDobField() {
		return dobField;
	}




	public WebElement getPanTextField() {
		return panTextField;
	}




	public WebElement getMobileNumTextField() {
		return mobileNumTextField;
	}




	public WebElement getAccountNumberTextField() {
		return accountNumberTextField;
	}




	public WebElement getSubmitBtn() {
		return submitBtn;
	}




	public void fillTheDobField() throws AWTException {
		dobField.click();
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
	
	public void applyDebitCardOnline(String accountHolderName,String pan,String mobileNum,String accntNumber) throws AWTException {

		accountHolderNameTextField.sendKeys(accountHolderName);

		fillTheDobField();

		panTextField.sendKeys(pan);

		mobileNumTextField.sendKeys(mobileNum);

		accountNumberTextField.sendKeys(accntNumber);

	    submitBtn.click();
	}
	public String[] fetchDebitAndPin(String text) {

		String[] lines = text.split("\\r?\\n");
		System.out.println(Arrays.toString(lines));
		String debitCardNum = "";
		String pin = "";
		String[] parts = null;

		for (String line : lines) {

			if (line.contains("Your Debit Card No is : ")) {
				// Split the line to get the application number
				parts = line.trim().split(" ");

				for (String part : parts) {
					if (isNumeric(part)) {
						if (debitCardNum.isEmpty()) {
							debitCardNum = part;
						} else {
							pin = part;
							break;
						}
					}
				}
			}
		}
		String[] arr = { debitCardNum, pin };
		return arr;
	}

	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
