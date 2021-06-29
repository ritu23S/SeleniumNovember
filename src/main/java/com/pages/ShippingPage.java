package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {
	
	private WebDriver driver;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void fillGuestDetails(String fname, String lname, String address, String zip) {
		driver.findElement(By.id("firstName")).sendKeys(lname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("lineOne")).sendKeys(address);
		driver.findElement(By.id("zip")).sendKeys(zip);
		
	}
	
}
