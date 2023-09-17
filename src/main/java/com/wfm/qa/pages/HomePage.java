package com.wfm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfm.qa.base.TestBase;

public class HomePage extends TestBase {
	

	@FindBy(xpath="//div[text()='Mahantesh S B']")
	WebElement usernameLable;
	
	@FindBy(xpath="//div[text()='Jobs']")
	WebElement jobLinks;
	
	@FindBy(xpath="//div[text()='Companies']")
	WebElement companiesLinks;
	
	@FindBy(xpath="//div[text()='Services']")
	WebElement serviceLinks;
	
//	public HomePage() {
//		PageFactory.initElements(driver, this);
//	}
	public HomePage() {
		PageFactory.initElements(driver, this );
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public JobPage clickonjobLink() {
		jobLinks.click();
		return new JobPage();
	}
	
	public CompaniesPage clickoncompaniesLink() {
		companiesLinks.click();
		return new CompaniesPage();
	}
	
	public ServicePage clickonserviceLink() {
		serviceLinks.click();
		return new ServicePage();
	}
	
	
	

}
