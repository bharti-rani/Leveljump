package com.leveljump.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leveljump.qa.base.TestBase;
import com.leveljump.qa.pages.LevelJumpPage;
import com.leveljump.qa.pages.LoginSalesforcePage;
import com.leveljump.qa.pages.SalesforceHomePage;
import com.leveljump.qa.pages.TmLearningPage;

public class TmLearningTest extends TestBase{
	LoginSalesforcePage loginpage;
	SalesforceHomePage homepage;
	TmLearningPage LeveljumpHome;
	LevelJumpPage Library;
	
	public TmLearningTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginSalesforcePage();
		homepage=loginpage.loginsalesforce(prop.getProperty("username"), prop.getProperty("password"));
		LeveljumpHome=	homepage.clickOnLeveljumpTab();
		
	}
	
	@Test(priority = 1)
	public void clickToLibraryTab(){
		Library = LeveljumpHome.clickToLibraryTab();
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
