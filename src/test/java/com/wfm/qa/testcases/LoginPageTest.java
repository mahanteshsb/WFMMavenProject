package com.wfm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.pages.HomePage;
import com.wfm.qa.pages.LogInPage;

public class LoginPageTest extends TestBase {

	LogInPage loginpage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
	
		 loginpage = new LogInPage();

	}

	   @Test(priority=1)
	public void loginPageTitleTest() {
		  String title= loginpage.validateLoginPageTitle();
		  Assert.assertEquals(title, "Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com");
	
	
	   }
	   
	   @Test(priority =2)
	   public void wfmLogoTest() {
		 boolean flag=  loginpage.validatewfmImage();
		 Assert.assertTrue(flag);
	   }
	   
	   @Test(priority=3)
	   public void loginTest() throws InterruptedException {
		  homePage= loginpage.LogIn(prop.getProperty("username"), prop.getProperty("password"));
	   }
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
