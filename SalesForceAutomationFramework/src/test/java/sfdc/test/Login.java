package sfdc.test;


import java.io.IOException;

import org.testng.Assert;

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
	
	public static void fetchWebsite() throws IOException {
		System.out.println("In fetchWebsite");
		driver.get(dataUtil.readAccounts("prod.url"));
		basicUtil.waitForElement(loginPage.eUsername);
	}

	public static boolean loginToApp() throws IOException {

		System.out.println("Started loginToApp");
		Assert.assertTrue(isLoginPageDisplayed());

		basicUtil.isElementVisible(loginPage.eUsername);
//		test.log(Status.INFO,"Username entered");
		basicUtil.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUsername);
		basicUtil.isElementVisible(loginPage.ePassword);
		basicUtil.sendText(dataUtil.readAccounts("prod.password"), loginPage.ePassword);
		basicUtil.clickOnElement(loginPage.eLoginButton);
		System.out.println("Login button clicked");
		if (basicUtil.waitForElement(homePage.eHomeTab)) {
			System.out.println("Login completed");
			return true;
		}
		else {
			System.out.println("Login issues");
			return false;
		}
	}
	
	public static boolean isLoginPageDisplayed() {
		if (BaseTest.basicUtil.waitForElement(BaseTest.loginPage.eUsername)) {
			System.out.println("Login page is on display");
			return true;
		} else {
			System.out.println("Login page is not displayed");
			return false;	
		}
	}
	
	

}
//Later the new test case has been created here which can use all the reusable funtions.