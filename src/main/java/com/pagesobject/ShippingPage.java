package com.pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage {
	
	private WebDriver driver;

	@FindBy(id="firstName")
	private WebElement firstNameInput; 	

	@FindBy(id="lastName")
	private WebElement lastNameInput; 	

	@FindBy(id="lineOne")
	private WebElement addressInput; 	

	@FindBy(id="zip")
	private WebElement zipinput; 
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}
		
	public void fillGuestDetails(String fname, String lname, String address, String zip) {
		firstNameInput.sendKeys(lname);
		lastNameInput.sendKeys(lname);
		addressInput.sendKeys(address);
		zipinput.sendKeys(zip);
	}
	
}
