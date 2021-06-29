package com.testng;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class DataProviderScript {

	@Test(dataProvider = "TestData", dataProviderClass = MyDataProvider.class)
	public void testNgTest(int a, int b, int c) {		
		Assert.assertEquals(a+b, c);
	}
	
}
