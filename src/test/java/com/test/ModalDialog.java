package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ModalDialog {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void windowHandle() {
		driver.navigate().to("https://demoqa.com/modal-dialogs");

		driver.findElement(By.id("showSmallModal")).click();
		
		String str = driver.findElement(By.xpath("//*[@class='modal-body']")).getText();
		System.out.println(str);
		
		driver.findElement(By.id("closeSmallModal")).click();
	}
}
