package com.wfm.qa.wmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.wfm.qa.base.TestBase;

public class TaskManagementPage extends TestBase {
	
	@FindBy(xpath="//span[text()='Task Management']")
	WebElement taskmanagementBtn;
	
	@FindBy(xpath="//span[text()='Create Task']")
	WebElement createtasktBtn;
	
	@FindBy(xpath="//select[@name=\"projectId\"]")
	WebElement selectprojectBtn;
	
	@FindBy(xpath="//input[@name=\"taskTitle\"]")
	WebElement tasknameTextBox;
	
	@FindBy(xpath="//textarea[@name=\"taskDetails\"]")
	WebElement taskdetailsTextBox;
	
	 @FindBy(xpath="//button[text()='Create Task']")
	 WebElement createBtn;
	 
	 @FindBy(xpath="//input[@placeholder=\"Search a task\"]")
	WebElement searchBtn;
	 
	public TaskManagementPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickonCreateTaskPage(String taskname, String details ,String search) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", taskmanagementBtn);
		Reporter.log("<B><font color = 'blue'> ==> -</font> Clicked On Task management");

		
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", createtasktBtn);
		Reporter.log("<B><font color = 'blue'> ==> -</font> Clicked On Create Task");

		
		Select select=new Select(driver.findElement(By.name("projectId")));
		select.selectByIndex(1);
		Reporter.log("<B><font color = 'blue'> ==> -</font> Selected project");

		
		tasknameTextBox.sendKeys(taskname);
		Reporter.log("<B><font color = 'blue'> ==> -</font> Entered  Taskname");

		taskdetailsTextBox.sendKeys(details);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", createBtn);
		
		searchBtn.sendKeys(search);
		
		
	}

}
