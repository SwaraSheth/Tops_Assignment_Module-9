package com.assignment9;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class RealDevice_APIDemo {
	public void openAPIDemo() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();

		cap.setCapability("deviceName", "oneplus-iv2201");
		cap.setCapability("udid","X4DIIV4TZPWGNJQ4");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13.0");
		cap.setCapability( "appPackage","com.oneplus.calculator");
		cap.setCapability("appActivity","com.android.calculator2.Calculator");
		cap.setCapability("automationName", "UIAutomator2");

		URL url=new URL("http://127.0.0.1:4723/");
		
		AppiumDriver driver=new AppiumDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
}
