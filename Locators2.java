package sa_workspace;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class Locators2 {

	
	public static void main(String[] args) throws InterruptedException {
	//System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
	//WebDriver driver=new ChromeDriver();
	
	System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
	driver.get("https://rahulshettyacademy.com/locatorspractice");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	
	String uname= "pract";
	String pwd= getrestpassword(driver);
	driver.findElement(By.cssSelector(".go-to-login-btn")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(uname);
	driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pwd);
	driver.findElement(By.id("chkboxOne")).click();
	driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
	
	
	//after success login
	Thread.sleep(1000);
	String actualtext= driver .findElement(By.tagName("p")).getText();
	 
	Assert.assertEquals(actualtext,  "You are successfully logged in.");
	
	String actualtext1=driver.findElement(By.cssSelector("//div[classname='login-container')/h2")).getText();
	
	Assert.assertEquals(actualtext1,  "Hello "+uname+",");
	
	//button identiifations
	driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	
	driver.close();
	System.out.println("End of test");
	
	}
	
	
	public static String getrestpassword(WebDriver driver) throws InterruptedException
	{
		
		//driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("newst");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("newst");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1231244");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String restpwd= driver.findElement(By.cssSelector("form p")).getText();
		
		 String[] passarr= restpwd.split("'");
		 String pass=passarr[1].split("'")[0];
		
		//System.out.println("Message captured for Reset Password link clicked : " + pass);
		
		
		return pass;
		
	}
	
	
	
}
