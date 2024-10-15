package com.assignment9;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

/*
 * Write an Appium Program to connect with realdevice using APIDemo.app to perform longpress to open to 
	side menu. 
 */

public class RealDevice_LongPress extends RealDevice_APIDemo {
	@Test
	public void press() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views"))
		.click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(3000);
		
//		//class_Value[@text='text_value']
		WebElement e1= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(e1);
		Thread.sleep(2000);
		
		
		String msg=driver.findElement(By.id("android:id/title")).getText();
		assertEquals(msg, "Sample menu");
	}
}
