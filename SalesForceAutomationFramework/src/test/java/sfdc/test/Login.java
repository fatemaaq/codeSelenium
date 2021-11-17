package sfdc.test;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import sfdc.pages.LoginPage;

public class Login extends BaseTest {
	
//	@Test (priority = 0)
//	public void launchApp() throws IOException {
//		driver.get(dataUtil.readAccounts("prod.url"));
//		WebElement userName = driver.findElement(By.name("username"));
//		basicUtil.waitForElement(userName, driver);
//	}
//	@Test (priority = 1, dependsOnMethods = "launchApp")
//	public void loginToApp() {
//		System.out.println("App is logged in");
//	
//	}
//	@Test (enabled = false)
//	public void goToHomePage() {
//		System.out.println("Home page");
//	
//	}
//	@Test (priority = 2)
//	public void logOut() {
//		System.out.println("logged out");
//	
//	}
	
	public static void fetchWebsite() throws IOException, InterruptedException {
		System.out.println("In fetchWebsite");
		driver.get(dataUtil.readAccounts("prod.url"));
		loginPage = new LoginPage(driver);
		basicUtil.waitForElement(loginPage.eUsername);
	}

	public static void loginToApp() throws IOException {
		Assert.assertTrue(isLoginPageDisplayed());
		
		basicUtil.isElementVisible(loginPage.eUsername);
//		test.log(Status.INFO,"Username entered");
		basicUtil.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUsername);
		basicUtil.isElementVisible(loginPage.ePassword);
		basicUtil.sendText(dataUtil.readAccounts("prod.password"), loginPage.ePassword);
		basicUtil.clickOnElement(loginPage.eLoginButton);
	}
	
	public static boolean isLoginPageDisplayed() {
		if (BaseTest.basicUtil.waitForElement(BaseTest.loginPage.eUsername)) {
			return true;
		} else {
			return false;	
		}
	}

}
//Later the new test case has been created here which can use all the reusable funtions.