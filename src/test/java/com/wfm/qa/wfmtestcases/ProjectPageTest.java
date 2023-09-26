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

//	@Test
//	public void verifyprojectpagelableTest() {
//		Assert.assertEquals(projectpage.verifyprojectLable(), "All Projects");
//	}
//	
//	@DataProvider
//	public Object [][] getwfmTestData() throws InvalidFormatException {
//		 Object data[][]=	testutil.getTestData(sheertName);
//		 return data;
//	}

	@Test(priority = 1 )
//	@Test(priority = 1 , dataProvider="getwfmTestData")
//	public void verifycreateprojectTest(String projectname, String description)
	public void verifycreateprojectTest() {
		projectpage.clickOnCreateprojectLink();
		projectpage.verifycreateprojectLink("Mission", "Welcome to Mission Project");
//		projectpage.verifycreateprojectLink(projectname, description);
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
