package sa_workspace;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class dropdownPract7 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//String url="https://rahulshettyacademy.com/dropdownsPractise/";
		//String url2_dropdown_pract= "https://rahulshettyacademy.com/seleniumPractise/#/";
		String url2="https://phptravels.com/demo/";
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get(url2); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
		//#Selecting a site and noting hte USername password for login to it
		
		System.out.println("Enter which site to test : "+"\n1.Customer\n2.Agent\n3.Admin\n4.Supplier");
		Scanner sc = new Scanner(System.in);
		String stu= sc.next();
		sc.close();
		
		List<WebElement> opt=driver.findElements(By.xpath("//div/h3[contains(@class, 'text-left')]/strong"));
		List<WebElement> nurl=driver.findElements(By.cssSelector("a.btn-block small"));
		
		HashMap<String, String> va=new HashMap<String, String>();
		
		 for(int i=0; i<opt.size(); i++) {
			 va.put(opt.get(i).getText(), nurl.get(i).getText());
		 }
		 
		
		System.out.println(va);
		
		
		
		if(stu.equalsIgnoreCase("customer")){
			

			String nuname=driver.findElement(By.xpath("//div[@class='col-md-10']/strong[1]/following-sibling::br")).getText();
			String npwd=driver.findElement(By.xpath("//div[@class='col-md-10']/strong[2]/following-sibling::br")).getText();
			
			
			//System.out.println(nuname);
			//System.out.println(npwd);
			
			driver.navigate().to(va.get(stu));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			System.out.println(driver.getTitle());
			
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(nuname);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(npwd);
			driver.findElement(By.xpath("//div/button/span[@class='ladda-label']"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		
		}
	
			
				
}
}

