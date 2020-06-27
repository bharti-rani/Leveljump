package com.leveljump.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leveljump.qa.base.TestBase;

public class LoginSalesforcePage extends TestBase {

	//Page Factory - OR:
	@FindBy(name = "username")
	//@CacheLookup
	WebElement userName;
	
	@FindBy(name = "pw")
	//@CacheLookup
	WebElement passWord;
	
	@FindBy(name = "Login")
	//@CacheLookup
	WebElement loginButton;
	
	//Initialization of page object
	public LoginSalesforcePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Action:
	public SalesforceHomePage loginsalesforce(String un, String pass) {
		userName.sendKeys(un);
		passWord.sendKeys(pass);
		loginButton.click();
		
		return new SalesforceHomePage();
	}
}
