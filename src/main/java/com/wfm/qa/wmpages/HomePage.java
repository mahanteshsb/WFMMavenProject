package com.wfm.qa.wmpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfm.qa.base.TestBase;

public class HomePage extends  TestBase{
	
	@FindBy(xpath="//span[text()='SR']")
	WebElement userLable;

	@FindBy(xpath="//span[text()='Projects']")
	WebElement projectLink;
	
	@FindBy(xpath="//span[text()='Task Management']")
	WebElement taskmanagementLink;
	
	@FindBy(xpath="//span[text()='Members']")
	WebElement memberLink;
	
	@FindBy(xpath="Reports")
	WebElement reportLink;
	
public	HomePage(){
		PageFactory.initElements(driver, this);
	}

public String  verifyHomePageTitle() {
	return driver.getTitle();
}

public boolean verifycorrectName() {
	return userLable.isDisplayed();
}
	
	public ProjectPage clickOnProjectLink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", projectLink);
//		projectLink.click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", taskmanagementLink);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", memberLink);
		
		return new ProjectPage();
	}
	
	
//	public TaskManagementPage clickOnTaskManagementLink() {
////		taskmanagementLink.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", taskmanagementLink);
//		return new TaskManagementPage();
//	}
//	
//	public MemberPage clickOnMemberLink() {
////		memberLink.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", memberLink);
//		return new MemberPage();
//	}
	
}
