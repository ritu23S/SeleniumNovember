package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestNg {

	private WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional String browser) {
		
		if(browser !=null && browser.equals("ch")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser !=null & browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
	}

	@Test
	public void testMethod() throws InterruptedException {
		WebElement createButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		createButton.click();
		Thread.sleep(3000);
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@name=\"firstname1\"]"));
		firstNameInput.sendKeys("Testing");
		WebElement lastNameInput = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
		lastNameInput.sendKeys("LastName");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
