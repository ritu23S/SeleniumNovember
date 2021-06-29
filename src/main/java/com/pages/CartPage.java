
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyProduct(String product) {
		String productName2 = driver.findElement(By.cssSelector("[data-automation-id=\"at-product-title-link\"] span"))
				.getText();
		Assert.assertEquals(product.toLowerCase(), productName2.toLowerCase());
	}

	public void clickCheckOut() {
		driver.findElement(By.id("checkoutButton")).click();
	}
}
