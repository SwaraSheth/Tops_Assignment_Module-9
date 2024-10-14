package com.assignment9;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/*
 * Write an Appium Program to connect with emulator and open APIdemo.app application on your emulator 
 */

public class Emulator_APIDemo {
	public AndroidDriver driver;
	AppiumDriverLocalService service;
	public void before() throws MalformedURLException, InterruptedException {
		service=new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Swara");
		options.setApp("D:\\Appium\\apk file\\ApiDemos-debug.apk");

		 driver=new AndroidDriver
				(new URL("http://127.0.0.1:4723/"),options);
		 //implicit wait
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.quit();
		}
}
