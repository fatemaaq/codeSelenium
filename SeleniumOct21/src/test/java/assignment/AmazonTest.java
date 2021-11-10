package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void launchAmazon() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		WebElement w = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
		a.moveToElement(w).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.id("nav-al-signin")).click();
		driver.findElement(By.id("ap_email")).sendKeys("xxxxxxxxxxx"); //I used my login id here
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("xxxxxx"); //I used my password
		driver.findElement(By.id("signInSubmit")).click();
	}
	
	
	@Test
	public void testAmazon() throws InterruptedException
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("kindle");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("B08KTZ8249-amazons-choice-label")).click();
		String name = driver.findElement(By.id("productTitle")).getText(); //gives us text see in the console
		System.out.println(name);
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[1]/div[3]/div/a[5]/div[2]/span[2]")).click();
		driver.findElement(By.linkText(name)); // This is passed. If here I give something else than "name" it fails. 
		                                         //So this verifies the product being in the cart 
		
		// YAAAAAAAAAAYYYYY
	}
}
