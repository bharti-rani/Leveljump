package com.leveljump.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leveljump.qa.base.TestBase;
import com.leveljump.qa.pages.LoginSalesforcePage;
import com.leveljump.qa.pages.SalesforceHomePage;

public class LoginSaleforceTest extends TestBase{
	
	LoginSalesforcePage loginpage;
	SalesforceHomePage homepage;
	
	public LoginSaleforceTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginSalesforcePage();
	}

	@Test(priority=1)
	public void loginTest() {
		homepage=loginpage.loginsalesforce(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
