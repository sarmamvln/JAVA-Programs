package sa_workspace;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assignement {

	private static Logger log=  (Logger) LogManager.getLogger(Assignement.class.getName());
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException{
		// TODO Auto-generated method stub

		log.info("Browser Setting up");
		FirefoxOptions ffopt= new FirefoxOptions();
		ffopt.setAcceptInsecureCerts(true);  ///accepting insecure Certifictions
		
		//Proxy prox=new Proxy();
		//prox.
		
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(ffopt);

		//String url = "https://rahulshettyacademy.com/AutomationPractice/";
		 //assignement1CheckboxExercise(driver, url, log);
		//String url2 = "https://rahulshettyacademy.com/angularpractice/";
		// assignement2DropboxEditboxErrorvalExercise(driver, url2);
		//String url3 = "https://rahulshettyacademy.com/loginpagePractise/";
		//assignement3SynchronizationwithExplicitwait(driver, url3);
		//String url4 = "https://the-internet.herokuapp.com";
		//assign4WindowHandling(driver, url4);		
		//assign5FramesHandling(driver, url4);	
		//String url5 = "https://rahulshettyacademy.com/AutomationPractice/";
		//assign6DynamicTestWriterPractise(driver, url5);
		//String expcert = "https://expired.badssl.com/";
		
		//assign7WebTableAssign(driver, url5);
		
		//assign8AutoCompletedropdownAssign(driver, url5);
		
		//driver.get(url5);
		//String xpathoflinks="//li[@class='gf-li']/a";
		//brokenLinkCheckcall(driver, xpathoflinks);
		//String url6 = "https://rahulshettyacademy.com/seleniumPractise/#/";
		//streamAssignments(driver, url6);
		

	}

	public static void assignement1CheckboxExercise(WebDriver driver, String url, Logger log) {

		driver.get(url);
		log.info("Browser lauched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		log.info("Waiting for elementes");
		System.out.println("Current Site under Test is " + driver.getTitle());
		System.out.println("=================================================");

		System.out.println(
				"Total Number of Checkboxes :" + driver.findElements(By.cssSelector("input[id*=check]")).size());
		log.info("Found elementes");
		System.out.println("Before State of Checkbox1: "
				+ driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		log.debug("checkbox element clicked");
		System.out.println("Check and verify state of Checkbox1: "
				+ driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());

		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		log.debug("checkbox element clicked to deselect");
		System.out.println("Clear Checkmark after Checking and verify state of Checkbox1: "
				+ driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());

		log.info("End of Test");
		driver.close();		
		System.out.println("End of Assignement1");
		System.out.println("=================================================");

	}

	public static void assignement2DropboxEditboxErrorvalExercise(WebDriver driver, String url)
			throws InterruptedException {

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Current Site under Test is " + driver.getTitle());
		System.out.println("=================================================");

		driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("test");
		driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys("a");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		if (driver.findElement(By.xpath("//div/input[@name='name']")).getAttribute("class").contains("ng-invalid")) {

			System.out.println(
					driver.findElement(By.xpath("//div/input[@name='name']/following-sibling::div")).getText());
			Assert.assertFalse(false);

		} else {
			driver.findElement(By.xpath("//div/input[@type='password']")).sendKeys("new12423");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			if (driver.findElement(By.xpath("//div/input[@name='email']")).getAttribute("class")
					.contains("ng-invalid")) {

				System.out.println(driver.findElement(By.xpath("//div/input[@name='email']/following-sibling::div"))
						.getText().toUpperCase());
				Assert.assertFalse(false);
			}

			else {

				driver.findElement(By.xpath("//div/input[@type='checkbox']")).click();

				Select s = new Select(driver.findElement(By.id("exampleFormControlSelect1")));

				// System.out.println("Intial selected value is " +
				// s.getFirstSelectedOption().getText());
				// System.out.println(s.getOptions());
				s.selectByVisibleText("Female");
				// System.out.println("selected value is " + s.getAllSelectedOptions());

				List<WebElement> opt = driver
						.findElements(By.xpath("//input[contains(@type, 'radio')]/following-sibling::label"));

				for (int i = 0; i < opt.size(); i++) {
					if (opt.get(i).getText().equalsIgnoreCase("student")) {
						driver.findElement(By.xpath(
								"//input[contains(@type, 'radio')]/following-sibling::label/parent::div/input[@id='inlineRadio1']"))
								.click();
						System.out.println("Selected valus is :" + opt.get(i).getText());
						System.out.println("Radio button selected or not boolean checkpoint: " + driver.findElement(By
								.xpath("//input[contains(@type, 'radio')]/following-sibling::label/parent::div/input[@id='inlineRadio1']"))
								.isSelected());
						break;
					}

				}

				driver.findElement(By.xpath("//div/input[@type='date']")).sendKeys("02/10/2010");

				driver.findElement(By.xpath("//input[@type='submit']")).click();

				String afsubmmsg2 = driver.findElement(By.cssSelector("div.alert")).getText().replace("×", "");

				// String afsubmmsg =
				// driver.findElement(By.xpath("//div/a[@class='close']/parent::div")).getText();

				Assert.assertEquals(afsubmmsg2, "Success! The Form has been submitted successfully!.");

			}
		}

		driver.close();
		System.out.println("End of Assignement2");
		System.out.println("=================================================");
	}

	public static void assignement3SynchronizationwithExplicitwait(WebDriver driver, String url) {
		driver.get(url);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Current Site under Test is " + driver.getTitle());
		System.out.println("===========================================================================");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String[] cred = assign3loginExtracter(driver).split("~");
		assign3loginFlow(driver, wait, cred[0], cred[1]);
		// System.out.println("After Success Login Site under Test is " +
		// driver.getTitle());
		// System.out.println("===========================================================================");
		assign3PostLoginFlow(driver, wait);

	}

	public static String assign3loginExtracter(WebDriver driver) {
		List<WebElement> loginCred = driver.findElements(By.xpath("//div/p[contains(@class, 'text-white')]/b/i"));
		String uname = loginCred.get(0).getText();
		String pwd = loginCred.get(1).getText();
		// System.out.println("Username Extracted is : "+ uname);
		// System.out.println("Password Extracted is : "+ pwd);

		return uname + "~" + pwd;

	}

	public static void assign3loginFlow(WebDriver driver, WebDriverWait wait, String username, String Password) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);

		driver.findElement(By.xpath("//input[@value='user']/parent::label/span[@class='checkmark']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='okayBtn']"))).click();
		// driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//select[@class='form-control']/option")));
		List<WebElement> dropdownopt = driver.findElements(By.xpath("//select[@class='form-control']/option"));
		for (int i = 0; i < dropdownopt.size(); i++) {
			if (dropdownopt.get(i).getText().equalsIgnoreCase("consultant")) {
				dropdownopt.get(i).click();
				driver.findElement(By.xpath("//input[@id='terms']")).click();
				driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
				if (driver.findElement(By.cssSelector("div.alert")).getAttribute("style")
						.equalsIgnoreCase("display: block;")) {
					System.out.println(driver.findElement(By.cssSelector("div.alert")).getText());
					break;
				}

				break;
			}
			// wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
			// wait.until(ExpectedConditions.titleIs("ProtoCommerce"));
		}

	}

	public static void assign3PostLoginFlow(WebDriver driver, WebDriverWait wait) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h4/a")));
		List<WebElement> prods = driver.findElements(By.xpath("//div[@class='card-body']/h4/a"));
		// List<WebElement> prods_price =
		// driver.findElements(By.xpath("//div[@class='card-body']/h5"));

		for (int i = 0; i < prods.size(); i++) {

			driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();

		}

		driver.findElement(By.xpath("//div[@id='navbarResponsive']/ul/li/a")).click();
		// driver.findElement(By.xpath("//td[@class='text-right']")).getText();
		System.out.println("Total amount at checkout is  : "
				+ driver.findElement(By.xpath("//td[@class='text-right']")).getText());

	}
	
	
	public static void assign4WindowHandling(WebDriver driver, String url)
	{
		driver.get(url);
		System.out.println("Site under test: "+ driver.getTitle());
		System.out.println("=======================================================");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Linkundertest="Multiple Windows";			
		assign4AutomateclickLink(driver, Linkundertest);
		assign4PostMultiwindowClick(driver);
				
	}
	
	public static void assign4AutomateclickLink(WebDriver driver, String test)
	{
		List<WebElement> AllLinks=driver.findElements(By.xpath("//li/a"));
		Actions act=new Actions(driver);
		
		for(int i=0;i<AllLinks.size(); i++)			
		{
			if(AllLinks.get(i).getText().equalsIgnoreCase(test))				
			{
				act.scrollToElement(AllLinks.get(i)).pause(10);
								
				AllLinks.get(i).click();
				
				break;
			}
		}
		
	}
			
	public static void assign4PostMultiwindowClick(WebDriver driver)
		{
			//System.out.println(driver.findElement(By.xpath("//h3")).getText());
			driver.findElement(By.xpath("//div[@class='example']/a")).click();
			Set<String> winhand=driver.getWindowHandles();
			Iterator<String> winite=winhand.iterator();
			String parent=winite.next();
			String child=winite.next();
			driver.switchTo().window(child);			
			System.out.println(driver.findElement(By.xpath("//h3")).getText());
			driver.switchTo().window(parent);
			System.out.println(driver.findElement(By.xpath("//h3")).getText());
				
			
		}
	
	public static void assign5FramesHandling(WebDriver driver, String url)
	{
		driver.get(url);
		System.out.println("Site under test: "+ driver.getTitle());
		System.out.println("=======================================================");
		String Linkundertest="Nested Frames";
		assign4AutomateclickLink(driver, Linkundertest);
		assign5PostNestedFrameClick(driver);
		
	}
	public static void assign5PostNestedFrameClick(WebDriver driver)
	{
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@frameborder='1']/frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
		

		/*
		 * List<WebElement> frmelist =driver.findElements(By.xpath("//frameset[@frameborder='1']/frame"));		
		System.out.println("Total available Frames: " + frmelist.size());		
		
		for(int i=0; i<frmelist.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> frmesublist =driver.findElements(By.xpath("//frame[contains(@src, 'frame')]"));
			System.out.println("Frame Name: " + frmelist.get(i).getText());
			System.out.println("Frame Name By Attribute: " + frmelist.get(i).getAttribute("name"));
			System.out.println("Total available Sub Frames under parent Frame " + frmelist.get(i).getText() + " is: " +frmesublist.size() );
			
			for(int j=0;j<frmesublist.size();j++)
			{
				driver.switchTo().frame(j);
				System.out.println("Frame Name: " + frmelist.get(j).getText());
				System.out.println("Frame Name By Attribute: : " + frmelist.get(j).getAttribute("name"));
				if(driver.findElement(By.xpath("//body/div[@id='content']")).getText().equalsIgnoreCase("middle"))
				{
					System.out.println("driver.findElement(By.xpath(\"//body/div[@id='content']\")).getText()");
				}
				
			}
			
			
		}
		*/
	
		
	}
		

	public static void assign6DynamicTestWriterPractise(WebDriver driver, String url)
	{
		driver.get(url);
		System.out.println("Site under test: "+ driver.getTitle());
		System.out.println("=======================================================");
		
		List<WebElement> chkl= driver.findElements(By.xpath("//div[@id='checkbox-example'] //label"));
		//System.out.println("Checkbox size : " + chkl.size());
		Random ran= new Random();
		int randoptsel=ran.nextInt(1,chkl.size()); //for getting random number so to select the checkbox
		String optvalue= chkl.get(randoptsel-1).getText(); 
		
		System.out.println("The element at position "+randoptsel+ " is:  " +optvalue);
		String chboxxp= "(//div[@id='checkbox-example'] //label)["+randoptsel+"]/input";
		//click teh corresponding checkbox and select the dropdown	
		 driver.findElement(By.xpath(chboxxp)).click();
		 
		 //driver.findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
		 List<WebElement> dropl=driver.findElements(By.xpath("//select[@id='dropdown-class-example'] //option"));
		 for(int i=0;i<dropl.size();i++)
		 {
			 if(dropl.get(i).getText().equalsIgnoreCase(optvalue))
			 {
				 dropl.get(i).click();
				 break;				 
			 }
		 }
		
		 driver.findElement(By.xpath("//input[@id='name']")).sendKeys(optvalue);
		 driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		 driver.switchTo().alert().getText();		
		 System.out.println("Captured and processed Alert text to disply only entered Name is: " + driver.switchTo().alert().getText().split(" ")[1]  );
		 driver.switchTo().alert().accept();
		 
		/*
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=4000 ");
		
		*/
	}

	public static void assign7WebTableAssign(WebDriver driver, String url)
	{
		driver.get(url);
		System.out.println("Site under test: "+ driver.getTitle());
		System.out.println("=======================================================");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");
		
		driver.findElement(By.xpath("//table[@name='courses']/tbody"));
		
		int rowcount =driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
		int colcount =driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();
		System.out.println("Total Rows Count in Table:  "+ rowcount);
		System.out.println("Total Column Count in Table:  "+ colcount);
		
		int recindex=2;
		
		for(int i=1; i <rowcount; ++i)
		{
			if(i==recindex)
			{
				System.out.println( recindex + "th Row details are :");
				String reqdetxpath="(//table[@name='courses']/tbody/tr)["+(i+1)+"]/td";
				List<WebElement> rodet=driver.findElements(By.xpath(reqdetxpath));
						for(WebElement each:rodet)
						{
							System.out.print(each.getText() +"\t");
						}
						break;
						
			}
		}
			
	}

	public static void assign8AutoCompletedropdownAssign(WebDriver driver, String url)
	{
		driver.get(url);
		System.out.println("Site under test: "+ driver.getTitle());
		System.out.println("=======================================================");
		String wanin="united States (USA)";
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("un");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ui-menu-item']/div")));
		Actions a=new Actions(driver);
		
		List<WebElement> sugglist=driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		
		for(WebElement eahc:sugglist)
		{
			if(eahc.getText().equalsIgnoreCase(wanin))				
			{	
				
				a.clickAndHold(eahc).build().perform();
				//a.scrollToElement(eahc).build().perform();
				//eahc.sendKeys(Keys.ARROW_DOWN);
				System.out.println("Selected element Text is dispalyed in Text area or not Check : ");
				System.out.println(driver.findElement(By.xpath("//input[@id='autocomplete']")).getText());
				a.release();
				break;
			}
		}
		
		}
	
	public static void takeScreenshot(WebDriver driver) throws IOException	
	{
	  
		File ima	=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ima, new File("D://fromJavascreenshot.png"));
	}


	public static void brokenLinkCheckcall(WebDriver driver,  String xpathofalllinks) throws MalformedURLException, IOException
	{
		
		List<WebElement> linkslist=driver.findElements(By.xpath(xpathofalllinks));
		SoftAssert soa=new SoftAssert();
		Hashtable<String, Integer> linkstatusmap=new Hashtable<String, Integer>();
		
		System.out.println(linkslist.size());
		
		for(WebElement link:linkslist)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
			conn.connect();
			//int respcode=conn.getResponseCode();
			
			linkstatusmap.put(url, conn.getResponseCode());  //to get url and responsecode
			//soa.assertTrue(respcode<400, "the broken links is "+url);
						
		}
		
		System.out.println(linkstatusmap.size());
		System.out.println(linkstatusmap);
		
	}
	
	public static void streamAssignments(WebDriver driver, String url)
	{
		/*
		List<Integer> names1=Arrays.asList(3,2,2, 7,1,5,9,7);
		
		//print unique number from the array
		
		 names1.stream().distinct().forEach(s->System.out.print(s +"\t"));
	 
		 System.out.println();
		//sort array and get only 3rd index value
		int l= names1.stream().distinct().sorted().toList().get(2);
	 System.out.println("Sorted and value at index 2 is : " +l);
	 
	 */
		
		driver.get(url);
		System.out.println("Site under test: "+ driver.getTitle());
		System.out.println("=======================================================");
		
		driver.findElement(By.xpath("(//div[@class='cart']/a)[2]")).click();
		 
		List<WebElement> prName= driver.findElements(By.xpath("(//tr/td)[1]"));
	}
	
}
	
	
	
	
