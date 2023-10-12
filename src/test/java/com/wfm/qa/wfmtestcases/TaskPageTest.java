package com.wfm.qa.wfmtestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.util.TestUtil;
import com.wfm.qa.wmpages.HomePage;
import com.wfm.qa.wmpages.SignInPage;
import com.wfm.qa.wmpages.TaskManagementPage;

import org.testng.ITestNGListener;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

public class TaskPageTest extends TestBase {
	SignInPage signinpage;
	TestUtil testutil;
	HomePage homepage;
	TaskManagementPage taskmanagement;
	String sheertName = "task";

	public TaskPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		signinpage = new SignInPage();
		homepage = signinpage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
		taskmanagement = new TaskManagementPage();
	}

	@DataProvider(name = "tasktdata")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] {

				{ "Task 11", "Welcome to Project", "Task 11" }, { "Task 12", "Welcome to Project", "Task 12" },
//				{ "Task 13", "Welcome to Project", "Tassk 13" }, { "Task 14", "Welcome to Task Management", "Task 14" },
//				{ "Task 15", " Welcome to Task Management", "Task 15" },
//				{ "Task 16", "Welcome to Task Management ", "Task 16" },
//				{ "Task 17", "Welcome to Task Management", "Task 17" },
//				{ "Task 18", "Welcome to Task Management", "Task 18" },
//				{ "Task 19", "Welcome to Task Management", "Task 19" },
//				{ "Task 20", "Welcome to Task Management", "Task 20" },
//				{ "Task 10", "Welcome to Task Management", "Task 10" },
//				{ "Task 111", "Welcome to Project", "Task 111" }, { "Task 121", "Welcome to Project", "Task 121" },
//				{ "Task 131", "Welcome to Project", "Tassk 131" },
//				{ "Task 141", "Welcome to Task Management", "Task 141" },
//				{ "Task 151", " Welcome to Task Management", "Task 151" },
//				{ "Task 161", "Welcome to Task Management ", "Task 161" },
//				{ "Task 171", "Welcome to Task Management", "Task 171" },
//				{ "Task 181", "Welcome to Task Management", "Task 181" },
//				{ "Task 191", "Welcome to Task Management", "Task 191" },
				{ "Task 201", "Welcome to Task Management", "Task 201" }, };

	}

	@Test(dataProvider = "tasktdata")
	public void verifyTaskManagement(String taskname, String details, String search) {
		taskmanagement.clickonCreateTaskPage(taskname, details, search);
	}

	@AfterMethod
	public void setDown() {
		driver.quit();
	}

}
