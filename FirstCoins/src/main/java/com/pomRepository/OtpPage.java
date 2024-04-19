package com.pomRepository;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtpPage {

	@FindBy(xpath = "//label[@class='OTP_msg']")
	private WebElement otpMessage;

	@FindBy(name = "otpcode")
	private WebElement otpTextField;

	public OtpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOtpMessage() {
		return otpMessage;
	}

	public WebElement getOtpTextField() {
		return otpTextField;
	}
	
	public String getOtp(String text) {
		String[] lines = text.split("\\r?\\n");
		System.out.println(Arrays.toString(lines));

		String otp = "";
		for (String line : lines) {
			if (line.startsWith("*OTP :")) {

				String[] parts = line.split(":");

				otp = parts[1].trim();

				break;
			}
		}
		return otp;
	}

}
