package com.mobile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Sessions3 {
	
	//Agenda: How to handle a program in both Android and IOS platform
	
	static DesiredCapabilities cap;
	static AppiumServiceBuilder builder;
	static AppiumDriverLocalService service;


		
		@Test(priority = 1)
		public void setDC() {
			cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			// or cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability("platformVersion", "10");
			cap.setCapability("deviceName", "MotoG");
			cap.setCapability("appPackage", "com.google.android.contacts");
			cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
			cap.setCapability(MobileCapabilityType.NO_RESET, true);																					
			cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			cap.setCapability("unlockType", "pin");
			cap.setCapability("unlockPin", "515352");
		}
		
		@Test(priority = 3)	
		public void startAndroidDriver() throws MalformedURLException {
			
		AndroidDriver<MobileElement> driver;
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Launched App Successfully");
		
		
		
		//Go to Android.com--> There are different classes in the left menu bar--> search UISelector--> see all the methods 
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.google.android.contacts:id/contacts_list_container\"))"
							+ ".scrollIntoView(new UiSelector().class(\"android.widget.ImageView\")"); //this is coming from Android.com and not from Selenium/ Appium. UiSelector class/UiScrollable class
		       
		//resourceID is one of the method to pass element to locate
		
		 }
	
	@Test (priority = 2)
	public void startAppiumAutomatically() {
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		service = AppiumDriverLocalService.buildService(builder);
	    service.start();
	}
	
	@Test (enabled = false)
	public void startServer() {
	    CommandLine cmd = new CommandLine("C:\\Program Files (x86)\\Appium\\node.exe");
	    cmd.addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\Appium.js");
	    cmd.addArgument("--address");
	    cmd.addArgument("127.0.0.1");
	    cmd.addArgument("--port");
	    cmd.addArgument("4723");
	    
	    DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
	    DefaultExecutor executor = new DefaultExecutor();
	    executor.setExitValue(1);
	    try{
	        executor.execute(cmd, handler);
	        Thread.sleep(10000);
	    } catch(IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}
		
	
	@Test(enabled = false)
	public void stopServer() {
		 Runtime runtime = Runtime.getRuntime();
		    try{
		        runtime.exec("taskkill /F /IM node.exe");
		    } catch(IOException e) {
		        e.printStackTrace();
		    }
	}
	
	

}

	//driver.findElement(By.id( "com.macys.android:id/search_bar_field_text")).click();
	//  MobileElement search = driver.findElement(By.id("com.macys.android:id/search_bar_field"));
	//  search.sendKeys("girls dress");

//This one is for pagefactory init
//public Loginpage(AppiumDriver<MobileElement>driver) {
	  //PageFactory.initElements(new AppiumFieldDecorator(driver),this);
//}

//This will give you details of all the elements present on that page
//driver.getPageSource();


service = AppiumDriverLocalService.
    // buildDefaultService();
    buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
      .withAppiumJS(new File("C:Users\\user\\AppDataRoaming\
pm\\node_modulesappium\\lib\\main.js"))
      .withIPAddress("127.0.0.1").usingPort(4723)
      .withArgument(GeneralServerFlag.LOG_LEVEL, "error"));// this is the flag to remove debug
  if (service.isRunning() == true) {
   service.stop();
  } else {



Mithun reddy (to All - Entire Audience):

2:56 PM: public static AppiumDriverLocalService service;

