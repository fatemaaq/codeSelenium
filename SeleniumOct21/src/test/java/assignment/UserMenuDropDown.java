package assignment;

import java.io.File;
import java.io.IOException;
//import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.sun.java.swing.plaf.windows.resources.windows;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserMenuDropDown {
	
	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports extent;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
			
	        WebDriverManager.firefoxdriver().setup(); //install Webdriver Manager
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			
			String reportPath = System.getProperty("user.dir")+"/target/basicReport.html";
			extent = new ExtentReports();
			ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportPath);
			extent.attachReporter(htmlReport);
			
//			test = extent.createTest("case1_TC05");
//			test.log(null, null)
//			test.pass("case1_TC05: Passed");
//			extent.flush();  //This will publish the report
//			
			
			
			
			
			//case1_TC05(); //------> This will test for user menu drop down options from user menu on the home page
		
//			case2_TC06();  //----> This will select My profile from drop down menu to all the way till add photo link
			case3_TC07(); //-----> This will click My settings from drop down menu to all the way till pop window is displayed after clicking on Calendar and Remainders
			//case4_TC08(); //----> This will click on Developer console window and then close it
			//case5_TC09(); //---> This will logout
			
			
			extent.flush();
//			driver.quit();




	}
	
	public static void case1_TC05() throws InterruptedException, IOException {
		test = extent.createTest("case1_TC05");
		
        
	
 		driver.get("https://login.salesforce.com/");
	    driver.manage().window().maximize();
		test.log(Status.INFO,"Salesforce Login Page is launched");
		
		driver.findElement(By.id("username")).sendKeys("fatemaaq@gmail.com");
		test.log(Status.INFO,"UserName is entered");

		
		driver.findElement(By.id("password")).sendKeys("FainFain12");
		test.log(Status.INFO,"Password is entered");

		WebElement login = driver.findElement(By.id("Login"));
		
		login.click();
		Thread.sleep(5000);
		
		
		if  (driver.findElement(By.id("userNavLabel")).isDisplayed()) {
			test.log(Status.PASS, "User Menu Dropdown found");
		}
		
		else 
		{
			
			TakesScreenshot screenShot = (TakesScreenshot)driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir")+"/target/PIC.PNG");
			FileUtils.copyFile(source, destination);
			test.log(Status.FAIL, "User Menu Dropdown not found ").addScreenCaptureFromPath(System.getProperty("user.dir")+"/target/PIC.PNG");
			
			//extent.flush();
			
			driver.findElement(By.id("userNavLabel")).click();
			Thread.sleep(5000);
		}
		
		
		
			
	}
		
	
		
	
	public static void case2_TC06( ) throws InterruptedException {
		
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
		
		
		driver.findElement(By.id("username")).sendKeys("fatemaaq@gmail.com");
		driver.findElement(By.id("password")).sendKeys("FainFain12");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		
		
		driver.findElement(By.id("userNavLabel")).click(); //This is clicking on user menu drop down
		
		driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(1)")).click(); //This is clicking on My Profile in user drop dow menu
		
		driver.findElement(By.cssSelector(".contactInfoLaunch > img:nth-child(1)")).click(); // This is clicking on the pensil icon to edit contact
		
		Thread.sleep(2000);
		
		
		driver.switchTo().frame("contactInfoContentId");
		System.out.println("I am in the iframe to click on about");
		WebElement AboutTab  = driver.findElement(By.id("aboutTab"));
		AboutTab.click();
		System.out.println("About is clicked");
		
		WebElement editLastName = driver.findElement(By.id("lastName")); //Lets clear the existing text in the lastName tab
		editLastName.clear();
		
		editLastName.sendKeys("Saifuddin"); //-----> editing Last Name Field
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]")).click(); //Clicks on save button
		System.out.println("Information has been saved");
	
		Thread.sleep(5000);
//		

//		Thread.sleep(2000);
		WebElement postButton= driver.findElement(By.cssSelector("#publisherAttachTextPost > span:nth-child(2)")); 
		postButton.click();
		
		Thread.sleep(2000);
		WebElement postIframe=driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
		driver.switchTo().frame(postIframe);
		System.out.println("I am in the frame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html[1]/body[1]")).sendKeys("Hello");
	
		
		
		
		
	//	/html/body/div/div/div/div[2]/form/div/input[1]

		
		

		
		
		
	}
	
	
	
	
	public static void case3_TC07 () throws InterruptedException {
		
		driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
		
		
		driver.findElement(By.id("username")).sendKeys("fatemaaq@gmail.com");
		driver.findElement(By.id("password")).sendKeys("FainFain12");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		
		driver.findElement(By.id("userNavLabel")).click(); //This is clicking on user menu drop down
		driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(2")).click(); //click on my settings
		driver.findElement(By.id("PersonalInfo_font")).click(); //click on personal in side tab
		driver.findElement(By.id("LoginHistory_font")).click(); //click on login history
		driver.findElement(By.id("DisplayAndLayout_font")).click(); //click on Display and Layout
		driver.findElement(By.id("CustomizeTabs_font")).click(); //click on customize my tabs
		Thread.sleep(2000);
//		driver.findElement(By.id("p4")).click(); //click on custom app drop down menu
		
		
		WebElement dropmenu = driver.findElement(By.id("p4"));
		Actions action = new Actions(driver);
		
		dropmenu.click();
		Thread.sleep(2000);
		dropmenu.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		dropmenu.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
//		dropmenu.sendKeys(Keys.DOWN);
//		dropmenu.sendKeys(Keys.DOWN);
//		dropmenu.sendKeys(Keys.DOWN);
//		dropmenu.sendKeys(Keys.DOWN);
//		dropmenu.sendKeys(Keys.DOWN);
//		dropmenu.sendKeys(Keys.DOWN);
//		dropmenu.sendKeys(Keys.ENTER);
		
//		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[2]/td/select/option[9]")).click(); //This will click on Salesforce chatter
//		driver.findElement(By.id("duel_select_0")).click(); //click on available tabs
//		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[1]/select/option[67]")).click(); //This will click on reports
//		driver.findElement(By.id("duel_select_0_right")).click(); //click on add button
//		driver.findElement(By.name("save")).click(); //click on save button
//		
//		driver.findElement(By.id("EmailSetup")).click(); //click on email from the side bar
//		driver.findElement(By.id("EmailSettings_font")).click(); //click on my email settings
//		//driver.findElement(By.id("duel_select_0")).click(); //click on
//		driver.findElement(By.name("save")).click();
//		System.out.println("Email settings have been saved");
//		
//		driver.findElement(By.id("CalendarAndReminders_font")).click(); //click on calendar and reminders
//		driver.findElement(By.id("Reminders_font")).click(); //click on activity reminders
//		
//		driver.findElement(By.id("testbtn")).click(); //click on calendar and reminders
//

		System.out.println("A pop up window is open");
		
		//Yaaaaay!!!

	}
	
	
	
	public static void case4_TC08() throws InterruptedException {
		test = extent.createTest("case4_TC08");

		driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
		
		
		driver.findElement(By.id("username")).sendKeys("fatemaaq@gmail.com");
		driver.findElement(By.id("password")).sendKeys("FainFain12");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		
		driver.findElement(By.id("userNavLabel")).click(); //This is clicking on user menu drop down
		driver.findElement(By.xpath("//a[@Class = 'debugLogLink menuButtonMenuLink']")).click();
		
		Set<String> windowNext = driver.getWindowHandles();
		String[] getWindow = windowNext.toArray(new String[windowNext.size()]);
		driver.switchTo().window(getWindow[1]);
		Thread.sleep(3000);
		driver.close();
		
		test.log(Status.INFO, "I closed the developer's window");
		
		
		}
	
	public static void case5_TC09() throws InterruptedException {
		
		test = extent.createTest("case4_TC08");

		driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
		
		
		driver.findElement(By.id("username")).sendKeys("fatemaaq@gmail.com");
		driver.findElement(By.id("password")).sendKeys("FainFain12");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		
		driver.findElement(By.id("userNavLabel")).click(); //This is clicking on user menu drop down
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(5)")).click();
		
		test.log(Status.INFO, "logged out");
		
	}
	
	
	
}



