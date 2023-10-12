package com.wfm.qa.wmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wfm.qa.base.TestBase;

public class SubTaskPage extends TestBase{
	
	@FindBy(xpath="//span[text()='Task Management']")
	WebElement taskmanagementBtn;
	
	@FindBy(xpath="//span[text()='All Tasks']")
	WebElement AlltaskBtn;
	 
	@FindBy(xpath="//button[text()='Create Sub-task']")
WebElement createsubtaskBtn;
	
	@FindBy(xpath="//select[@name=\"taskId\"]")
	WebElement selecttaskBtn;
	
	@FindBy(xpath="//input[@name=\"subTaskTitle\"]")
	WebElement subtaskTitle;
	
	@FindBy(xpath="//textarea[@name=\"subTaskDetails\"]")
	WebElement subtaskDetails;
	
	@FindBy(xpath="//button[text()=' Create']")
	WebElement createBtn;
	
	public SubTaskPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifycreatesubtask(String suntaskname, String subdetails) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", taskmanagementBtn);
		
		js.executeScript("arguments[0].click();", AlltaskBtn);
		
		js.executeScript("arguments[0].click();", createsubtaskBtn);
		
		
		Select select=new Select(driver.findElement(By.xpath("//select[@name=\"taskId\"]")));
		select.selectByIndex(3)	;
		
		subtaskTitle.sendKeys(suntaskname);
		
		subtaskDetails.sendKeys(subdetails);
		
		js.executeScript("arguments[0].click();", createBtn);

	}
	
	
}
