package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class ProductDetailsPage {

	private WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyProduct(String product) {
		String productName = driver.findElement(By.cssSelector("[id=\"productTitle-false\"]")).getText();
		Assert.assertEquals(product.toLowerCase(), productName.toLowerCase());
	}

	public void clickAddCart() {
		driver.findElement(By.cssSelector("[data-automation-id=\"addToCart\"]")).click();
	}
	
	public void clickPanelCheckOutButton(String product) {
		String productName1 = driver.findElement(By.cssSelector("[data-automation-id=\"ocProductTitle\"] span")).getText();
		Assert.assertEquals(product.toLowerCase(), productName1.toLowerCase());
		driver.findElement(By.cssSelector("[data-automation-id=\"at-panel-checkout-button\"]")).click();
	}
}
