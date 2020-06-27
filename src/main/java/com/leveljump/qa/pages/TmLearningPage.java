package com.leveljump.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leveljump.qa.base.TestBase;

public class TmLearningPage extends TestBase{
	
	
	public TmLearningPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Home')]")
	//@CacheLookup
	WebElement homeTab;
	
	@FindBy(xpath = "//div[contains(text(),'Favorites')]")
	//@CacheLookup
	WebElement favoritesTab;
	
	@FindBy(xpath = "//div[contains(text(),'Programs')]")
	//@CacheLookup
	WebElement programsTab;
	
	@FindBy(xpath = "//div[contains(text(),'Library')]")
	//@CacheLookup
	WebElement libraryTab;
	
	@FindBy(xpath = "//div[contains(text(),'Playlists')]")
	//@CacheLookup
	WebElement playlistsTab;
	
	
	@FindBy(xpath = "//li[@id=\"pitchingroomSideNav\"]//a")
	//@CacheLookup
	WebElement pitchingRoomTab;
	
	
	
	public LevelJumpPage clickToLibraryTab() {
		libraryTab.isDisplayed();
		libraryTab.click();
		return new LevelJumpPage();
	}
	
	
	public LurnitureLauncherPage clickToProgramTab() {
		programsTab.isDisplayed();
		programsTab.click();
		return new LurnitureLauncherPage();
	}
	
	public RoomsPage clickToPichingRoomTab() {
		pitchingRoomTab.isDisplayed();
		pitchingRoomTab.click();
		return new RoomsPage();
	}

	
	
	
}
