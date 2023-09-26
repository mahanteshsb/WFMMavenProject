package com.wfm.qa.wmpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfm.qa.base.TestBase;

public class SignInPage extends TestBase {

	@FindBy(xpath = "//input[@type=\"email\"]")
	WebElement emailBtn;

	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement passwordBtn;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement signinBtn;

	@FindBy(xpath = "(//img[@alt=\"EmpMonitor\"])[1]")
	WebElement wfmlogo;

//	Initializing the Page Objects: 
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateSigninPageTitle() {
		return driver.getTitle();
	}

	public boolean validatewfmImage() {
		return wfmlogo.isDisplayed();
	}

	public HomePage SignIn(String un, String pwd) {
		emailBtn.sendKeys(un);
		passwordBtn.sendKeys(pwd);
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signinBtn);
		
		return new HomePage();

	}

}
