package com.selenium.testfactory;

import org.openqa.selenium.support.PageFactory;
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
		
		HomePage homePage =PageFactory.initElements(driver, HomePage.class);
		homePage.searchProduct(product);
				
		ProductDetailsPage productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);
		productDetailsPage.verifyProduct(product);
		productDetailsPage.clickAddCart();		
		productDetailsPage.clickPanelCheckOutButton(product);
				
		CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
		cartPage.verifyProduct(product);
		cartPage.clickCheckOut();
		
		SigninPage signPage = PageFactory.initElements(driver, SigninPage.class);
		signPage.checkOnGuest();
		
		ShippingPage shippingPage = PageFactory.initElements(driver, ShippingPage.class);
		shippingPage.fillGuestDetails("FName", "Lname", "Address1", "90010");
	}
}
