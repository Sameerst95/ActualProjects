package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

/**
 * @author Gokul Kandpal
 */
public class HomePage {

	// Finding elements

	@FindBy(xpath = "//li[text()='Open Account']")
	private WebElement openAccountBtn;

	@FindBy(xpath = "//li[text()='Apply Debit Card']")
	private WebElement applyDebitCardBtn;

	@FindBy(xpath = "//a[contains(text(),'Internet Banking')]")
	private WebElement internetBankinBtn;

	@FindBy(xpath = "//li[text()='Fund Transder']")
	private WebElement fundTransferBtn;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement homeBtn;

	@FindBy(xpath = "//a[contains(text(),'Staff Login')]")
	private WebElement staffLoginBtn;

	@FindBy(xpath = "//li[contains(text(),'Login')]")
	private WebElement internetBankingLoginBtn;

	@FindBy(xpath = "//li[contains(text(),'Register')]")
	private WebElement internetBankingRegisterBtn;

	// Intialization through constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Getter methods
	public WebElement getOpenAccountBtn() {
		return openAccountBtn;
	}

	public WebElement getInternetBankingLoginBtn() {
		return internetBankingLoginBtn;
	}

	public WebElement getInternetBankingRegisterBtn() {
		return internetBankingRegisterBtn;
	}

	public WebElement getApplyDebitCardBtn() {
		return applyDebitCardBtn;
	}

	public WebElement getInternetBankinBtn() {
		return internetBankinBtn;
	}

	public WebElement getFundTransferBtn() {
		return fundTransferBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getStaffLoginBtn() {
		return staffLoginBtn;
	}

	// Buisiness Logic

	public void clickOnInternetBankingRegister(WebDriverUtility wUtil, WebDriver driver) {
		wUtil.scrollActionJavaScript(driver, internetBankinBtn);
		wUtil.mouseHover(driver, internetBankinBtn);
		internetBankingRegisterBtn.click();
	}

	public void clickOnInternetBankingLogin(WebDriverUtility wUtil, WebDriver driver) {
		wUtil.scrollActionJavaScript(driver, internetBankinBtn);
		wUtil.mouseHover(driver, internetBankinBtn);
		internetBankingLoginBtn.click();
	}

	public void clickOnStaffLogin() {
         staffLoginBtn.click();
	}

}
