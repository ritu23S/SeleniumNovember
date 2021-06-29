package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utils.BaseTest;

public class Iframe extends BaseTest {
	
	@Test
	public void nestedframeTest() {
		driver.navigate().to(url + "/nestedframes");
		
		driver.switchTo().frame("frame1");
		String str = driver.findElement(By.xpath("//body")).getText();
		System.out.println(str);
	
		driver.switchTo().frame(0);
		String str2 = driver.findElement(By.xpath("//body/p")).getText();
		System.out.println(str2);
		
		driver.switchTo().parentFrame();
		String str11 = driver.findElement(By.xpath("//body")).getText();
		System.out.println(str11);
		
		driver.switchTo().defaultContent();
		String str1 = driver.findElement(By.cssSelector("[id=\"framesWrapper\"] div")).getText();
		System.out.println(str1);		
	}
	
	@Test
	public void frameTest() {
		driver.navigate().to(url+"/frames");
		WebElement frameElement = driver.findElement(By.xpath("//*[@id=\"frame1\"]"));
		driver.switchTo().frame(frameElement);
		//driver.switchTo().frame("frame1");
		//driver.switchTo().frame(0);
		String str = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(str);
		
		driver.switchTo().defaultContent();
		String str1 = driver.findElement(By.cssSelector("[id=\"framesWrapper\"] div")).getText();
		System.out.println(str1);
		
	}
	
}
