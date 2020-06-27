package com.leveljump.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.leveljump.qa.base.TestBase;
import com.leveljump.qa.pages.AllProgramsPage;
import com.leveljump.qa.pages.LoginSalesforcePage;
import com.leveljump.qa.pages.LurnitureLauncherPage;
import com.leveljump.qa.pages.ProgramBuilderPage;
import com.leveljump.qa.pages.SalesforceHomePage;
import com.leveljump.qa.pages.TmLearningPage;
import com.leveljump.qa.util.TestUtil;


public class ProgramBuilderTest extends TestBase {
	
	LoginSalesforcePage loginpage;
	SalesforceHomePage homepage;
	TmLearningPage LeveljumpHome;
	LurnitureLauncherPage LurnitureLauncher;
	AllProgramsPage AllProgram;
	ProgramBuilderPage ProgramBuilder;
	String sheetName = "Sheet2";
	
	
	public ProgramBuilderTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginSalesforcePage();
		homepage=loginpage.loginsalesforce(prop.getProperty("username"), prop.getProperty("password"));
		LeveljumpHome=	homepage.clickOnLeveljumpTab();
		LurnitureLauncher =LeveljumpHome.clickToProgramTab();
		AllProgram =LurnitureLauncher.clickToAllProgramLink();
		ProgramBuilder=AllProgram.clickToNewCreateProgramButton();
	}
	
	@DataProvider
	public Object[][] getVideoUploadTestData() {
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1, dataProvider="getVideoUploadTestData")
	public void addViewActivity(String ProgramName, String ProgramDesc, String ActivityDesc, String ActivityName) {
		ProgramBuilder.addViewActivityInProgram(ProgramName, ProgramDesc,  ActivityDesc, ActivityName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
