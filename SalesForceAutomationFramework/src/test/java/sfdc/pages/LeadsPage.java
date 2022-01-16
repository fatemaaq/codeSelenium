package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage extends BasePage {

	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="Lead_Tab")
	public WebElement eLeads;
	
	@FindBy (name="fcf")
	public WebElement eLeadsDd;
	
	@FindBy (id="userNavLabel")
	public WebElement eUserMenuDd;
	
	@FindBy (xpath= "//div[@id=\"userNav\"]//following::a[5]")
	public WebElement eLogout;
	
	@FindBy (name="go")
	public WebElement eGo;
}
