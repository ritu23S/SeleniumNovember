package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	//protected String url;
	String browser=System.getProperty("browser");
	protected String url=System.getProperty("url");

	@BeforeClass
	public void setup() throws IOException {
		url = Configuration.getConfig("Url");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);
	}
	@BeforeTest
	public void browser() {
		
	}

	@AfterMethod()
	public void captureScreenShot(ITestResult result) throws IOException {
		if (!result.isSuccess())
			takeScreenShot("Test1");
	}

	@AfterClass
	public void afterClass() throws IOException {
		driver.quit();
	}

	public void takeScreenShot(String fileName) throws IOException {
		TakesScreenshot takeScreenShotObject = (TakesScreenshot) driver;
		File screenshot = takeScreenShotObject.getScreenshotAs(OutputType.FILE);

		File screenshotLocation = new File(fileName + ".png");
		FileUtils.copyFile(screenshot, screenshotLocation);
	}

}
