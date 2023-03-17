package sa_workspace;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browsercapa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //this helps in waituntill fully synchronized or loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		
		driver.manage().window().maximize();
		driver.navigate().to("https://google.com");//no wait is present when calling this.
		
		driver.navigate().back();
		
	}

}
