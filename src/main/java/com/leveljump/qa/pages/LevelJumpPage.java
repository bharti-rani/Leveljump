package com.leveljump.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import com.leveljump.qa.base.TestBase;

public class LevelJumpPage extends TestBase {
	
	public LevelJumpPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	@CacheLookup
	WebElement NewVideoUploadButton;
	
	@FindBy(id="videoName")
	@CacheLookup
	WebElement VideoName;
	
	@FindBy(id="VideoDescription")      
	@CacheLookup
	WebElement VideoDescription;
	
	@FindBy(id="videoType")
	@CacheLookup
	WebElement videoType;
	
	@FindBy(id="tagsList")
	@CacheLookup
	WebElement searchvideotag;
	
	@FindBy(xpath="//div[@id=\"customLookup\"]//li")
	@CacheLookup
	WebElement selectaTag;
	
	@FindBy(id="VideoFileForUpload")
	@CacheLookup
	WebElement uploadVideoContainer;
	
	@FindBy(id="btnUploadVideo")
	@CacheLookup
	WebElement uploadvideoButton;
	
	
	@FindBy(xpath="//div[@id=\"VideoUploadSuccess\"]//div//div[2]//h2")
	@CacheLookup
	WebElement videoUploadSuccessMsg;
	
	@FindBy(id="UploadCompleteButton")
	@CacheLookup
	WebElement UploadCompleteButton;
	
	@FindBy(xpath="//div[@selectedoption=\"selectedOption\"]")
    @CacheLookup
	WebElement videoFilterSelectedOption;
	
	@FindBy(id="record-video-btn")
	@CacheLookup
	WebElement recordVideoBtn;
	
	@FindBy(xpath="//div[@id=\"selectVideoWebcamRecording\"]//a")
	@CacheLookup
	WebElement selectVideoWebcamRecording;
	
	@FindBy(xpath="//div[@id=\"selectRecordingType\"]//a[@onclick=\"VideoUpload.selectRecordDeck()\"]")
	@CacheLookup
	WebElement selectPresentationVideoRecording;
	
	@FindBy(id="stop-record-btn")
	@CacheLookup
	WebElement startRecordVideoBtn;
	
	@FindBy(id="stop-btn")
	@CacheLookup
	WebElement stopRecordVideoBtn;
	
	@FindBy(id="UseVideoFromCamera")
	@CacheLookup
	WebElement UseVideoFromCamera;
	
	
	@FindBy(id="file-upload-deck")
	@CacheLookup
	WebElement uploadFile;
	
	@FindBy(xpath="//div[@id=\"selectRecordingType\"]//a[@onclick=\"VideoUpload.selectRecordDrawing()\"]")
	@CacheLookup
	WebElement selectWhiteBoardVideoRecording;
	
	@FindBy(xpath="//div[@id=\"selectRecordingType\"]//a[@onclick=\"VideoUpload.selectRecordScreen()\"]")
	@CacheLookup
	WebElement selectScreenVideoRecording;
	

	@FindBy(id="draw-canvas")
	@CacheLookup
	WebElement whiteBoardDrawCanvas;
	
	
	public void afterVideoUpload() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		uploadvideoButton.click();
		String SuccessMessage = wait.until(ExpectedConditions.visibilityOf(videoUploadSuccessMsg)).getText();
		System.out.println(SuccessMessage);
		Assert.assertTrue(SuccessMessage.equalsIgnoreCase("Your video has been uploaded successfully."));
		UploadCompleteButton.click();
		//Assert.assertTrue(videoFilterSelectedOption.getText().equalsIgnoreCase("My Published"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(videoFilterSelectedOption)).getText().equalsIgnoreCase("My Published"));
	}
	
	
	
	public void uploadNewVideo(String vn, String dsc, String vdtype, String tag) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	NewVideoUploadButton.click();
		VideoName.sendKeys(vn);
		VideoDescription.sendKeys(dsc);
		Select videotype = new Select(videoType);
		videotype.selectByVisibleText(vdtype);
		searchvideotag.sendKeys(tag);
		selectaTag.click();
		uploadVideoContainer.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\File\\00001.mp4");
		afterVideoUpload();
	}

	
	
	public void uploadRecordNewVideo(String vn, String dsc, String vdtype, String tag) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		NewVideoUploadButton.click();
		VideoName.sendKeys(vn);
		VideoDescription.sendKeys(dsc);
		Select videotype = new Select(videoType);
		videotype.selectByVisibleText(vdtype);
		searchvideotag.sendKeys(tag);
		selectaTag.click();
		recordVideoBtn.click();
		selectVideoWebcamRecording.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startRecordVideoBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopRecordVideoBtn.click();
		Assert.assertTrue(UseVideoFromCamera.isDisplayed());
		UseVideoFromCamera.click();
		afterVideoUpload();
	}
	
	
	public void uploadPresentationVideo(String vn, String dsc, String vdtype, String tag) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    NewVideoUploadButton.click();
		VideoName.sendKeys(vn);
		VideoDescription.sendKeys(dsc);
		Select videotype = new Select(videoType);
		videotype.selectByVisibleText(vdtype);
		searchvideotag.sendKeys(tag);
		selectaTag.click();
		recordVideoBtn.click();
		selectPresentationVideoRecording.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        uploadFile.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\File\\original.pdf");
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startRecordVideoBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopRecordVideoBtn.click();
		Assert.assertTrue(UseVideoFromCamera.isDisplayed());
		UseVideoFromCamera.click();
		afterVideoUpload();
	}
	
	
	
	public void uploadNewWhiteBoardVideo(String vn, String dsc, String vdtype, String tag) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    NewVideoUploadButton.click();
		VideoName.sendKeys(vn);
		VideoDescription.sendKeys(dsc);
		Select videotype = new Select(videoType);
		videotype.selectByVisibleText(vdtype);
		searchvideotag.sendKeys(tag);
		selectaTag.click();
		recordVideoBtn.click();
		selectWhiteBoardVideoRecording.click();
		startRecordVideoBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    Actions builder = new Actions(driver);
        builder.moveToElement(whiteBoardDrawCanvas).perform();
        builder.clickAndHold(whiteBoardDrawCanvas).perform();
        builder.moveByOffset(100, 200).perform();
        builder.moveToElement(whiteBoardDrawCanvas).perform();
        builder.clickAndHold(whiteBoardDrawCanvas).perform();
        builder.moveByOffset(200, 100).perform();
        builder.moveToElement(whiteBoardDrawCanvas).perform();
        
        
        
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    stopRecordVideoBtn.click();
		Assert.assertTrue(UseVideoFromCamera.isDisplayed());
		UseVideoFromCamera.click();
		afterVideoUpload();
	}
	
	
	public void uploadNewScreenVideo(String vn, String dsc, String vdtype, String tag) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    NewVideoUploadButton.click();
		VideoName.sendKeys(vn);
		VideoDescription.sendKeys(dsc);
		Select videotype = new Select(videoType);
		videotype.selectByVisibleText(vdtype);
		searchvideotag.sendKeys(tag);
		selectaTag.click();
		recordVideoBtn.click();
		selectScreenVideoRecording.click();	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		startRecordVideoBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		stopRecordVideoBtn.click();
		Assert.assertTrue(UseVideoFromCamera.isDisplayed());
		UseVideoFromCamera.click();
		afterVideoUpload();
		
		
		
		
		
	}
	
}
