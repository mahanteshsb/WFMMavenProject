package com.wfm.qa.wfmtestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.util.TestUtil;
import com.wfm.qa.wmpages.HomePage;
import com.wfm.qa.wmpages.SignInPage;
import com.wfm.qa.wmpages.SubTaskPage;
import com.wfm.qa.wmpages.TaskManagementPage;

public class SubTaskPageTest extends TestBase{
	SignInPage signinpage;
	TestUtil testutil;
	HomePage homepage;
	SubTaskPage subtask;
	String sheertName = "task";
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		signinpage = new SignInPage();
		homepage = signinpage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
		subtask = new SubTaskPage();
	}

	@DataProvider(name = "tasktdata")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] {

				{ "Sub-Task 11", "Welcome to Project" },
				{ "Sub-Task 12", "Welcome to Project" },
				{ "Sub-Task 201", "Welcome to Task Management"}, };

	}
	
	@Test(dataProvider = "tasktdata")
	public void verifyTaskManagement(String suntaskname, String subdetails) {
		
		subtask.verifycreatesubtask(suntaskname, subdetails);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
