package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Accounts {

	static WebDriver driver;

	
	

	@BeforeMethod(onlyForGroups = "salesforce")
	public void OpenSalesForce() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
//		Thread.sleep(1000);
		driver.findElement(By.name("username")).sendKeys("fatemaaq@gmail.com");
//		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("FainFain12");
//		Thread.sleep(1000);
		
		// driver.findElement(By.xpath("//*[@id= 'login']/a/span")).click();---> this
		// approach is not working
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
	}

	@Test(enabled = false)
	public void TC10() throws InterruptedException {

		driver.findElement(By.id("Account_Tab")).click();
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		// driver.switchTo().alert().dismiss();
		driver.findElement(By.id("createNewButton")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[1]/div/div[1]/div/div/div[2]/a[5]"))
				.click();
		driver.findElement(By.id("acc2")).sendKeys("FAQ Abdul");
		driver.findElement(By.name("save")).click();
	}

	@Test(enabled = false)
	public void TC11() {
		driver.findElement(By.id("Account_Tab")).click();
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"))
				.click();
		driver.findElement(By.id("fname")).sendKeys("Personal Account");
		driver.findElement(By.id("devname")).sendKeys("XYZ");
		driver.findElement(By.name("save")).click();

	}

	@Test(enabled = true, groups = "salesforce")
	public void TC12() {
		driver.findElement(By.id("Account_Tab")).click();
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();

		Select dropDown = new Select(driver.findElement(By.name("fcf"))); // ---> this will click on the view drop down list
		dropDown.selectByIndex(4);
		// ---> It will click on the desired field in the drop down menu which is personal account in this case that we created as new earlier
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[1]")).click();
	}

	@Test(enabled = false)
	public void TC13() throws InterruptedException {

		

	}

	@Test(enabled = false)
	public void TC14() {
		System.out.println("logged out");

	}

}
