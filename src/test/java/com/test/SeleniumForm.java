package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class SeleniumForm {
	
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@Test
	public void radioButton() {
		driver.navigate().to("https://demoqa.com/radio-button");
		boolean status = driver.findElement(By.id("yesRadio")).isSelected();
		System.out.println(status);
		driver.findElement(By.cssSelector("[for=\"yesRadio\"]")).click();
		status = driver.findElement(By.id("yesRadio")).isSelected();
		System.out.println(status);
		
		driver.findElement(By.xpath("//*[@for=\"impressiveRadio\"]")).click();		
	}
	
	
	@Test
	public void checkBox() {
		driver.navigate().to("https://demoqa.com/checkbox");
		//#tree-node > ol > li > span > label > span.rct-checkbox
		boolean status = driver.findElement(By.id("tree-node-home")).isSelected();
		System.out.println(status);
		driver.findElement(By.cssSelector("span[class=\"rct-checkbox\"]")).click();
		status = driver.findElement(By.id("tree-node-home")).isSelected();
		System.out.println(status);
	}
		
	@Test
	public void testMethod() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/text-box");
		WebElement fullNameInputBox = driver.findElement(By.id("userName"));
		fullNameInputBox.clear();
		fullNameInputBox.sendKeys("QAGuru");

		driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");	
				
		WebElement currentAddressInput = driver.findElement(By.xpath("//textarea[@id=\"currentAddress\"]"));
		currentAddressInput.sendKeys("A 10 Sector 20");
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
		submitButton.click();
		
		WebElement nameField = driver.findElement(By.xpath("//p[@id='name']"));
		String actuaName = nameField.getText();
		System.out.println(actuaName);
		
		String emailActual = driver.findElement(By.xpath("//p[@id='email']")).getText();
		System.out.println(emailActual);
		
		String addressActual  = driver.findElement(By.id("currentAddress")).getText();
		System.out.println(addressActual);
		Assert.assertEquals(actuaName, "Name:QAGuru");
		Assert.assertEquals(emailActual, "Email:test@gmail.com");
		Assert.assertEquals(addressActual, "Current Address :A 10 Sector 20");
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
