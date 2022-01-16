package com.pages.sfdc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class loginPage {
	 //example using mobile element both for Android and IOS
	@AndroidFindBy(tagName = "")
	@iOSXCUITFindBy()
	MobileElement username;

}
