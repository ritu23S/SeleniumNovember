package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadDownload {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://demoqa.com/alerts");
	}

	@Test
	public void downloadTest() {
		driver.navigate().to("https://demoqa.com/upload-download");		
		driver.findElement(By.id("downloadButton")).click();
	}
	

	@Test
	public void uploadTest() {
		driver.navigate().to("https://demoqa.com/upload-download");		
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Admin\\Desktop\\Wedriverio.txt");
	}
}
