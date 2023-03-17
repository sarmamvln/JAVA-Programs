package sa_workspace;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		

		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		/*locators by sibling  or parent to child traverse
		 * 
		 * Absolute xpath - from top or root of html ; starts with / 
		 * Relative xpath - middle of somewhere of html; strats with //
		 * 
		 * sibling -  e.g //header/div/button[1]/following-sibling::button[1]
		 * chidl to parent- e.g //header/div/button[1]/parent::div/parent::header/a
		 * 
		 * 
		 */
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		
		
	}

}
