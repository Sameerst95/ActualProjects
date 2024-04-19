package onlinbanking.Customer;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.pomRepository.ApplyDebitCardPage;
import com.pomRepository.HomePage;
import com.pomRepository.InternetBankingHomePage;
import com.pomRepository.InternetBankingLoginPage;
import com.pomRepository.InternetBankingRegisterPage;


public class InternetBankingRegisterTest extends BaseClass {
     
	@Test()
	public void applyForDebitCardThenRegisterForInternewBankingTest() throws IOException, AWTException, InterruptedException{

		int randomNum = jUtil.getRandomNo(100);
		
		String url = fUtil.readDataFromPropertyFile("url");
		
		// Getting the data from Excel File
		String accountHolderName = eUtil.readDataFromExcelFile("CustomerAccount", 1, 0);
		String pan = eUtil.readDataFromExcelFile("CustomerAccount", 1, 2);
		String mobileNum = eUtil.readDataFromExcelFile("CustomerAccount", 1, 1);
		String accntNumber = eUtil.readDataFromExcelFile("CustomerAccount", 1, 3);

		driver.get(url);
		
		HomePage home = new HomePage(driver);
		home.getApplyDebitCardBtn().click();

		ApplyDebitCardPage applyDebitCard = new ApplyDebitCardPage(driver);
		
		applyDebitCard.applyDebitCardOnline(accountHolderName, pan, mobileNum, accntNumber);
        
		String text = wUtil.alertPopupGetText(driver);
	
		System.out.println(text);
		// Storing the Debit card number is Pin in the excel

		String[] arr = applyDebitCard.fetchDebitAndPin(text);

		eUtil.writeDataInExcelFile("CustomerAccount", 1, 5, arr[0], false);
		eUtil.writeDataInExcelFile("CustomerAccount", 1, 6, arr[1], false);

		wUtil.alertPopupAccept(driver);

		// Navigating the home page
		home.getHomeBtn().click();

		home.clickOnInternetBankingRegister(wUtil, driver);

		// Validating the Internet banking registration page
		
		assertTrue(driver.getTitle().contains("Internet Banking Registration"));
		System.out.println("Internet Banking Registration page is displayed");
		
		String debitCardNumber=eUtil.readDataFromExcelFile("CustomerAccount", 1, 5);
		String debitCardPin=eUtil.readDataFromExcelFile("CustomerAccount", 1, 6);
		String password=eUtil.readDataFromExcelFile("CustomerAccount", 5, 0);
		String confirmPasword=eUtil.readDataFromExcelFile("CustomerAccount", 5, 1);
		
		// Filling the Data in internet banking registration
		InternetBankingRegisterPage IBRPage = new InternetBankingRegisterPage(driver);
		IBRPage.registerForInternetBanking(accountHolderName, accntNumber, debitCardNumber, debitCardPin, mobileNum, pan, password, confirmPasword);

		System.out.println("Internet Banking registration is successfull");

		Thread.sleep(2000);
		String internetBankingText = wUtil.alertPopupGetText(driver);
		String internetAccountNumber = "";
		for (int i = 0; i < internetBankingText.length(); i++) {
			if (Character.isDigit(internetBankingText.charAt(i))) {
				internetAccountNumber += internetBankingText.charAt(i);
			}
		}

		wUtil.alertPopupAccept(driver);
		System.out.println(internetAccountNumber);

		eUtil.writeDataInExcelFile("CustomerAccount", 5, 2, internetAccountNumber, false);

		
	      home.getHomeBtn().click();

		System.out.println("Navigated to Home page");
		home.clickOnInternetBankingLogin(wUtil, driver);


	
			
		
		assertEquals(driver.getTitle(),"Login Page");
		System.out.println("Login Page is displayed");
		
       InternetBankingLoginPage IBLPage=new InternetBankingLoginPage(driver);
       String cxId=eUtil.readDataFromExcelFile("CustomerAccount", 5, 2);
       String cxPass=eUtil.readDataFromExcelFile("CustomerAccount", 5, 0);
		
       IBLPage.loginToInternetBanking(cxId, cxPass);
       
			
		assertEquals(driver.getTitle(),"My Profile");
		System.out.println("Login successfull! and My Profile page is displayed");
		
//		Thread.sleep(3000);
		InternetBankingHomePage IBHPage=new InternetBankingHomePage(driver);
		
		IBHPage.getLogOutBtn().click();

		
		assertEquals(driver.getTitle(),"Login Page");
		System.out.println("Logout successfull! and My Profile page is displayed");

	}	
}
