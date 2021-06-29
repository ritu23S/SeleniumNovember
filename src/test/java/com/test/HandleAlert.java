package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HandleAlert extends BaseTest {
	

	@Test
	public void alert() {

		driver.findElement(By.cssSelector("[id=\"alertButton\"]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.cssSelector("[id=\"timerAlertButton\"]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmButton")).click();
		alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.dismiss();

		String result = driver.findElement(By.id("confirmResult")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "You selected Cancel");

		driver.findElement(By.id("promtButton")).click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Test");
		alert.accept();
		result = driver.findElement(By.id("promptResult")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "You entered Test");

	}


}
