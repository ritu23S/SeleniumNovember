package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {

	private WebDriver driver;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginInApp(String userName, String password) {
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("cartSignInPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[data-automation-id=\"at-sign-in-button\"]")).click();
	}
	
	public void checkOnGuest() {
		driver.findElement(By.xpath("(//*[@data-automation-id='at-continue-as-guest'])[2]")).click();
	}
	
}
