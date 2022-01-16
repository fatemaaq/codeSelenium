package com.mobile;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Session1 {
	
	// Connect device to the computer
			// Check in command prompt if device is available under adb devices
			//Star appium server (GUI or cmd)
	//For Calculator ---> com.google.android.calculator/com.android.calculator2.Calculator

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		// or cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("deviceName", "MotoG");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		AndroidDriver<MobileElement> driver;
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Launched App Successfully");
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		

		

	}

}
