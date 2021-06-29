package com.testng;

import org.testng.annotations.DataProvider;

public class MyDataProvider {

	@DataProvider(name = "TestData")
	public Object[][] getData() {
		return new Object[][] {
			{ 1, 3, 4 }, 
			{ 2, 4, 6 }, 
			{ 4, 1, 5 }, 
			{ 1, 3, 3 }, 
			{ 2, 3, 5 }
		};
	}

}
