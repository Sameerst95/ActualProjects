package com.pomRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage {

	
	@FindBy(name="name")
	private WebElement nameTextField; 
	
	@FindBy(name="gender")
	private WebElement genderDD;
	

	@FindBy(name="mobile")
	private WebElement mobileTextField;
	
	@FindBy(name="email")
	private WebElement emailTextField;
	
	
	@FindBy(name="dob")
	private WebElement dobTextField;
	
	

	@FindBy(name="pan_no")
	private WebElement panTextField;
	
	

	@FindBy(name="citizenship")
	private WebElement citizenshipTextField;
	

	@FindBy(name="homeaddrs")
	private WebElement homeAddressTextField;
	
	

	@FindBy(name="officeaddrs")
	private WebElement officeAddressTextField;

	
	@FindBy(name="state")
	private WebElement stateDD;


	@FindBy(name="city")
	private WebElement cityDD;


	@FindBy(name="pin")
	private WebElement pinTextField;
	

	@FindBy(name="arealoc")
	private WebElement areaTextField;
	

	@FindBy(name="acctype")
	private WebElement accTypDD;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	
//    WebElement areaText= driver.findElement(By("arealoc"));
//    WebElement accTypDD=driver.findElement(By.name("acctype"));
//    WebElement submitBtn=driver.findElement(By.name("submit"));
	
	
	public OpenAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getNameTextField() {
		return nameTextField;
	}


	public WebElement getGenderDD() {
		return genderDD;
	}


	public WebElement getMobileTextField() {
		return mobileTextField;
	}


	public WebElement getEmailTextField() {
		return emailTextField;
	}


	public WebElement getDobTextField() {
		return dobTextField;
	}


	public WebElement getPanTextField() {
		return panTextField;
	}


	public WebElement getCitizenshipTextField() {
		return citizenshipTextField;
	}


	public WebElement getHomeAddressTextField() {
		return homeAddressTextField;
	}


	public WebElement getOfficeAddressTextField() {
		return officeAddressTextField;
	}


	public WebElement getStateDD() {
		return stateDD;
	}


	public WebElement getCityDD() {
		return cityDD;
	}


	public WebElement getPinTextField() {
		return pinTextField;
	}


	public WebElement getAreaTextField() {
		return areaTextField;
	}


	public WebElement getAccTypDD() {
		return accTypDD;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Buisiness Library
	
	public void fillTheDOB() throws AWTException
	{	
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
	
	public void createTheAccount() {
		
	}
	
	
	
	
   
}
