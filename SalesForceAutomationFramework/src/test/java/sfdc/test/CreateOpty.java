package sfdc.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import sfdc.pages.AccountsPage;
import sfdc.pages.BasePage;
import sfdc.pages.OptyPage;

public class CreateOpty extends BaseTest {
	OptyPage optyPage;
	
	@BeforeMethod
	public void OpenSalesForce() throws InterruptedException, IOException {
			System.out.println("In open sales force");
			Login.fetchWebsite();
			Login.loginToApp();
			optyPage = new OptyPage(driver);
	}
	
	@Test(enabled = false)
	public void TC15() throws InterruptedException {
		basicUtil.clickOnElement(optyPage.eOpportunity);
		if (basicUtil.isElementVisible(optyPage.eErrorPrompt)) {
			basicUtil.clickOnElement(optyPage.eErrorPrompt);
			if (basicUtil.isElementVisible(optyPage.eCancelError))
				basicUtil.clickOnElement(optyPage.eCancelError);
			}
		if(basicUtil.isElementVisible(optyPage.eOppDropDown)) {
			System.out.println("Opportunity Drop Down is present");//Yaaaay!!
		}
	}
	
	@Test(enabled = false)
	public void TC16() throws InterruptedException {
		basicUtil.clickOnElement(optyPage.eOpportunity);
		if (basicUtil.isElementVisible(optyPage.eErrorPrompt)) {
			basicUtil.clickOnElement(optyPage.eErrorPrompt);
			if (basicUtil.isElementVisible(optyPage.eCancelError))
				basicUtil.clickOnElement(optyPage.eCancelError);
			}
		basicUtil.clickOnElement(optyPage.eNew);
		basicUtil.sendText("First TC16 Test", optyPage.eOppName);
		basicUtil.sendText("FaqTest", optyPage.eAccountName);
		basicUtil.clickOnElement(optyPage.eCloseDate);
		Thread.sleep(2000);
		basicUtil.clickOnElement(optyPage.eTodayDate);
		Thread.sleep(2000);
		driver.findElement(By.id("head_1_ep")).click();//clicking on header,date pop up gets close otherwise it obscures other fields
		basicUtil.clearText(optyPage.eProbability);
		basicUtil.sendText("20", optyPage.eProbability);
		basicUtil.sendText("Selenium", optyPage.ePrimCamp); 
		basicUtil.selectElementFromDropDown(optyPage.eStage, 1);
		basicUtil.selectElementFromDropDown(optyPage.eLeadSource, 2);
		System.out.println("Entered all field successfully in new Opportunity page");//Yaaaay!!
	}

	@Test(enabled = false)
	public void TC17() throws InterruptedException {
		basicUtil.clickOnElement(optyPage.eOpportunity);
		if (basicUtil.isElementVisible(optyPage.eErrorPrompt)) {
			basicUtil.clickOnElement(optyPage.eErrorPrompt);
			if (basicUtil.isElementVisible(optyPage.eCancelError))
				basicUtil.clickOnElement(optyPage.eCancelError);
			}
		basicUtil.clickOnElement(optyPage.eOppPipeline);
		System.out.println("Opportunity Pipeline page is displayed");
	}
	
	@Test(enabled = false)
	public void TC18() throws InterruptedException {
		basicUtil.clickOnElement(optyPage.eOpportunity);
		if (basicUtil.isElementVisible(optyPage.eErrorPrompt)) {
			basicUtil.clickOnElement(optyPage.eErrorPrompt);
			if (basicUtil.isElementVisible(optyPage.eCancelError))
				basicUtil.clickOnElement(optyPage.eCancelError);
			}
		basicUtil.clickOnElement(optyPage.eStuckOpp);
		System.out.println("Stuck Opportunity page is displayed");
	}
	
	@Test(enabled = true)
	public void TC19() throws InterruptedException {
		basicUtil.clickOnElement(optyPage.eOpportunity);
		if (basicUtil.isElementVisible(optyPage.eErrorPrompt)) {
			basicUtil.clickOnElement(optyPage.eErrorPrompt);
			if (basicUtil.isElementVisible(optyPage.eCancelError))
				basicUtil.clickOnElement(optyPage.eCancelError);
			}
		basicUtil.selectElementFromDropDown(optyPage.eIntervalQuatSum, 2);
		basicUtil.selectElementFromDropDown(optyPage.eIncludeQuatSum, 2);
		System.out.println("Quarterly Summary page is displayed with respective fields information");
	}
}
