package com.selenium.tests;

import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import com.utils.BaseTest;

public class SearchProduct extends BaseTest {

	String product = "sharper image wireless qi charging speaker dock";
	
	@Test
	public void searchTest() {
		HomePage homePage = new HomePage(driver);
		homePage.searchProduct(product);
		
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.verifyProduct(product);
	}
}
