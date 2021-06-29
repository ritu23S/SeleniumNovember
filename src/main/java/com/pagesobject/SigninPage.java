package com.pagesobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage {

	private WebDriver driver;

	@FindBy(id="email")
	private WebElement emailInput; 
	
	@FindBy(id="cartSignInPassword")
	private WebElement passwordinput; 
	
	@FindBy(css="[data-automation-id=\"at-sign-in-button\"]")
	private WebElement button; 
	
	@FindBy(xpath="(//*[@data-automation-id='at-continue-as-guest'])[2]")
	private WebElement guestButton; 
	
	public SigninPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginInApp(String userName, String password) {
		emailInput.sendKeys(userName);
		passwordinput.sendKeys(password);
		button.click();
	}
	
	public void checkOnGuest() {
		guestButton.click();
	}
	
}
