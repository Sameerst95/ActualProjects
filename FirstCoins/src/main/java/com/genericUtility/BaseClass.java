package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {

	public DataBaseUtility dbUtil=new DataBaseUtility();
	public FileUtility fUtil=new FileUtility();
    public ExcelUtility eUtil= new ExcelUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver;
	
	public static WebDriver sDriver;
	@BeforeSuite ()
	public void connectToDB() throws SQLException {
		dbUtil.getConnection();
		System.out.println("Database Connected");
		Reporter.log("Db connected ",true);
		
	}
	
	@BeforeClass()
	public void launchTheBrowses() throws IOException {
		
		String browser = fUtil.readDataFromPropertyFile("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();

		}
		sDriver=driver;
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 20);
		Reporter.log("--Lunched the browser--");
	}

	@AfterClass()
	public void closeTheBrowser()
	{
		
	driver.quit();
		Reporter.log("--Closed the browser--");
	}
	
	@AfterSuite()
	public void closeTheDBConnection() throws SQLException {
		dbUtil.closeConnection();
		Reporter.log("DB connection closed",true);
	}
}
