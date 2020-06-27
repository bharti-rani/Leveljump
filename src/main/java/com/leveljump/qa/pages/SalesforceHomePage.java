package com.leveljump.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leveljump.qa.base.TestBase;

public class SalesforceHomePage extends TestBase{

	
	@FindBy(xpath="//a[contains(text(),'LevelJump')]")
	//@CacheLookup
	WebElement leveljumpTab;
	
	@FindBy(xpath="//a[contains(text(), 'LevelJump Admin')]")
	//@CacheLookup
	WebElement leveljumpAdminTab;
	
	public SalesforceHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public TmLearningPage clickOnLeveljumpTab() {
		leveljumpTab.click();
		return new TmLearningPage();
	}
	
	public LurnitureAdminHomePage clickOnLeveljumpAdminTab() {
		leveljumpAdminTab.click();
		return new LurnitureAdminHomePage();
	}
	
	
}
