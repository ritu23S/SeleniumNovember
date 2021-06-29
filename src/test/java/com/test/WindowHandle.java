package com.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	
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
		driver.navigate().to("https://demoqa.com/browser-windows");
	
		driver.findElement(By.id("tabButton")).click();
		String parentWinId = driver.getWindowHandle();
		
		Set<String> windowsid = driver.getWindowHandles();
		Iterator<String> it = windowsid.iterator();
		
		while(it.hasNext()) {
			String wind = it.next();
			driver.switchTo().window(wind);			
		}	
	
		String str = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(str);
		driver.close();
		
		driver.switchTo().window(parentWinId);
		driver.findElement(By.id("windowButton")).click();
	}
	
	
}
