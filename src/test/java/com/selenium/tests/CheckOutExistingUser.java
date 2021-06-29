package com.selenium.tests;

import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import com.pages.SigninPage;
import com.utils.BaseTest;

public class CheckOutExistingUser extends BaseTest {

	String product = "sharper image wireless qi charging speaker dock";
	
	@Test
	public void selenium() {
		HomePage homePage = new HomePage(driver);
		homePage.searchProduct(product);
				
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.verifyProduct(product);
		productDetailsPage.clickAddCart();		
		productDetailsPage.clickPanelCheckOutButton(product);
				
		CartPage cartPage = new CartPage(driver);
		cartPage.verifyProduct(product);
		cartPage.clickCheckOut();
		
		// enter user details for login
		SigninPage signinPage = new SigninPage(driver);
		signinPage.loginInApp("UserName1", "Password");	
		
	}
}
