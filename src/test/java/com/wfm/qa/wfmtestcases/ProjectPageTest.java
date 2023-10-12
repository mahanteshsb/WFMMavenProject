package com.wfm.qa.wfmtestcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.util.TestUtil;
import com.wfm.qa.wmpages.HomePage;
import com.wfm.qa.wmpages.ProjectPage;
import com.wfm.qa.wmpages.SignInPage;

import org.testng.ITestNGListener;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

public class ProjectPageTest extends TestBase {
	
	SignInPage signinpage;
	HomePage homepage;
	TestUtil testutil;
	ProjectPage projectpage;
	
String sheertName="project";

	public ProjectPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		projectpage = new ProjectPage();
		signinpage = new SignInPage();
		homepage = signinpage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
		projectpage = homepage.clickOnProjectLink();
	}

	 @DataProvider(name="projectdata")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	            { "Project12", "Welcome to Project" ,"Project12"},
	            { "Project22", "Welcome to Project","Project22" },
	            { "Project33", "Welcome to Project" ,"Project33"}
	        };

	    }


/*	
	@DataProvider
	public Object [][] getwfmTestData() throws InvalidFormatException {
		 Object data[][]=	testutil.getTestData(sheertName);
		 return data;
	}
	
	@Test(dataProvider="getwfmTestData")
	public void verifycreateprojectTest(String projectname, String description, String search) {
//		public void verifycreateprojectTest() {
			projectpage.clickOnCreateprojectLink();
			projectpage.verifycreateprojectLink(projectname, description, search);

		} */
//
	@Test(dataProvider="projectdata" )
//	@Test(priority = 1 , dataProvider="getwfmTestData")
	public void verifycreateprojectTest(String projectname, String description, String search) {
//	public void verifycreateprojectTest() {
		projectpage.clickOnCreateprojectLink();
		projectpage.verifycreateprojectLink(projectname, description, search);
//		projectpage.verifycreateprojectLink("Admin123 Project", "Welcome to new Project" ,"Admin123 Project");
//		projectpage.verifycreateprojectLink("EMP1 Project", "Welcome to EMP Project", "EMP1 Project");
		boolean flag=projectpage.verifyAllprojectLable();
		Assert.assertTrue(flag);
	}

//	@Test (priority=2)
//	public void verifyAllProjectLableTest() {
//		boolean flag=projectpage.verifyAllprojectLable();
//		Assert.assertTrue(flag);
//	}
//	

	@AfterMethod

	public void tearDown() {
//		driver.quit();
	}

}
