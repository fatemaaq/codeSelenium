package sfdc.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
	public void TC12() throws InterruptedException {
		//test = extent.createTest("TC12"); -->please check this
		basicUtil.clickOnElement(accountsPage.eAccountTab);
		if (basicUtil.isElementVisible(accountsPage.eErrorPrompt)) {
			basicUtil.clickOnElement(accountsPage.eErrorPrompt);
			if (basicUtil.isElementVisible(accountsPage.eCancelError))
				basicUtil.clickOnElement(accountsPage.eCancelError);
		}	
		
		basicUtil.selectElementFromDropDown(accountsPage.eViewName, 4);
		System.out.println("I selected dropdown with value");
		Thread.sleep(3000);
		basicUtil.clickOnElement(accountsPage.eEdit);
		test.log(Status.INFO,"clicked on an edit button on Accounts page");
		basicUtil.selectElementFromDropDown(accountsPage.eField, 1);
		//basicUtil.selectElementFromDropDown(accountsPage.eField,"Account Name");
		Thread.sleep(2000);
		basicUtil.selectElementFromDropDown(accountsPage.eOperator,3);
		basicUtil.sendText("a", accountsPage.eValue);
		//few more step left (action)
	}

	@Test(enabled = false, groups= "salesforce")
	public void TC13() throws InterruptedException {
		basicUtil.clickOnElement(accountsPage.eAccountTab);
		if (basicUtil.isElementVisible(accountsPage.eErrorPrompt)) {
			basicUtil.clickOnElement(accountsPage.eErrorPrompt);
			if (basicUtil.isElementVisible(accountsPage.eCancelError))
				basicUtil.clickOnElement(accountsPage.eCancelError);
		}	
		
		basicUtil.selectElementFromDropDown(accountsPage.eViewName, 4);
		System.out.println("I selected accounts on homepage");
		if(basicUtil.isElementVisible(accountsPage.eMergeTools))
			basicUtil.clickOnElement(accountsPage.eMergeTools);
		else
			System.out.println("something is not right");
		basicUtil.sendText("United Oil", accountsPage.eMergeField);
		basicUtil.clickOnElement(accountsPage.eFindAccounts);
		
		if(basicUtil.isElementSelected(accountsPage.eFirstOption)) {
			System.out.println("First element is already selected");
		}else 
		{
			basicUtil.clickOnElement(accountsPage.eFirstOption);
		}
		if(basicUtil.isElementSelected(accountsPage.eSecondOption)) {
			System.out.println("Second element is already selected");
		}else 
		{
			basicUtil.clickOnElement(accountsPage.eSecondOption);
		}
		basicUtil.clickOnElement(accountsPage.eNext);
		basicUtil.clickOnElement(accountsPage.eNextSecondPage);
		
		driver.switchTo().alert().dismiss();
		
		
		
		
		
	}

	@Test(enabled = false, groups = "salesforce")
	public void TC14() throws InterruptedException {
		basicUtil.clickOnElement(accountsPage.eAccountTab);
		if (basicUtil.isElementVisible(accountsPage.eErrorPrompt)) {
			basicUtil.clickOnElement(accountsPage.eErrorPrompt);
			if (basicUtil.isElementVisible(accountsPage.eCancelError))
				basicUtil.clickOnElement(accountsPage.eCancelError);		
		}	
		basicUtil.clickOnElement(accountsPage.eAccounts30days);
		//driver.switchTo().alert().dismiss();
		basicUtil.clickOnElement(accountsPage.eDateFrom);
		basicUtil.clickOnElement(accountsPage.eTodaysDateFrom);
		
		basicUtil.clickOnElement(accountsPage.eDateTo);
		basicUtil.clickOnElement(accountsPage.eTodaysDateFrom);
		
		basicUtil.clickOnElement(accountsPage.eSave);
		
		basicUtil.sendText("TC14 reprt", accountsPage.eRprtName);
		basicUtil.sendText("TC14", accountsPage.eRprtUniqueName);
		Thread.sleep(2000);
		basicUtil.clickOnElement(accountsPage.eSaveAndRunReport);
	
		System.out.println("Saved and Run Report");

	}

}
