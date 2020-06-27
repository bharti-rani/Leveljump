package com.leveljump.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.leveljump.qa.base.TestBase;

public class AllProgramsPage extends TestBase{
	
	public AllProgramsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),\"New\")]")
	@CacheLookup
	WebElement NewProgramButton;
	
	
	public ProgramBuilderPage clickToNewCreateProgramButton() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NewProgramButton.isDisplayed();
		NewProgramButton.click();
		return new ProgramBuilderPage();
	}
}
