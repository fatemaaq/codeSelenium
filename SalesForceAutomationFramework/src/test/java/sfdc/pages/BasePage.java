package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public BasePage() {
		
	}
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="lexNoThanks")
	public WebElement eErrorPrompt;
	
	@FindBy (id="tryLexDialogX")
	public WebElement eCancelError;



	
}
