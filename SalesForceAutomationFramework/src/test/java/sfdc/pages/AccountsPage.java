package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage extends BasePage{

	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="fcf")
	public WebElement eViewName; 
	
	@FindBy (id="Account_Tab")
	public WebElement eAccountTab;
	
	//@FindBy (id="lexNoThanks")
	//public WebElement eErrorPrompt;
	
	//@FindBy (id="tryLexDialogX")
	//public WebElement eCancelError;
	
	@FindBy (xpath="//span//a[last()-1]")
	public WebElement eEdit;
	
	@FindBy (id="fcol1")
	public WebElement eField;
	
	@FindBy (id="fop1")
	public WebElement eOperator;
	
	@FindBy (id="fval1")
	public WebElement eValue;
	
	//*[@id="toolsContent"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a
//	@FindBy(xpath="/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")
	@FindBy (xpath="//table[@id = \"toolsContent\"]//following::a[last()-25]")
//	@FindBy (xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")
	public WebElement eMergeTools;
	
	@FindBy (name="srchbutton")
	public WebElement eFindAccounts;
	
	@FindBy (id="srch")
	public WebElement eMergeField;

	@FindBy (id= "cid0")
	public WebElement eFirstOption;
	
	@FindBy (id= "cid1")
	public WebElement eSecondOption;
	
	@FindBy (id= "cid02")
	public WebElement eThirdOption;
	
	@FindBy (name= "goNext")
	public WebElement eNext;
	
	@FindBy (name= "save")
	public WebElement eNextSecondPage;
		
	@FindBy (xpath= "//table[@id='toolsContent']//li//following::a[1]")
	public WebElement eAccounts30days;
	
	@FindBy (id= "ext-gen152")
	public WebElement eDateFrom;
	
	@FindBy (id= "ext-gen227")
	public WebElement eTodaysDateFrom;
	
	@FindBy (id= "ext-gen154")
	public WebElement eDateTo;
	
	@FindBy (id= "ext-gen292")
	public WebElement eTodaysDateTo;
	
	@FindBy (id= "ext-gen49")
	public WebElement eSave;
	
	@FindBy (id= "saveReportDlg_reportNameField")
	public WebElement eRprtName;
	
	@FindBy (id= "saveReportDlg_DeveloperName")
	public WebElement eRprtUniqueName;
	
	@FindBy (id= "dlgSaveAndRun")
	public WebElement eSaveAndRunReport;
	
	
}
