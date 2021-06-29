package com.selenium.tests;

import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import com.pages.ShippingPage;
import com.pages.SigninPage;
import com.utils.BaseTest;

public class CheckOutWithGuest extends BaseTest {

	String product = "sharper image wireless qi charging speaker dock";
	
	@Test
	public void checkOutWithGuestTest() {
		
		HomePage homePage = new HomePage(driver);
		homePage.searchProduct(product);
				
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.verifyProduct(product);
		productDetailsPage.clickAddCart();		
		productDetailsPage.clickPanelCheckOutButton(product);
				
		CartPage cartPage = new CartPage(driver);
		cartPage.verifyProduct(product);
		cartPage.clickCheckOut();
		
		SigninPage signPage = new SigninPage(driver);
		signPage.checkOnGuest();
		
		ShippingPage shippingPage = new ShippingPage(driver);
		shippingPage.fillGuestDetails("FName", "Lname", "Address1", "90010");
	}
}
