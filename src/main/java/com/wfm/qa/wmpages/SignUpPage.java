package com.wfm.qa.wmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wfm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(xpath="//span[text()=\" Register here\"]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//input[@placeholder=\"Your Work Email Address*\"]")
	WebElement emailTextBox;
	
	@FindBy(xpath="//input[@name=\"userName\"]")
	WebElement nameTextBox;
	
	@FindBy(xpath="//input[@name=\"firstName\"]")
	WebElement firstnameTextBox;
	
	@FindBy(xpath="//input[@name=\"lastName\"]")
	WebElement lastnameTextBox;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@name=\"confirmPassword\"]")
	WebElement confirmpasswordTextBox;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@name=\"orgName\"]")
	WebElement companynameTestBox;
	
	@FindBy(xpath="//select[@name=\"country\"]")
	WebElement selectcountryBtn;
	
	@FindBy(xpath="//input[@placeholder=\"Work / Mobile No*\"]")
	WebElement phoneTextBox;
	
	@FindBy(xpath="//input[@placeholder=\"ZipCode*\"]")
	WebElement zipcodeTextBox;
	
	@FindBy(xpath="//input[@placeholder=\"Address*\"]")
	WebElement addressTextBox;
	
	@FindBy(xpath="//button[text()='Create account']")
	WebElement createaccountBtn;
	
	@FindBy(xpath="//div[@style=\"flex-grow: 1; font-size: 15px; padding: 8px 12px;\"]")
	WebElement successmessage;
	
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifysignupPage(String email, String un, String fn,String ln, String pwd, String  cpwd , String cmpy ,String phn , String zip , String addr)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SignUpBtn);
		
//		SignUpBtn.click();
		emailTextBox.sendKeys(email);
		nameTextBox.sendKeys(un);
		firstnameTextBox.sendKeys(fn);
		lastnameTextBox.sendKeys(ln);
		passwordTextBox.sendKeys(pwd);
		confirmpasswordTextBox.sendKeys(cpwd);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", continueBtn);
		
		
		companynameTestBox.sendKeys(cmpy);
		
		Select select=new Select(driver.findElement(By.name("country")));

//		select.deselectByVisibleText("India");
		select.selectByVisibleText("India");
		phoneTextBox.sendKeys(phn);
		zipcodeTextBox.sendKeys(zip);
		addressTextBox.sendKeys(addr);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", createaccountBtn);
		
		
	
	}
	
	public String validatecreatesuccessfullyaccountLable() {
//		 successmessage.isDisplayed();
		return successmessage.getAttribute("Admin stored successfully.");
//		return successmessage.getText();
	}
	

}
