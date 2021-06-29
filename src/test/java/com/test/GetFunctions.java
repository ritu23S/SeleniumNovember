package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utils.BaseTest;

public class GetFunctions extends BaseTest{

	@Test
	public void getFunctions() {
		driver.navigate().to(url+"/modal-dialogs");

		String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		
		driver.findElement(By.id("showSmallModal")).click();
		
		WebElement element = driver.findElement(By.xpath("//*[@class='modal-body']"));
		
		String str = element.getText();
		System.out.println(str);
		
		String attribute = element.getAttribute("class");
		System.out.println(attribute);
		
		String cssValue = element.getCssValue("font-family");
		System.out.println(cssValue);
		
		driver.findElement(By.id("closeSmallModal")).click();
	}
}
