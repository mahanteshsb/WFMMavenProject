package com.wfm.qa.wfmtestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.util.TestUtil;
import com.wfm.qa.wmpages.Dashboard;
import com.wfm.qa.wmpages.HomePage;
import com.wfm.qa.wmpages.SignInPage;

public class DashboardPageTest extends TestBase{
	SignInPage signinpage;
	HomePage homepage;
	TestUtil testutil;
	Dashboard dashboard;
	
	public DashboardPageTest () {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signinpage=new SignInPage();
		homepage=signinpage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
		dashboard=new Dashboard();
	}
	
	@Test
	public void validateDashboardPageTest() {
		dashboard.clickOnDashboardProject();
		String text=dashboard.verifytaskmanagentLable();
//		Assert.assertEquals(text, "Task Progress","Task Management Failed =");
//		System.out.println("Test cases Successfully Passed=" +text);
	}
@AfterMethod
public void tearDown() {
//	driver.close();
}
}
