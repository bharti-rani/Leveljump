package com.leveljump.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.leveljump.qa.base.TestBase;

public class ProgramBuilderPage extends TestBase{
	
	public ProgramBuilderPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="programName")
	@CacheLookup
	WebElement programName;
	
	@FindBy(id="programDescription")
	@CacheLookup
	WebElement programDescription;

	@FindBy(id="input-3")
	@CacheLookup
	WebElement programTag;
	
	@FindBy(xpath="//input[@id=\"chkSkipWeekendSetting\"]/following-sibling::span//span")
	@CacheLookup
	WebElement skipWeekendToggleButton;
	
	@FindBy(xpath="//input[@id=\"chkNotificationSetting\"]/following-sibling::span//span")
	@CacheLookup
	WebElement notificationToggleButton;
	
	@FindBy(xpath="//input[@id=\"chkAutoSaveSetting\"]/following-sibling::span//span")
	@CacheLookup
	WebElement autoSaveToggleButton;
	
	@FindBy(id="saveButton")
	@CacheLookup
	WebElement programSaveButton;
	
	@FindBy(id="saveAndPublishButton")
	@CacheLookup
	WebElement saveAndPublishButton;
	
	@FindBy(id="exitButton")
	@CacheLookup
	WebElement cancelButton;
	
	@FindBy(id="programEventsButton")
	@CacheLookup
	WebElement programEventsButton;
	
	@FindBy(xpath="//button[@title=\"click to add a section\"]")
	@CacheLookup
	WebElement addSectionButton;
	
	@FindBy(xpath="//li[@data-activity=\"View\"]//div[@start-icon=\"1\"]")
	@CacheLookup
	WebElement viewExerciseIcon;
	
	
	@FindBy(id="headerAddEditActivity")
	@CacheLookup
	WebElement checkActivityPopTitle;
	
	@FindBy(id="ActivityDescription")
	@CacheLookup
	WebElement ActivityDescription;
	
	@FindBy(id="ActivityName")
	@CacheLookup
	WebElement ActivityName;
	

	@FindBy(xpath="//ul[@class=\"slds-lookup__list\"]//li[2]")
	@CacheLookup
	WebElement selectVideo;
	

	@FindBy(xpath="//button[contains(text(),\"Continue\")]")
	@CacheLookup
	WebElement continueButton;
	
	@FindBy(id="NoOfDays")
	@CacheLookup
	WebElement days;
	
	@FindBy(xpath="//div[@data-contenttype=\"Video\"]")
	@CacheLookup
	WebElement viewActivityDispalyed;
	
	@FindBy(xpath="//div[@id=\"programSaveToast\"]//span[2]")
	@CacheLookup
	WebElement programSaveToast;
	
	
	
	public void addViewActivityInProgram(String pName, String pDsc, String aDsc, String vName ) {
		programName.sendKeys(pName);
		programDescription.sendKeys(pDsc);
		viewExerciseIcon.click();
		Assert.assertTrue(checkActivityPopTitle.getText().equalsIgnoreCase("Add View"));
		String daysno =days.getAttribute("value");
		int ActivityDays=Integer.parseInt(daysno);  
	    Assert.assertEquals(ActivityDays, 1);
		ActivityDescription.sendKeys(aDsc);
		ActivityName.sendKeys(vName);
		selectVideo.click();
		continueButton.click();
		Assert.assertTrue(viewActivityDispalyed.isDisplayed());
		programSaveButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(programSaveToast.getText(),"Program successfully saved.");
		
	}
}
