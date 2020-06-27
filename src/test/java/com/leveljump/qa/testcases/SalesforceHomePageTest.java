package com.leveljump.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leveljump.qa.base.TestBase;
import com.leveljump.qa.pages.LoginSalesforcePage;
import com.leveljump.qa.pages.SalesforceHomePage;
import com.leveljump.qa.pages.TmLearningPage;

public class SalesforceHomePageTest extends TestBase{
	
	LoginSalesforcePage loginpage;
	SalesforceHomePage homepage;
	TmLearningPage LeveljumpHome;
	
	
	public SalesforceHomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		LeveljumpHome = new TmLearningPage();
		loginpage = new LoginSalesforcePage();
		homepage=loginpage.loginsalesforce(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void openLeveljump() {
		LeveljumpHome =	homepage.clickOnLeveljumpTab();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
