package com.pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class ProductDetailsPage {

	private WebDriver driver;

	@FindBy(css= "[id=\"productTitle-false\"]")
	private WebElement productTitle;
	
	@FindBy(css= "[data-automation-id=\"addToCart\"]")
	private WebElement addToCartButton;
	
	@FindBy(css = "[data-automation-id=\"ocProductTitle\"] span")
	private WebElement ocProductTitle;
	
	@FindBy(css="[data-automation-id=\"at-panel-checkout-button\"]")
	private WebElement checkoutButton; 
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyProduct(String product) {
		String productName = productTitle.getText();
		Assert.assertEquals(product.toLowerCase(), productName.toLowerCase());
	}

	public void clickAddCart() {
		addToCartButton.click();
	}
	
	public void clickPanelCheckOutButton(String product) {
		String productName1 = ocProductTitle.getText();
		Assert.assertEquals(product.toLowerCase(), productName1.toLowerCase());
		checkoutButton.click();
	}
}
