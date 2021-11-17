package sfdc.utilities;

import java.io.File;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.configs.TestWaits;
import sfdc.test.BaseTest;


//This class has all the reusable functions of nature "Interactable with the web element"
public class BasicUtilities {
	
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
		Actions action = new Actions(BaseTest.driver);
		action.moveToElement(element).build().perform();
	}
	
	/* This function will create wait for the web element for defined time  
	 * time is defined in a new class 'TestWaits'
	 */
	public boolean waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, TestWaits.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
		
	}
	
	/* This function will capture a screenshot and attach it to the destination given in the path
	 */
	public String getScreenCapture(WebDriver driver) {
		String path ="";
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("");
		return path;
				
	}
	
}	
		

	

