package com.cucumber.stepsdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.test.BaseTest;

public class AccountSteps extends BaseTest {
	
	
	@Given("User launches the application")
	public void user_launches_the_application() {
		BaseTest.driver = initializeDriver("firefox", false);
		driver.get("https://login.salesforce.com");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() {
	    basicUtil.sendText("fatemaaq@gmail.com", loginPage.eUsername);
	    basicUtil.sendText("fainfain12", loginPage.ePassword);
	    //throw new io.cucumber.java.PendingException();
	}
	    
	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		basicUtil.clickOnElement(loginPage.eLoginButton);
		 //throw new io.cucumber.java.PendingException();
	    }
	

	@When("User clicks on accounts link")
	public void user_clicks_on_accounts_link() {
	    basicUtil.clickOnElement(accountsPage.eAccountTab);
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on new button to craete new account")
	public void user_clicks_on_new_button_to_craete_new_account() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on new button to new view link")
	public void user_clicks_on_new_button_to_new_view_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
