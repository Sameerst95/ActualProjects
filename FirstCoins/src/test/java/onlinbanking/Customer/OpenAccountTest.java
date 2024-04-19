package onlinbanking.Customer;

import static org.testng.Assert.*;


import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.pomRepository.ConfirmtionFormPage;
import com.pomRepository.HomePage;
import com.pomRepository.OpenAccountPage;
import com.pomRepository.PendigAccountPage;
import com.pomRepository.StaffHomePage;
import com.pomRepository.StaffLoginPage;

public class OpenAccountTest extends BaseClass{

	@Test()
	public void createTheAccountAndApproveItByStaffTest() throws IOException, AWTException, InterruptedException
	{
		
		int randomNum = jUtil.getRandomNo(100);

	
		String url = fUtil.readDataFromPropertyFile("url");
		String id = fUtil.readDataFromPropertyFile("staffId");
		String password = fUtil.readDataFromPropertyFile("password");
		HomePage home = new HomePage(driver);

		// Navigating to the url

		driver.get(url);

		String titel = driver.getTitle();

		String expHomePageTitel = eUtil.readDataFromExcelFile("HomePage", 1, 0);

		// Validating the home page
		
	    assertEquals(titel, expHomePageTitel);

		// Navigating to the Open Account page
		home.getOpenAccountBtn().click();

		String expopenAccountTitel = eUtil.readDataFromExcelFile("OpenAccount", 1, 0);

		 assertEquals(driver.getTitle(), expopenAccountTitel);
		// Entering the value in the textfields

		String name = eUtil.readDataFromExcelFile("OpenAccount", 1, 1) + randomNum;
		String gender = eUtil.readDataFromExcelFile("OpenAccount", 1, 2);
		String mobileNum = randomNum + "" + eUtil.readDataFromExcelFile("OpenAccount", 1, 3);
		System.out.println(mobileNum);
		String email = randomNum + "" + eUtil.readDataFromExcelFile("OpenAccount", 1, 4);
		System.out.println(email);
		String panNUm = eUtil.readDataFromExcelFile("OpenAccount", 1, 6);
		String citizen = randomNum + "" + eUtil.readDataFromExcelFile("OpenAccount", 1, 7);
		String homeAdd = eUtil.readDataFromExcelFile("OpenAccount", 1, 8);
		String officeAdd = eUtil.readDataFromExcelFile("OpenAccount", 1, 9);
		String state = eUtil.readDataFromExcelFile("OpenAccount", 1, 10);
		String city = eUtil.readDataFromExcelFile("OpenAccount", 1, 11);
		String area = eUtil.readDataFromExcelFile("OpenAccount", 1, 13);
		String pin = eUtil.readDataFromExcelFile("OpenAccount", 1, 12);
		String accType = eUtil.readDataFromExcelFile("OpenAccount", 1, 14);

		OpenAccountPage oAP = new OpenAccountPage(driver);
		oAP.getNameTextField().sendKeys(name);
		wUtil.selectFromDropDownUsingVisibleText(oAP.getGenderDD(), gender);
		oAP.getMobileTextField().sendKeys(mobileNum);
		oAP.getEmailTextField().sendKeys(email);

		oAP.getCitizenshipTextField().sendKeys(citizen);

		oAP.getHomeAddressTextField().sendKeys(homeAdd);
		oAP.getOfficeAddressTextField().sendKeys(officeAdd);
		wUtil.selectFromDropDownUsingVisibleText(oAP.getStateDD(), state);
		wUtil.selectFromDropDownUsingVisibleText(oAP.getCityDD(), city);
		oAP.getPanTextField().sendKeys(panNUm);
		oAP.getPinTextField().sendKeys(pin);
		oAP.getAreaTextField().sendKeys(area);
		wUtil.selectFromDropDownUsingVisibleText(oAP.getAccTypDD(), accType);
		oAP.fillTheDOB();
		// Handling the Calender using Robot class

		oAP.getSubmitBtn().click();

		ConfirmtionFormPage confirmPage = new ConfirmtionFormPage(driver);
		confirmPage.validatePage(driver);
		confirmPage.getConfirmSubmitBtn().click();

		String confirmPopup = wUtil.alertPopupGetText(driver);
		wUtil.alertPopupAccept(driver);

		assertTrue(confirmPopup.contains("Application submitted"));
		System.out.println("Application Submitted");
		
		String[] lines = confirmPopup.split("\\r?\\n");

		System.out.println(Arrays.toString(lines));
		
		String applicationNumber = "" ;
		for (String line : lines) {
			if (line.startsWith("Application number :")) {
				String[] parts = line.split(":");
				applicationNumber = parts[1].trim();
				break;
			}
		}

		System.out.println("Application Number :==>" + applicationNumber);

	
         assertEquals(driver.getTitle(), expHomePageTitel);
         System.out.println("Online Banking System page Displayed");
		
		// Navigating to the staff login
		home.clickOnStaffLogin();

		StaffLoginPage staffLoginPage = new StaffLoginPage(driver);
		staffLoginPage.validateStaffLoginPage();
		
		// Entering the data of staff page
		
		staffLoginPage.loginToStaff(id, password);

		// login to staff page
		// Navigating to staff home

		StaffHomePage sHP = new StaffHomePage(driver);

		sHP.validatStaffHomePage();
		sHP.clickOnApprovePendingAccountBtn();
		
		
		PendigAccountPage pAP = new PendigAccountPage(driver);
		pAP.getApplicationNumberTextFiled().sendKeys("" + applicationNumber);
		pAP.getSearchButton().click();
		 Thread.sleep(2000);
		pAP.getApproveButton().click();

		// Handling the Account number popup
		Thread.sleep(10000);
		String accountNumberText = wUtil.alertPopupGetText(driver);
		System.out.println(accountNumberText);
		
       
		wUtil.alertPopupAccept(driver);

		String accountNumber = jUtil.getNumberFromPopup(accountNumberText);
		System.out.println("Account number is :" + accountNumber);

		// Navigating to staff home

		sHP.getHomeBtn().click();

		// Clicking on view active customer

		sHP.getLogoutBtn().click();

		
		
		assertEquals(driver.getTitle(), "Staff Page");
		System.out.println("Staff Page is displayed");
		
		System.out.println("Customer account is created and approved by Staff");
		
		// Storing the Account Number, and pan into excel file for
		
		
		eUtil.writeDataInExcelFile("CustomerAccount", 1, 0, name, true);
		eUtil.writeDataInExcelFile("CustomerAccount", 1, 1, mobileNum, false);
		eUtil.writeDataInExcelFile("CustomerAccount", 1, 2, panNUm, false);
		eUtil.writeDataInExcelFile("CustomerAccount", 1, 3, accountNumber, false);
		eUtil.writeDataInExcelFile("CustomerAccount", 1, 4, email, false);
		
        
		
	}

}
