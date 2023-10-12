package com.wfm.qa.wmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.util.TestUtil;

public class Dashboard extends TestBase{
	
	TestUtil testutil=new TestUtil();
	
	@FindBy(xpath="//span[text()='Project Management']")
	WebElement projectmanagementBtn;
	
	@FindBy(xpath="(//span[@class=\"block truncate font-normal\"])[2]")
	WebElement taskmanagementBtn;
	
	@FindBy(xpath="//h1[text()='Task Progress']")
	WebElement taskmanagementLable;
	
	@FindBy(xpath="(//select[@class=\"py-2 block text-base w-full px-5 pr-11 mt-0 bg-transparent appearance-none z-1 focus:outline-none focus:ring-0 focus:border-black border-gray-200\"])[1]")
	WebElement selectproject;
	
	@FindBy(xpath="(//span[@class=\"block truncate font-normal\"])[3]")
	WebElement subtasktmanagementBtn;
	
	@FindBy(xpath="//h1[text()='Subtask Status']")
	WebElement subtaskmanagementLable;
	
	@FindBy(xpath="(//span[@class=\"block truncate font-normal\"])[4]")
	WebElement permissionmanagementBtn;
	
	@FindBy(xpath="//h1[text()='Project Members']")
	WebElement permissionmanagentLable;
	
	@FindBy(xpath="(//span[@class=\"block truncate font-normal\"])[5]")
	WebElement activitymanagementBtn;
	
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDashboardProject() {
		testutil.waitForPageToLoad();
//		projectmanagementBtn.click();
//		taskmanagementBtn.click();
		testutil.highlightElement(driver, projectmanagementBtn);
//		
		testutil.waitForPageToLoad();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", projectmanagementBtn);
		
		testutil.waitForPageToLoad();

//		projectLink.click();
		testutil.highlightElement(driver, taskmanagementBtn);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", taskmanagementBtn);
		
		testutil.highlightElement(driver, selectproject);
		Select select=new Select(driver.findElement(By.xpath("(//select[@class=\"py-2 block text-base w-full px-5 pr-11 mt-0 bg-transparent appearance-none z-1 focus:outline-none focus:ring-0 focus:border-black border-gray-200\"])[1]")));
		select.selectByIndex(1);
	}
	
public String verifytaskmanagentLable() {
	testutil.waitForPageToLoad();

	testutil.highlightElement(driver, taskmanagementLable);
	testutil.waitForPageToLoad();

	return taskmanagementLable.getText();
	
}
}
