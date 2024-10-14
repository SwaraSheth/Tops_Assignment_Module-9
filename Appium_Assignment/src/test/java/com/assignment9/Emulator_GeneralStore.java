package com.assignment9;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/*
 * Write an Appium Program to connect with emulator wit ecommerce based application using 
	Generalstore.app to perform locators like name, dropdown etc. 
	
 * Write an Appium Program to connect with emulator wit ecommerce based application using 
	Generalstore.app to perform swipe demo to swipe the menu.
 */

public class Emulator_GeneralStore  {
	public AndroidDriver driver;
	@BeforeTest
	public void before() throws MalformedURLException, InterruptedException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Swara");
		options.setApp("D:\\Appium\\apk file\\General-Store.apk");

		 driver=new AndroidDriver
				(new URL("http://127.0.0.1:4723/"),options);
		 //implicit wait
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
	
	}
	
	public  void swipeAction(WebElement ele,String direction) throws InterruptedException { 
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			 
			    "direction", direction,
			    "percent", 0.15
			));	
	}
	@Test
	public void store() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Swara");
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" + ".scrollIntoView(text(\"India\"));"))
		.click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		
		for (int i = 1; i <5; i++) {
			WebElement ele1 =driver.findElement(By.xpath("//android.widget.LinearLayout["+i+"]"));
			Thread.sleep(2000);
			swipeAction(ele1, "up");
			Thread.sleep(2000);
		}
	}
	
	
	
	@AfterTest
	public void after() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();	
	}
}
