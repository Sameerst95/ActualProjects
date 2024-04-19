package onlinbanking.Customer;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.pomRepository.AddBeneficiaryPage;
import com.pomRepository.CreditAmountPage;
import com.pomRepository.FundTransferPage;
import com.pomRepository.HomePage;
import com.pomRepository.InternetBankingHomePage;
import com.pomRepository.InternetBankingLoginPage;
import com.pomRepository.OtpPage;
import com.pomRepository.StaffHomePage;
import com.pomRepository.StaffLoginPage;

public class FundTransferTest extends BaseClass {

	@Test()
	public void loginToAccountAndTransferTheFundTest() throws IOException, InterruptedException {

		String url = fUtil.readDataFromPropertyFile("url");
		String id = fUtil.readDataFromPropertyFile("staffId");
		String password = fUtil.readDataFromPropertyFile("password");

		driver.get(url);

		HomePage home = new HomePage(driver);
		home.clickOnStaffLogin();

		Thread.sleep(2000);

		if (driver.getTitle().contains("Staff Page")) {
			System.out.println("Staff Login Page is displayed");
		}

		StaffLoginPage staffLogin = new StaffLoginPage(driver);
		staffLogin.getUserNameTextField().sendKeys(id);

		staffLogin.getPasswordTextField().sendKeys(password);
		staffLogin.getLoginButton().click();

		FundTransferPage fundTranfer = new FundTransferPage(driver);

		if (driver.getTitle().contains("Staff Home")) {
			System.out.println("Staff Home Page is displayed");
		}

		CreditAmountPage creditAmountPage = new CreditAmountPage(driver);
		StaffHomePage staffHome = new StaffHomePage(driver);

		// Navigating for credit the amount from staff

		staffHome.getCreditCustomerBtn().click();
		String acntNumCre = eUtil.readDataFromExcelFile("CustomerAccount", 1, 3);
		creditAmountPage.creditOnCustomerAccount(acntNumCre);

		String textCredit = wUtil.alertPopupGetText(driver);
		System.out.println(textCredit);
		wUtil.alertPopupAccept(driver);

		// Loging out from the Staff
		staffHome.getLogoutBtn().click();

		System.out.println("Loged Out from Staff Page");

		home.getHomeBtn().click();

		System.out.println("Online Banking System Page(Home Page) is displayed");

		home.clickOnInternetBankingLogin(wUtil, driver);

		if (driver.getTitle().contains("Login Page")) {
			System.out.println("Login Page is displayed");
		}

		 InternetBankingLoginPage IBLPage=new InternetBankingLoginPage(driver);
	       String cxId=eUtil.readDataFromExcelFile("CustomerAccount", 5, 2);
	       String cxPass=eUtil.readDataFromExcelFile("CustomerAccount", 5, 0);
			 
	       IBLPage.loginToInternetBanking(cxId, cxPass);

		if (driver.getTitle().contains("My Profile")) {
			System.out.println("Customer Internet banking Home page(My Profile Page) is displayed");
		}
		// Thread.sleep(2000);
		InternetBankingHomePage iBHPage = new InternetBankingHomePage(driver);
		iBHPage.getFundTransfer().click();

		System.out.println("Fund Transfer feature is displayed");

		fundTranfer.getAddBeneficiaryBtn().click();

		if (driver.getTitle().contains("Add")) {
			System.out.println("Add Benificiary Page is displayed");
		}

		AddBeneficiaryPage addBenificiaryPage = new AddBeneficiaryPage(driver);

		String name = eUtil.readDataFromExcelFile("Beneficiary", 1, 0);
		String accountNumber = eUtil.readDataFromExcelFile("Beneficiary", 1, 1);
		String ifScCode = eUtil.readDataFromExcelFile("Beneficiary", 1, 2);
		String accntType = eUtil.readDataFromExcelFile("Beneficiary", 1, 3);

		addBenificiaryPage.addBenificciary(name, accountNumber, ifScCode, accntType, wUtil);

		String beniSucces = wUtil.alertPopupGetText(driver);
		System.out.println(beniSucces);

		driver.switchTo().alert().accept();

		iBHPage.getFundTransfer().click();

		System.out.println("Fund Transfer is displayed");

		wUtil.selectFromDropDownUsingIndex(fundTranfer.getBenificiaryDD(), 1);

		fundTranfer.getTransferAmountTextField().sendKeys("5000");

		fundTranfer.getTransferRemarkTextField().sendKeys("Happy");

		fundTranfer.getTranferBtn().click();

		System.out.println(driver.getTitle() + "page is displayed");

		OtpPage otpPage = new OtpPage(driver);
		String otpText = otpPage.getOtpMessage().getText();
		String otp = otpPage.getOtp(otpText);

		Thread.sleep(2000);
		System.out.println(otp);
		Thread.sleep(2000);
		otpPage.getOtpTextField().sendKeys(otp, Keys.ENTER);
		Thread.sleep(2000);
		String transText = wUtil.alertPopupGetText(driver);
		Thread.sleep(2000);
		wUtil.alertPopupAccept(driver);

		iBHPage.getLogOutBtn().click();
		System.out.println("Fund transfer is successfull and :Loged out from application");
	}

}
