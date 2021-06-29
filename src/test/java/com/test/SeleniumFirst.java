package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFirst {
	
	static WebDriver driver;
	
	public static void main(String... args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		//FirefoxDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		
		WebElement createButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		createButton.click();
		Thread.sleep(3000);
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@name=\"firstname1\"]"));
		firstNameInput.sendKeys("Testing");
		WebElement lastNameInput = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
		lastNameInput.sendKeys("LastName");
		
		driver.quit();	
	}

}
