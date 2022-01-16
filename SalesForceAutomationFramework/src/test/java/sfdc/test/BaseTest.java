package sfdc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.configs.TestConstants;
import sfdc.pages.AccountsPage;
import sfdc.pages.HomePage;
import sfdc.pages.LoginPage;
import sfdc.utilities.BasicUtilities;
import sfdc.utilities.DataUtilities;


public class BaseTest {

	// How to initialize dynamic browser configuration
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static DataUtilities dataUtil = new DataUtilities();
	public static BasicUtilities basicUtil = new BasicUtilities();
	public static LoginPage loginPage = null;
	public static HomePage homePage = null;
	public static AccountsPage accountsPage = null;
	public Logger logger = Logger.getLogger(BaseTest.class);

	static long startTime = 0;
	static long endTime = 0;

//	@Parameters("browser_name")
	@BeforeSuite
//	public void setUp(String browserName) throws IOException {
	public void setUp() throws IOException {
		System.out.println("Executing setup");
		startTime = System.currentTimeMillis();
		
		ConsoleAppender ca = new ConsoleAppender();
		ca.setLayout(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c %L - %m%n"));
		ca.setThreshold(Level.ALL);
		ca.activateOptions();
		Logger.getRootLogger().addAppender(ca);

//		initializeLogging();
//		System.out.println("hello"+logger.getAllAppenders());
		logger.info("kia be");
//		initializeReports();
//		initializeDriver(browserName, false);
		initializeDriver("firefox", false);

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		accountsPage = new AccountsPage(driver);
	}

	public WebDriver initializeDriver(String browserName, boolean enableHeadlessMode) {
		
		System.out.println("Initializing browser");
		logger.info("testing AQ");
		String browsers = browserName.toLowerCase();
		switch (browsers) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if (enableHeadlessMode) {
				driver = new ChromeDriver(enableHeadlessMode());
			} else {
				driver = new ChromeDriver();
			}
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
		}
		return driver;
	}

	public ChromeOptions enableHeadlessMode() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--ignore-certificate-errors");
		return options;
	}

	private void initializeReports() {
		String timeStamp = new SimpleDateFormat("yymmddhhmmss").format(new Date());
		String path = TestConstants.sReportPath + "//sfdc_report_" + timeStamp + ".html";
		report = new ExtentReports();
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(path);
		report.attachReporter(htmlReport);
	}

	private void initializeLogging() throws IOException {
		Properties prop = new Properties();
//		System.out.println(TestConstants.sLog4JPropertiesPath);
		FileInputStream fis = new FileInputStream(TestConstants.sLog4JPropertiesPath);
//		int i;
//		while ((i = fis.read()) != -1) {
//			System.out.print((char) i);
//		}
		prop.load(fis);
		PropertyConfigurator.configure(fis);
		
	}
		
	public void takeScreenShot(String fileWithPath ) throws IOException {
		
		TakesScreenshot shot = ((TakesScreenshot)driver);
		
		File sourceFile = shot.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File (fileWithPath + "errorSnap" + "jpg");
		
		FileUtils.copyFile(sourceFile, destFile); //or use fileName as a parameter if destination is the same pass the whole path instead of fileWithPath.
		
	}
	

	@AfterSuite
	public void finishTest() {
		System.out.println("Finishing tests");
		// driver.close();
		report.flush();
		endTime = System.currentTimeMillis();
		System.out.println("Total time taken: " + (endTime - startTime));
//		logger.info("Total time taken: "+ (endTime-startTime));
//		logger.info("extent report flushed");
	}

	@Test
	public void testing() throws IOException {
		System.out.println("running aq");
	}
}
