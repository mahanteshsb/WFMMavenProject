package com.wfm.qa.wfmtestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.pages.LogInPage;
import com.wfm.qa.wmpages.SignInPage;

public class SigninPageTest extends TestBase {
SignInPage signinpage;
	public SigninPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 signinpage=new SignInPage();
	}
	
	
	@Test (priority=1)
	public void signinPageTitleTest() {
		
		String title=signinpage.validateSigninPageTitle();
		
		Assert.assertEquals(title, "EMP");
		
	}
	
	
	@Test(priority=2)
	public void signinPagelogoTest() {
		boolean flag=signinpage.validatewfmImage();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void signinTest() {
		signinpage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
