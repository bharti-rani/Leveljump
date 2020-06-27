package com.leveljump.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leveljump.qa.base.TestBase;

public class RoomsPage extends TestBase{
	
	public RoomsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	@CacheLookup
	WebElement NewRoomVideoUploadButton;
	
	
	@FindBy(id="inputRoomName")
	@CacheLookup
	WebElement roomName;
	
	@FindBy(id="roomTypePicklist")
	@CacheLookup
	WebElement roomType;
	
	@FindBy(id="submitNotificationRecipientsPicklist")
	@CacheLookup
	WebElement submitNotificationRecipientsPicklist;
	
	
	@FindBy(id="inputRoomDescription")
	@CacheLookup
	WebElement inputRoomDescription;
	
	@FindBy(id="saveRoomButton")
	@CacheLookup
	WebElement saveRoomButton;
	
	@FindBy(xpath="//li[@tab-target=\"roomMembers\"]//a[contains(text(),\"Room Members\")]")
	@CacheLookup
	WebElement roomMembersTab;
	
	@FindBy(xpath="//li[@tab-target=\"roomDetails\"]//a[contains(text(),\"Details\")]")
	@CacheLookup
	WebElement roomDetailTab;
	
	@FindBy(xpath="//li[@tab-target=\"scorecardSetting\"]//a[contains(text(),\"Scorecard Settings\")]")
	@CacheLookup
	WebElement scorecardSettingTab;
	
	@FindBy(id="//li[@tab-target=\"roomInstructionTab\"]//a[contains(text(),\"Instructions\")]")
	@CacheLookup
	WebElement roomInstructionTab;
	

	
	
	
	
	
	
	
}
