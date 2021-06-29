package com.test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.utils.BaseTest;

public class ActionClass extends BaseTest {

		
	@Test
	public void mouseMoveOn() throws InterruptedException, IOException {
		
		driver.navigate().to(url + "/menu");				
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 120);		
		WebElement menuElement = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		wait.until(ExpectedConditions.elementToBeClickable(menuElement));
		//wait.until(ExpectedConditions.titleContains("Google"));
		
		WebElement subMenuElement = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		//wait.until(ExpectedConditions.alertIsPresent());
		
		WebElement subMenuElement2 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
		action.moveToElement(menuElement).moveToElement(subMenuElement).moveToElement(subMenuElement2)
			.click(subMenuElement2).build().perform();
	}

	@Test
	public void dragAndDrop() {
		driver.navigate().to(url + "/droppable");				
		Actions action = new Actions(driver);			
		WebElement sourceElement = driver.findElement(By.id("draggable"));	
		WebElement targetElement = driver.findElement(By.id("droppable"));			
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		
	}
	
	@Test
	public void dragAndDrop1() {
		driver.navigate().to(url + "/dragabble");
				
		Actions action = new Actions(driver);			
		WebElement sourceElement = driver.findElement(By.id("dragBox"));	
			
		action.dragAndDropBy(sourceElement, 200, 200).build().perform();
		
	}
	
	@Test
	public void radioButton() {
		driver.navigate().to(url + "/buttons");
		
		WebElement element = driver.findElement(By.xpath("//button[text()='Click Me']")); //.click();
		
		Actions action = new Actions(driver);
		action.click(element).build().perform();
		
		WebElement doubleClicButtin = driver.findElement(By.id("doubleClickBtn"));
		//action.click(doubleClicButtin).build().perform();
		
		action.doubleClick(doubleClicButtin).build().perform();
		
		WebElement rightClickButtin = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightClickButtin).build().perform();
	}
	
	
}
