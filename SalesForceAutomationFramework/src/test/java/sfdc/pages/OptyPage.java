package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptyPage extends BasePage {

	public OptyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//ul//li[@id=\"Opportunity_Tab\"]")
	public WebElement eOpportunity;
	
	@FindBy (id= "fcf")
	public WebElement eOppDropDown;
	
	@FindBy (name="new")
	public WebElement eNew;
	
	@FindBy (id= "opp3")
	public WebElement eOppName;
	
	@FindBy (id= "opp4")
	public WebElement eAccountName;
	
	@FindBy (id= "opp9")
	public WebElement eCloseDate;
	
	@FindBy (xpath= "//table[@id=\"datePickerCalendar\"]//following::a[1]")
	public WebElement eTodayDate;
	
	@FindBy (id= "opp11")
	public WebElement eStage;
	
	@FindBy (name= "opp12")
	public WebElement eProbability;
	
	@FindBy (id= "opp6")
	public WebElement eLeadSource;
	
	@FindBy (id= "opp17")
	public WebElement ePrimCamp;
	
	@FindBy (xpath= "//table[@id=\"toolsContent\"]//following::a[1]")
	public WebElement eOppPipeline;
	
	@FindBy (xpath="//table[@id=\"toolsContent\"]//li//following::a[1]")
	public WebElement eStuckOpp;
	
	@FindBy (id= "quarter_q")
	public WebElement eIntervalQuatSum;
	
	@FindBy (id= "open")
	public WebElement eIncludeQuatSum;
	
	@FindBy (name= "go")
	public WebElement eRunReportQuatSum;

	

	
	
	
}
