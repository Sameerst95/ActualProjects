package onlinbanking.Staff;

import java.io.IOException;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.pomRepository.CustomerDetailsPage;
import com.pomRepository.HomePage;
import com.pomRepository.InternetBankingHomePage;
import com.pomRepository.StaffHomePage;
import com.pomRepository.StaffLoginPage;

public class StaffPageTest extends BaseClass {
    
	@Test
	public void viewCustomerByAccountNumTest()  throws IOException, InterruptedException {

		
	
		String url = fUtil.readDataFromPropertyFile("url");
		String stId = fUtil.readDataFromPropertyFile("staffId");
		String stPass = fUtil.readDataFromPropertyFile("password");

		int randomNum = jUtil.getRandomNo(100);

		// Opening the browser

		

		// Navigating to the url

		driver.get(url);
		Thread.sleep(2000);
		HomePage home = new HomePage(driver);
		home.clickOnStaffLogin();

		// Validating the staff page
		String staffTitel = driver.getTitle();
		if (staffTitel.equals("Staff Page")) {
			System.out.println("Staff Page is displayed");
		} else {
			System.out.println("Staff Page  is not displayed");
		}

		// Entering the data of staff page

		Thread.sleep(2000);
		StaffLoginPage sLP = new StaffLoginPage(driver);
		sLP.loginToStaff(stId, stPass);
		Thread.sleep(2000);

		StaffHomePage sHP = new StaffHomePage(driver);
		sHP.getViewCustBtn().click();

		CustomerDetailsPage cDPage = new CustomerDetailsPage(driver);
		String accNo = eUtil.readDataFromExcelFile("CustomerAccount", 1, 3);
		cDPage.viewDetails(accNo);

		Thread.sleep(2000);
		String accountHolderName = cDPage.getAccountHolderName().getText();

		System.out.println("Account Holder Name is :" + accountHolderName);

		Thread.sleep(2000);
		InternetBankingHomePage IBHPage = new InternetBankingHomePage(driver);

		IBHPage.getLogOutBtn().click();

	}

}
