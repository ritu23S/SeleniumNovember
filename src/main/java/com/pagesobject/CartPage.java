package com.pagesobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class CartPage {

	private WebDriver driver;

	@FindBy(css= "[data-automation-id=\"at-product-title-link\"] span")
	private WebElement productTitle;
	
	@FindBy(css = "checkoutButton")
	private WebElement checkButton;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyProduct(String product) {
		String productName2 = productTitle.getText();
		Assert.assertEquals(product.toLowerCase(), productName2.toLowerCase());
	}

	public void clickCheckOut() {
		checkButton.click();
	}
}
