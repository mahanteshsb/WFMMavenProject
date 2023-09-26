package com.wfm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfm.qa.base.TestBase;

public class LogInPage extends TestBase {

	@FindBy(xpath = "//input[@id=\"usernameField\"]")
	WebElement UserName;

	@FindBy(xpath = "//input[@id=\"passwordField\"]")
	WebElement Password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement SignUpBtn;

	@FindBy(xpath = "//img[@alt=\"Naukri Logo\"]")
	WebElement wfmlogo;

	
//	Initializing the Page Objects: 
	public LogInPage() {
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(driver, this);
	}

	// Actions :
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validatewfmImage() {
		return wfmlogo.isDisplayed();
	}

	public HomePage LogIn(String un, String pwd) {

		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();

	}
}
