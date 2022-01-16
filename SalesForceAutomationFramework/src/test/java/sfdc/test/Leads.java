package sfdc.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sfdc.pages.LeadsPage;
import sfdc.pages.OptyPage;

public class Leads extends BaseTest{

	LeadsPage leadsPage;

	@BeforeMethod
	public void OpenSalesForce() throws InterruptedException, IOException {
		System.out.println("In open sales force");
		Login.fetchWebsite();
		Login.loginToApp();
		leadsPage = new LeadsPage(driver);
	}	

	@Test(enabled = false)
	public void TC20() throws InterruptedException {
		basicUtil.clickOnElement(leadsPage.eLeads);
		if (basicUtil.isElementVisible(leadsPage.eErrorPrompt)) {
			basicUtil.clickOnElement(leadsPage.eErrorPrompt);
			if (basicUtil.isElementVisible(leadsPage.eCancelError))
				basicUtil.clickOnElement(leadsPage.eCancelError);
		}

		System.out.println("Leads home page is displayed");
	}

	@Test(enabled = false)//this is incomplete
	public void TC21() throws InterruptedException {
		basicUtil.clickOnElement(leadsPage.eLeads);
		if (basicUtil.isElementVisible(leadsPage.eErrorPrompt)) {
			basicUtil.clickOnElement(leadsPage.eErrorPrompt);
			if (basicUtil.isElementVisible(leadsPage.eCancelError))
				basicUtil.clickOnElement(leadsPage.eCancelError);
		}

		System.out.println("");
	}

	@Test(enabled = true)
	public void TC22() throws InterruptedException, IOException {
		basicUtil.clickOnElement(leadsPage.eLeads);
		if (basicUtil.isElementVisible(leadsPage.eErrorPrompt)) {
			basicUtil.clickOnElement(leadsPage.eErrorPrompt);
			if (basicUtil.isElementVisible(leadsPage.eCancelError))
				basicUtil.clickOnElement(leadsPage.eCancelError);
		}
		basicUtil.selectElementFromDropDown(leadsPage.eLeadsDd, 3);
		basicUtil.clickOnElement(leadsPage.eUserMenuDd);
		basicUtil.clickOnElement(leadsPage.eLogout);
		Login.loginToApp();
		basicUtil.clickOnElement(leadsPage.eLeads);
		basicUtil.clickOnElement(leadsPage.eGo);
	} //Test case ends here below is the assertion

	public boolean isLeadPageDisplayed() {
		if (BaseTest.basicUtil.waitForElement(leadsPage.eLeadsDd)) {
			System.out.println("Lead page is on display with selected item");
			return true;
		} else {
			System.out.println("Lead page is not displayed with selected item");
			return false;	
		}

	}




}
