package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	public WebElement eUsername;
	
	@FindBy(name = "pw")
	public WebElement ePassword;
	
	@FindBy(name = "Login")
	public WebElement eLoginButton;
	
	@FindBy(id = "exception")
	public WebElement eErrorMessage;
	

}
