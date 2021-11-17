package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="fcf")
	public WebElement eViewName; 
	
	@FindBy (id="Account_Tab")
	public WebElement eAccountTab;
	
	@FindBy (id="lexNoThanks")
	public WebElement eErrorPrompt;
	
	@FindBy (id="tryLexDialogX")
	public WebElement eCancelError;

}
