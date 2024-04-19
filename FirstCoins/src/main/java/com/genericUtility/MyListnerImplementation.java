package com.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListnerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		test = report.createTest(methodName);
		Reporter.log("Execution start from here");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName);
		Reporter.log(methodName+"----->Executed Successfully");
         		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		JavaUtility jUtil = new JavaUtility();
	

		try {
			WebDriverUtility wUtil = new WebDriverUtility();
		String path= wUtil.takeScreenshot(BaseClass.sDriver, methodName);
			test.log(Status.FAIL,methodName+"--Failed");
			test.log(Status.FAIL,result.getThrowable());
			test.addScreenCaptureFromPath(path);
			Reporter.log(methodName+"---->Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"-->Skipped");
		Reporter.log(methodName+"--->Skipped");

	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlReport.config().setDocumentTitle("COINFIRST");
		htmlReport.config().setReportName("SDET-55 Extent Report");
		htmlReport.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(htmlReport);

		report.setSystemInfo("platform", "windows11");
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Banking_System/");
		report.setSystemInfo("Reporter Name", "Gokul Kandpal");

	}

	@Override
	public void onFinish(ITestContext context) {
	 report.flush();

	}

}
