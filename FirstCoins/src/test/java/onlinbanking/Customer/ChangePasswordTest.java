package onlinbanking.Customer;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.pomRepository.ChangePasswordPage;
import com.pomRepository.HomePage;
import com.pomRepository.InternetBankingHomePage;
import com.pomRepository.InternetBankingLoginPage;

@Listeners(com.genericUtility.MyListnerImplementation.class)
public class ChangePasswordTest extends BaseClass {
    
	@Test()
	public void changePasswordOfLoginAndLoginAgainWithChangedPasswordTest()
			throws EncryptedDocumentException, IOException, InterruptedException {
		
		int count=0;
		FileUtility fUtil = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		String url = fUtil.readDataFromPropertyFile("url");
		int randomNumber = jUtil.getRandomNo(100);
		driver.get(url);
		
		HomePage home = new HomePage(driver);
		InternetBankingLoginPage IBLpage = new InternetBankingLoginPage(driver);
		home.clickOnInternetBankingLogin(wUtil, driver);

		if (driver.getTitle().contains("Login Page")) {
			System.out.println("Login Page is displayed");
		}
//		Assert.fail();
		System.out.println(count++);
//		Assert.fail();
		String sheetName = "CustomerAccount";
		String cxId = eUtil.readDataFromExcelFile(sheetName, 5, 2);
		String cxPass = eUtil.readDataFromExcelFile(sheetName, 5, 0);

		IBLpage.loginToInternetBanking(cxId, cxPass);

		if (driver.getTitle().contains("My Profile")) {
			System.out.println("Customer Internet banking Home page(My Profile Page) is displayed");
		}

		InternetBankingHomePage IBHpage = new InternetBankingHomePage(driver);
		IBHpage.getChangePasswordBTN().click();
		System.out.println(randomNumber);
		System.out.println(driver.getTitle() + "is displayed");

		String pass = eUtil.readDataFromExcelFile("CustomerAccount", 5, 0);
		String newPass = "Nobita" + randomNumber;
		ChangePasswordPage cPasswordPage = new ChangePasswordPage(driver);

		cPasswordPage.changePassword(pass, pass, newPass);
		System.out.println(newPass);

		eUtil.writeDataInExcelFile("CustomerAccount", 5, 0, newPass, false);
		eUtil.writeDataInExcelFile("CustomerAccount", 5, 1, newPass, false);

		System.out.println("Password changed successfully");

		String passText = wUtil.alertPopupGetText(driver);
		System.out.println(passText + " message is displayed");
		Thread.sleep(2000);
		wUtil.alertPopupAccept(driver);

		IBHpage.getLogOutBtn().click();
		System.out.println("Loged Out from the application! Login Page is displayed");

		String cxId1 = eUtil.readDataFromExcelFile(sheetName, 5, 2);
		String cxPass1 = eUtil.readDataFromExcelFile(sheetName, 5, 0);

		IBLpage.loginToInternetBanking(cxId1, cxPass1);

		System.out.println("Login successfull with the changed password");
//      System.out.println("Passed");
		IBHpage.getLogOutBtn().click();
		System.out.println("Passed :Password is changed and with new password we can login");
	
	}

}
