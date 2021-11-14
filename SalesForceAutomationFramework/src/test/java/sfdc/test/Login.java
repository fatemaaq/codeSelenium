package sfdc.test;


import org.testng.annotations.Test;

public class Login {
	
	@Test (priority = 0)
	public void launchApp() {
		System.out.println("App is launched");
	
	}
	@Test (priority = 1, dependsOnMethods = "launchApp")
	public void loginToApp() {
		System.out.println("App is logged in");
	
	}
	@Test (enabled = false)
	public void goToHomePage() {
		System.out.println("Home page");
	
	}
	@Test (priority = 2)
	public void logOut() {
		System.out.println("logged out");
	
	}

}
//Later the new test case has been created here which can use all the reusable funtions.