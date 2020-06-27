package com.leveljump.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.leveljump.qa.base.TestBase;

public class LurnitureLauncherPage extends TestBase{
	
	public LurnitureLauncherPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),\"All Programs\")]")
	@CacheLookup
	WebElement clickAllProgramLink;

	@FindBy(xpath="//a[contains(text(),\"Programs I Own\")]")
	@CacheLookup
	WebElement clickProgramIOwnLink;

	@FindBy(xpath="//a[contains(text(),\"My Programs\")]")
	@CacheLookup
	WebElement clickMyProgramLink;
	
	@FindBy(xpath="//a[contains(text(),\"My Team's Programs\")]")
	@CacheLookup
	WebElement clickMyTeamProgramLink;
	
	@FindBy(xpath="//a[contains(text(),\"Program Metrics\")]")
	@CacheLookup
	WebElement clickProgramMetricLink;
	
	@FindBy(xpath="//a[contains(text(),\"User Performance Metrics\")]")
	@CacheLookup
	WebElement clickUserProgramMetricLink;
	
	@FindBy(xpath="//a[contains(text(),\"All Quizzes\")]")
	@CacheLookup
	WebElement clickAllQuizzesLink;
	
	@FindBy(xpath="//a[contains(text(),\"Quizzes I Own\")]")
	@CacheLookup
	WebElement clickQuizzesIOwnLink;
	
	@FindBy(xpath="//a[contains(text(),\"My Quizzes\")]")
	@CacheLookup
	WebElement clickMyQuizzesLink;
	
	@FindBy(xpath="//a[contains(text(),\"My Team's Quizzes\")]")
	@CacheLookup
	WebElement clickMyTeamQuizzesLink;
	
	public AllProgramsPage clickToAllProgramLink() {
		wait.until(ExpectedConditions.elementToBeClickable(clickAllProgramLink)).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(clickAllProgramLink)).click();
		return new AllProgramsPage();
	}
	
}
