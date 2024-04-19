package com.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {

	WebDriver driver;
	
	@FindBy(name="apprvac")
	private WebElement approvePendingAccountBtn;
	
	@FindBy(name="credit_cust_ac")
	private WebElement creditCustomerBtn;
	
	@FindBy(name="view_cust_by_ac")
	private WebElement viewCustBtn;


	@FindBy(name="del_cust")
	private WebElement delCustomerBtn;

	
	
	public WebElement getDelCustomerBtn() {
		return delCustomerBtn;
	}




	public WebElement getViewCustBtn() {
		return viewCustBtn;
	}




	@FindBy(name="home")
	private WebElement homeBtn;

	@FindBy(name="logout_btn")
	private WebElement logoutBtn;
	
	
    public StaffHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	public WebDriver getDriver() {
		return driver;
	}




	public WebElement getApprovePendingAccountBtn() {
		return approvePendingAccountBtn;
	}
	
   
	
	public WebElement getHomeBtn() {
		return homeBtn;
	}




	public WebElement getLogoutBtn() {
		return logoutBtn;
	}




	public void clickOnApprovePendingAccountBtn() {
		approvePendingAccountBtn.click();
	}
	
	
	public WebElement getCreditCustomerBtn() {
		return creditCustomerBtn;
	}




	public void validatStaffHomePage() {
		String staffHome = driver.getTitle();

		if (staffHome.equals("Staff Home")) {
			System.out.println("Staff Home page is displayed");

		}
	}
    
    
    
}
