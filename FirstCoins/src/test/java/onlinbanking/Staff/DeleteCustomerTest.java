package onlinbanking.Staff;

import java.io.IOException;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.pomRepository.DeleteCustomerPage;
import com.pomRepository.HomePage;
import com.pomRepository.StaffHomePage;
import com.pomRepository.StaffLoginPage;

public class DeleteCustomerTest  extends BaseClass{
	

	@Test
	public void deleteCustomerByStaffTest() throws IOException, InterruptedException {

		FileUtility fUtil = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

	
		String url = fUtil.readDataFromPropertyFile("url");
		String stId = fUtil.readDataFromPropertyFile("staffId");
		String stPass = fUtil.readDataFromPropertyFile("password");

		// Opening the browser

		// Navigating to the url
		driver.get(url);
		Thread.sleep(2000);
		HomePage home= new HomePage(driver);
		home.clickOnStaffLogin();

		// Validating the staff page
	    StaffHomePage stHome= new StaffHomePage(driver);
	    StaffLoginPage stLogin=new StaffLoginPage(driver);
	    
	    stLogin.validateStaffLoginPage();
	   
	    stLogin.loginToStaff(stId, stPass);
	    

		// Entering the data of staff page
		
	    DeleteCustomerPage dcp=new DeleteCustomerPage(driver);
		
		stHome.getDelCustomerBtn().click();
		
		String accountNum=eUtil.readDataFromExcelFile("CustomerAccount", 1, 3);
		String acId=eUtil.readDataFromExcelFile("CustomerAccount", 5, 2);
		
		dcp.deleteTheAccount(accountNum,acId, "Illegal");
		
		String text =wUtil.alertPopupGetText(driver);
		System.out.println(text);
		wUtil.alertPopupAccept(driver);
		Thread.sleep(2000);
		stHome.getLogoutBtn().click();

		System.out.println("Logout from the staff login");

	}

}
