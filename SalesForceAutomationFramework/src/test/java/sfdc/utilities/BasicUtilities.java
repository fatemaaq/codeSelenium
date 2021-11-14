package sfdc.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import sdfc.configs.TestWaits;


//This class has all the reusable functions of nature "Interactable with the web element"
public class BasicUtilities {
	
	RemoteWebDriver driver;
	
	public void clickOnElement (WebElement element) {
		element.click();
	}

	public void sendText(String text, WebElement element) {
		element.sendKeys(text);
	}
	
	/* This function returns a true value if element is visible 
	 * else it will return false
	 */
	public boolean isElementVisible(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		}catch (NoSuchElementException e) {
			System.out.println("Element Not Found"+e.getMessage());
			return false;
		}
	}
	
	/* This function returns a true value if element is selected 
	 * i.e if a radio button/check box is selected. 
	 * else it will return false
	 */
	public boolean isElementSelected(WebElement element) {
		try {
			element.isSelected();
			return true;
		}catch (NoSuchElementException e) {
			System.out.println("Element Not Selected"+e.getMessage());
			return false;
		}
	}
	
	/* This function selects an item from drop down menu 
	 * if it is by value (String)
	 */
	public void selectElementFromDropDown(WebElement element, String dropdownValue) {
		Select s = new Select (element);
		s.selectByValue(dropdownValue);
	}
	
	/* This function selects an item from drop down menu 
	 * if it is by index (Integer)
	 */
	public void selectElementFromDropDown(WebElement element, int index) {
		Select s = new Select (element);
		s. selectByIndex(index);
	}
	
	/* This function would only put the mouse pointer on the given particular element 
	 */
	public void moveFocusOntoElement (WebElement element) {
		Actions action = new Actions (driver);
		action.moveToElement(element).build().perform();
	}
	
	/* This function will create wait for the web element for defined time  
	 * time is defined in a new class 'TestWaits'
	 */
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TestWaits.WAIT_FOR_ELEMENT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	
	
}	
		

	

