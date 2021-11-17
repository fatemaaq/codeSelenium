package sfdc.test;

import org.testng.annotations.Test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import sfdc.pages.AccountsPage;

public class Accounts extends BaseTest{
	
	AccountsPage accountsPage;
	
	@BeforeMethod(onlyForGroups = "salesforce")
	public void OpenSalesForce() throws InterruptedException, IOException {
			System.out.println("In open sales force");
			Login.fetchWebsite();
			Login.loginToApp();
			accountsPage = new AccountsPage(driver);
		}

	@Test(enabled = false)
	public void TC10() throws InterruptedException {

		driver.findElement(By.id("Account_Tab")).click();
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		// driver.switchTo().alert().dismiss();
		driver.findElement(By.id("createNewButton")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[1]/div/div[1]/div/div/div[2]/a[5]"))
				.click();
		driver.findElement(By.id("acc2")).sendKeys("FAQ Abdul");
		driver.findElement(By.name("save")).click();
	}

	@Test(enabled = false)
	public void TC11() {
		driver.findElement(By.id("Account_Tab")).click();
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"))
				.click();
		driver.findElement(By.id("fname")).sendKeys("Personal Account");
		driver.findElement(By.id("devname")).sendKeys("XYZ");
		driver.findElement(By.name("save")).click();

	}

	@Test(enabled = false, groups = "salesforce")
	public void TC12() {
//		test = extent.createTest("TC12");
//		basicUtil.clickOnElement(accountsPage.eAccountTab);
//		basicUtil.isElementVisible(accountsPage.eErrorPrompt);
//		basicUtil.clickOnElement(accountsPage.eErrorPrompt);
//		basicUtil.isElementVisible(accountsPage.eCancelError);
//		basicUtil.clickOnElement(accountsPage.eCancelError);
//
//		basicUtil.selectElementFromDropDown(accountsPage.eViewName, 4);

////		Select dropDown = new Select(driver.findElement(By.name("fcf"))); // ---> this will click on the view drop down list
////		dropDown.selectByIndex(4); // ---> It will click on the desired field in the drop down menu which is personal account in this case that we created as new earlier
//		basicUtil.selectElementFromDropDown(accountsPage.viewName, 4);
//		
//		driver.findElement(By.xpath("//span//a[last()-1]")).click();
		
//		test.log(Status.INFO,"clicked on a edit button on Accounts page");
		
//		basicUtil.selectElementFromDropDown(eUserName,"sdffsd");
		
	}

	@Test(enabled = true, groups= "salesforce")
	public void TC13() throws InterruptedException {
		basicUtil.clickOnElement(accountsPage.eAccountTab);
		if(basicUtil.isElementVisible(accountsPage.eErrorPrompt)){
		basicUtil.clickOnElement(accountsPage.eErrorPrompt);
		System.out.println("wow");
		} if (basicUtil.isElementVisible(accountsPage.eCancelError)) {
		basicUtil.clickOnElement(accountsPage.eCancelError); 
		}else 
		{System.out.println("I am out");}

		

		

	}

	@Test(enabled = false, groups = "salesforce")
	public void TC14() {
		System.out.println("logged out");

	}

}
