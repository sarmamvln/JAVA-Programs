/**
 * 
 */
package sa_workspace;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @author admin
 *
 */
public class Locators1 {

	/**
	 * @param args 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		//Interface is collection of similar methods with empty bodies.
		//driver invoke
		//Scanner sc = new Scanner(System.in);
	 
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		
		//Implicit Wait declaration - implicit wait waits for until the time and checks everytime element if it is found
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		//WebDriver driver= new FirefoxDriver();
		
		/*
		System.out.println("Enter browser you want to automate: \n1.Chrome\n2.Firefox\n3.IE");
		String browser= sc.next();
		sc.close();	
				
		if(browser=="Chrome" || browser=="chrome" || browser=="CHROME") 
		{	
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/");
			System.out.println(driver.getTitle());
			driver.close();
		}
		else if(browser=="Firefox" || browser=="firefox" || browser=="FIREFOX") 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
			driver= new FirefoxDriver();
			driver.get("https://rahulshettyacademy.com/");
			System.out.println(driver.getTitle());
			driver.close();
			
		}
		else if(browser=="IE" || browser=="ie" || browser=="iE") 
		{
			driver= new InternetExplorerDriver();
			driver.get("https://rahulshettyacademy.com/");
			System.out.println(driver.getTitle());
			driver.close();
		}
		
		*/
	
		 //driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		//driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		System.out.println("Titel Page for the Website under Test: " + driver.getTitle());
		System.out.println("=========================================================================");
		
		
		//Locators - ID, xpath, css selector, class, tagname, linktext, partial link text
		
		//@signin Flow
		
		/*css selector can be given 5 ways: 
		 * 1.tagname#id 
		 * 2.tagname.classname 
		 * 3.tagname[uniqueattribute='value']
		 * 4.tagname[attribute='value']:nth-child(index) - when multiple items found with the attribute
		 * 5.parenttag childtag  - by parent tag space child tag
		 * 6.parenttag[attribute*='value'] - using regular text or partial value e.g instaeda of password text*='pass'; returns all matching in page
		 * 
				
		
		*/
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("newst");
		
		driver.findElement(By.cssSelector("input[name=\"inputPassword\"]")).sendKeys("tst123");
		
		driver.findElement(By.cssSelector("button.submit")).click();
		
		String errcapt= driver.findElement(By.cssSelector("p.error")).getText();
		
		System.out.println("Error Message Captured during Incorrect login used : " + errcapt);
		System.out.println("=========================================================================");
		
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		//@forgotPassowrd flow
		/*xpath selection:     
		 *  1. //tagname[@attribute='value']
		 *  2.//tagname[@attribute='value'][index]  -by index= this can be used if selected attribute has multiple identified values
		 *  3.//parenttag/childtag[index] - index if multiple childs identified
		 *  4.//parenttag[contians(@attriabutename, 'attributevalue')] - reg ex to search all matching 
		
		
		*/
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("newst");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("newst");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1231244");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //xpath by index;
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("newst@ts.com");		
		driver.findElement(By.xpath("//form/input[3]")).clear(); // by xpath tag index
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("98838982308");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String restpwd= driver.findElement(By.cssSelector("form p")).getText();
		
		System.out.println("Message captured for Reset Password link clicked : " + restpwd.indent(5));
		
		System.out.println("=========================================================================");
		
		
		
		//@login flow
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("tets");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		
		
		//driver.close();
		driver.quit();
		
	}
	
	
	 

}
