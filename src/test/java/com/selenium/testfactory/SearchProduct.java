package com.selenium.testfactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pagesobject.HomePage;
import com.pagesobject.ProductDetailsPage;
import com.utils.BaseTest;

public class SearchProduct extends BaseTest {

	String product = "sharper image wireless qi charging speaker dock";
	
	@Test
	public void searchTest() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.searchProduct(product);
		
		ProductDetailsPage productDetailsPage =  PageFactory.initElements(driver, ProductDetailsPage.class);
		productDetailsPage.verifyProduct(product);
	}
}
