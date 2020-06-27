package com.leveljump.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.leveljump.qa.base.TestBase;
import com.leveljump.qa.pages.LevelJumpPage;
import com.leveljump.qa.pages.LoginSalesforcePage;
import com.leveljump.qa.pages.SalesforceHomePage;
import com.leveljump.qa.pages.TmLearningPage;

import com.leveljump.qa.util.TestUtil;


public class LevelJumpTest extends TestBase{
	LoginSalesforcePage loginpage;
	SalesforceHomePage homepage;
	TmLearningPage LeveljumpHome;
	LevelJumpPage Library;
    String sheetName = "Sheet1";
    

	public LevelJumpTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginSalesforcePage();
		homepage=loginpage.loginsalesforce(prop.getProperty("username"), prop.getProperty("password"));
		LeveljumpHome=	homepage.clickOnLeveljumpTab();
		Library=LeveljumpHome.clickToLibraryTab();
	}
	
	@DataProvider
	public Object[][] getVideoUploadTestData() {
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1, dataProvider="getVideoUploadTestData")
	public void uploadvideo(String VideoName, String VideoDescription, String videoType, String searchvideotag) {
		Library.uploadNewVideo(VideoName, VideoDescription, videoType, searchvideotag);
	}
	
	
	@Test(priority=2, dataProvider="getVideoUploadTestData")
	public void uploadRecordVideo(String VideoName, String VideoDescription, String videoType, String searchvideotag) {
		Library.uploadRecordNewVideo(VideoName, VideoDescription, videoType, searchvideotag);
	}
	
	@Test(priority=3, dataProvider="getVideoUploadTestData")
	public void uploadPresentationVideo(String VideoName, String VideoDescription, String videoType, String searchvideotag) {
		Library.uploadPresentationVideo(VideoName, VideoDescription, videoType, searchvideotag);
	}
	
	@Test(priority=4, dataProvider="getVideoUploadTestData")
	public void uploadWhiteBoardVideo(String VideoName, String VideoDescription, String videoType, String searchvideotag) {
		Library.uploadNewWhiteBoardVideo(VideoName, VideoDescription, videoType, searchvideotag);
	}

	@Test(priority=5, dataProvider="getVideoUploadTestData")
    public void uploadScreenRecordVideo(String VideoName, String VideoDescription, String videoType, String searchvideotag) {
    	Library.uploadNewScreenVideo(VideoName, VideoDescription, videoType, searchvideotag);
    }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
