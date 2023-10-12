package com.wfm.qa.wfmtestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.util.TestUtil;
import com.wfm.qa.wmpages.HomePage;
import com.wfm.qa.wmpages.SignInPage;

public class HomePageTest extends TestBase {
	SignInPage signinpage;
	HomePage homepage;
	TestUtil testutil;
 public HomePageTest() {
	 super();
 }
 
 @BeforeMethod
 public void setUp() {
	 initialization();
	 testutil=new TestUtil();
	 signinpage=new SignInPage();
	homepage= signinpage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
 }
 
 
// @Test
// public void verifyHomePageTitleTest() {
//	String hometitle= homepage.verifyHomePageTitle();
//	Assert.assertEquals(hometitle, "Dashboard","Home Page Title Not Matched");
// }
// 
// 
// @Test
// public void verifyCorrectNameTest() {
////	 testutil.switchToFrame();
//	 Assert.assertTrue(homepage.verifycorrectName());
// }
 
 @Test(priority=1)
 public void verifyprojectLinkTest() {
	 homepage.clickOnProjectLink();
 }
 
// @Test(priority=2)
// public void verifytaskmanagementLinkTest() {
//	 homepage.clickOnTaskManagementLink();
// }
// 
// @Test(priority=3)
// public void verifymemberLinkTest() {
//	 homepage.clickOnMemberLink();
// }
 
 
 
 
 
 
 
 @AfterMethod
 public void tearDown() {
	 driver.quit();
 }
 
 
 
}
