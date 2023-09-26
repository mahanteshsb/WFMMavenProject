package com.wfm.qa.wmpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfm.qa.base.TestBase;

public class ProjectPage extends TestBase {
	
	@FindBy(xpath="//span[text()='All Projects']")
	WebElement projectLable1;
	
	@FindBy(xpath="//span[text()='Create Project']")
	WebElement createprojectBtn;
	
	@FindBy(xpath="//input[@name=\"projectName\"]")
	WebElement projectName;
	
	
	@FindBy(xpath="//textarea[@name=\"description\"]")
	WebElement descriptionBtn;
	
	
	@FindBy(xpath="//button[text()='Create project']")
	WebElement createBtn;
	
	@FindBy(xpath="//h2[text()='Projects']")
	WebElement projectLable;
	
	
	public ProjectPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyprojectLable() {
		return projectLable.isDisplayed();
	}
	
	public void clickOnCreateprojectLink() {
//		createprojectBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", createprojectBtn);
	}
public void verifycreateprojectLink(String projectname, String description) {
	
	projectName.sendKeys(projectname);
	descriptionBtn.sendKeys(description);
//	createBtn.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", createBtn);
	
	
}

public boolean verifyAllprojectLable() {
	return projectLable.isDisplayed();
}


}
