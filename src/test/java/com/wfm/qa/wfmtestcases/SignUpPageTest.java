package com.wfm.qa.wfmtestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfm.qa.base.TestBase;
import com.wfm.qa.util.TestUtil;
import com.wfm.qa.wmpages.SignUpPage;

public class SignUpPageTest extends TestBase {
	SignUpPage signupage;
	TestUtil testutil;
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		 signupage=new SignUpPage();
	}
	
	
	@Test
	public void validateSignUpPageTest() {
		signupage.verifysignupPage("xedogo8568@locawin.com", "AkileshGG", "Akilesh", "GG", "@Globussoft2023", "@Globussoft2023" , "BlueStar Pvt Ltd..","9713024502", "100013","Bengalore");
		
//		boolean flag=signupage.validatecreatesuccessfullyaccountLable();
//		Assert.assertTrue(flag);
	String tesxt=signupage.validatecreatesuccessfullyaccountLable();
	System.out.println(tesxt);
	
	Assert.assertEquals(tesxt, "Admin stored successfully.");
		
}
}
