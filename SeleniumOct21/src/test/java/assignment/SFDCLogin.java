package assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCLogin {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver;
		
        WebDriverManager.firefoxdriver().setup(); //install Webdriver Manager
		driver = new FirefoxDriver();
		
		case1_LoginErrorMessage();
		case2_LoginToSalesForce();
		case3_CheckRememberMe();
		case4A_ForgotPassword();
		case4B_ForgotPassword();
		
		driver.quit();

	}

	static public void case1_LoginErrorMessage() throws InterruptedException{

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("fatemaaq@gmail.com");
		Thread.sleep(7000);
		
		//driver.findElement(By.xpath("//*[@id= 'login']/a/span")).click();---> this approach is not working
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		Thread.sleep(7000);
		
	}
	
	
	static public void case2_LoginToSalesForce () throws InterruptedException {
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("username")).sendKeys("fatemaaq@gmail.com");
		driver.findElement(By.id("password")).sendKeys("FainFain12");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		Thread.sleep(7000);
		
	}

	static public void case3_CheckRememberMe() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("username")).sendKeys("fatemaaq@gmail.com");
		driver.findElement(By.id("password")).sendKeys("FainFain12");
		
		driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/label")).click(); //This will click on the check box which says remember me
		Thread.sleep(7000);
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		Thread.sleep(7000);
		
		}
	
	
	static public void case4A_ForgotPassword() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("forgot_password_link")).click();
		Thread.sleep(7000);
		
		WebElement Continue = driver.findElement(By.id("un"));
		Thread.sleep(7000);
		Continue.sendKeys("fatemaaq@gmail.com");
		Thread.sleep(7000);
		Continue.click();

		Thread.sleep(5000);
	}
	
	
	static public void case4B_ForgotPassword() throws InterruptedException {
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		WebElement errorLogin = driver.findElement(By.id("username"));
		errorLogin.sendKeys("123");
		
		WebElement errorPswrd = driver.findElement(By.id("password"));
		errorPswrd.sendKeys("22131");
		
		Thread.sleep(5000);
		
		WebElement loginError = driver.findElement(By.id("Login"));
		loginError.click();
		
		
		Thread.sleep(5000);
		
		
	}
	
}


