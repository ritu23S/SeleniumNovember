package com.pagesobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(id= "searchInputId")
	private WebElement searchInput;
	
	@FindBy(css="[data-automation-id='searchIconBlock']")
	private WebElement searchIconBlock;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String product) {		
		searchInput.clear();
		searchInput.sendKeys(product);		
		searchIconBlock.click();
	}

}
