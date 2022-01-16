package com.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class Session2 {
	
	// Left swipe
	//Scroll
	//Pinch zoom etc using Contacts App

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		// or cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("deviceName", "MotoG");
		cap.setCapability("appPackage", "com.google.android.contacts");
		cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity"); // revise
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		cap.setCapability("unlockType","pin");
		cap.setCapability("unlockPin", "515352");
		
		
		AndroidDriver<MobileElement> driver;
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Launched App Successfully");
		
		//Clicking on hamburger button
		MobileElement hamBurgerButton = driver.findElementByClassName("android.widget.ImageButton");
		hamBurgerButton.click();
		Thread.sleep(3000);
		
		//getting the size of hamburger button
		 Dimension size = hamBurgerButton.getSize();
		 int yAxis = size.getHeight();
		 int xAxis = size.getWidth();
		 System.out.println("Height is:"+size.getHeight() +"Width is:"+size.getWidth());
		
	
		//Performing swipe action after clicking on hamburger button.
		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(600, 500)).moveTo(PointOption.point(10,500)).release().perform();
		System.out.println("Swipped successfuly");
		
		//Opening up a new app - Photos to check zoom action 
		Activity photos = new Activity("com.google.android.apps.photos" , "com.google.android.apps.photos.home.HomeActivity");
		driver.startActivity(photos);
		//MobileElement firstImage = driver.findElementByClassName("android.view.ViewGroup");
		//firstImage.click();
		
		Thread.sleep(3000);
		
		//Getting full window size
		Dimension windowSize = driver.manage().window().getSize();
		System.out.println(windowSize);
		
		//Performing pinch zoom using two fingers
		TouchAction pointer = new TouchAction(driver);
		pointer.longPress(PointOption.point(500,1500)).moveTo(PointOption.point(500,1200)).release();
		
		TouchAction thumb = new TouchAction(driver);
		pointer.longPress(PointOption.point(500,1700)).moveTo(PointOption.point(500,1900)).release();
		
		MultiTouchAction zoom = new MultiTouchAction(driver);
		zoom.add(pointer).add(thumb).perform();
		System.out.println("ZoomIn");
		
		
				
		driver.navigate().back();
		
		//Scrolling on the photos homepage
		//Activity photos1 = new Activity("com.google.android.apps.photos" , "com.google.android.apps.photos.home.HomeActivity");
		//driver.startActivity(photos1);
		TouchAction scrollAction = new TouchAction(driver);
		scrollAction.longPress(PointOption.point(500, 1000)).moveTo(PointOption.point(500,700)).release().perform();
		System.out.println("Scrolling");
		
		//Opening up a new app - Settings to check minimizing on its original
		Activity settingsApp = new Activity("com.android.settings" , "com.android.settings.Settings");
		driver.startActivity(settingsApp);
		MobileElement batteryButton = driver.findElementById("android:id/icon"); //this--->className-->android.widget.ImageView (if id does not work)
		driver.runAppInBackground(Duration.ofSeconds(10));
		driver.navigate().back();
		driver.lockDevice();
		Thread.sleep(2000);
		driver.unlockDevice();
		
		
		
		
		
		
		
		
		//Opening up a new app - Photos to check zoom action 
		//Activity photos = new Activity("com.google.android.apps.photos" , "com.google.android.apps.photos.home.HomeActivity");
		//driver.startActivity(photos);
		
		
		
		
		
		
		
		
		
		
		

	}

}
