package com.wfm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.pages.HomePage;
import com.wfm.qa.pages.JobPage;
import com.wfm.qa.pages.LogInPage;

public class HomePageTest extends TestBase {
	LogInPage loginpage;
	HomePage homepage;

//HomePage homepage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LogInPage();
		JobPage jobpage=new JobPage();
		loginpage.LogIn(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyHomePageTitleTest() {
		String homepageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "Home", "Homepage title is not matched ");
	}

	@Test
	public void verifyjobPagelink() {
		homepage.clickonjobLink();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
