package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage extends BasePage {

	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
}
