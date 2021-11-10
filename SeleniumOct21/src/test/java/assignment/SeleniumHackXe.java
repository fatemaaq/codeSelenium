package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumHackXe {
	WebDriver driver;

	@BeforeMethod
	public void loginToXE() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(" https://www.xe.com/");
		driver.manage().window().maximize();
	}

	public void selectCurrency(String from, String to) throws InterruptedException {
		driver.findElement(By.id("midmarketFromCurrency")).click(); // ---> this will click on the "From" drop down
		WebElement dd = driver.findElement(By.id("midmarketFromCurrency"));
		dd.sendKeys(from); // ---> It will enter the USD
		driver.findElement(By.id("midmarketFromCurrency")).sendKeys(Keys.RETURN); // ---> It will enter the USD-US Dollar from dd
																					

		Thread.sleep(1000);
		System.out.println("Entered Currency in From field");

		driver.findElement(By.id("midmarketToCurrency")).click(); // ---> this will click on the "To" drop down
		driver.findElement(By.id("midmarketToCurrency")).sendKeys(to); // ---> It will send keys the INR
		driver.findElement(By.id("midmarketToCurrency")).sendKeys(Keys.RETURN); // ---> It will enter the INR- Indian Rupee from dd
																				
		System.out.println("Entered Currency in To field");

	}

	@Test
	public void currencyTest() throws InterruptedException {

		selectCurrency("USD", "CAD");
		///YAAAAAAAAAAAAAAAAAAAAAY!!
	}

}
