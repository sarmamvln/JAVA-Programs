/**
 * 
 */
package sa_workspace;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Sarma
 *
 */
public class FruitsandVegetablesSite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url3 = "https://rahulshettyacademy.com/seleniumPractise/#/";
		eCommercePractiseSite(driver, url3);
	}

	public static void eCommercePractiseSite(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Current Site under Test is " + driver.getTitle());
		System.out.println("=================================================");

		// Before method calls - Cart empty of not check
		System.out.println(driver.findElement(By.xpath("//div[@class='cart-info']")).getText());

		String[] items_needed = { "Orange", "Strawberry", "Water Melon" };
		// Method1 - Search for vegetable or Fruits and add to basket , check price to
		// discount price calulation correct, remove item form cart, promo code cehck
		// and place order check

		double total = eCommercePractiseSite_getProds(driver, items_needed);

		eCommercePractiseSite_cartflow(driver, total);

		// Before Pay - get Discount items list and the discount price

	}

	public static double eCommercePractiseSite_getProds(WebDriver driver, String[] itemsneed) {
		List<WebElement> prods = driver.findElements(By.xpath("//div[contains(@class, 'product')]/h4"));
		List<WebElement> prods_price = driver.findElements(By.xpath("//div[contains(@class, 'product')]/p"));

		
		HashMap<String, Double> map_prods = new HashMap<String, Double>();
		List itemneedList = Arrays.asList(itemsneed);
		double sum = 0.00;
		int j = 0;

		for (int i = 0; i < prods.size(); i++) {

			map_prods.put(prods.get(i).getText().split(" -")[0], Double.parseDouble(prods_price.get(i).getText()));

			if (itemneedList.contains(prods.get(i).getText().split(" -")[0])) {
				j++;
				driver.findElements(By.xpath("//div[@class='product'] //div/button[@type='button']")).get(i).click();
				// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				Assert.assertEquals(
						driver.findElements(By.xpath("//div[@class='product'] //div/button[@type='button']")).get(i)
								.getAttribute("class"),
						"added");
				sum += Double.parseDouble(prods_price.get(i).getText());
				if (j == itemneedList.size()) {

					break;

				}
			}

		}

		System.out.println(map_prods);

		System.out.println("=================================================");

		System.out.println("\n After shopping Items added to cart check cart:\n "
				+ driver.findElement(By.xpath("//div[@class='cart-info']")).getText());

		return sum;
	}

	private static void eCommercePractiseSite_cartflow(WebDriver driver, Double calcuCost) {
		// TODO Auto-generated method stub

		System.out.println("=================================================");
		System.out.println(
				"Value in cart is : " + driver.findElement(By.xpath("//table/tbody/tr[2]/td/strong")).getText());
		System.out.println("Value Expected and calcualted  by code is : " + calcuCost);
		// Assert.assertEquals(driver.findElement(By.xpath("//table/tbody/tr[2]/td/strong")).getText(),
		// Double.valueOf(calcuCost));

		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

		driver.findElement(By.xpath("//div/div[@class='action-block']/button[@type='button']")).click();

		// promocode valid- rahulshettyacademy; invalid-casesentvitcheck-
		// RahulShettyAcademy

		String coupondiscBefore = driver.findElement(By.xpath("//span[@class='discountPerc']")).getText();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

		String promomsg = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		System.out.println("Enter promo yielded in : " + promomsg);
		String coupondiscAfter = driver.findElement(By.xpath("//span[@class='discountPerc']")).getText();

		System.out.println("Discount obtained after applying coupon code is: " + coupondiscAfter);
		
		Double calctotal= calcuCost-(calcuCost*(Double.parseDouble(coupondiscAfter.split("%")[0]))/100);
		
		System.out.println("Total amount from site after discount: "+ driver.findElement(By.xpath("//span[@class='discountAmt']")).getText()+ " \n code calculated total after applying discount : " + calctotal);
		
		//Assert.assertEquals(driver.findElement(By.xpath("//span[@class='discountAmt']")).getText(), calctotal);

		/*
		 * if (promomsg.equalsIgnoreCase("Code applied ..!")) { List<WebElement>
		 * pricetablekeys = driver.findElements(By.xpath("//div/b")); List<WebElement>
		 * pricetablevalues =
		 * driver.findElements(By.xpath("//div/b/following-sibling::span"));
		 * HashMap<String, String> map_prods = new HashMap<String, String>(); for (int i
		 * = 0; i < pricetablekeys.size(); i++) {
		 * 
		 * if(i==0) { pricetablekeys.remove(i); } else {
		 * map_prods.put(pricetablekeys.get(i).getText().split(" :")[0],
		 * pricetablevalues.get(i).getText()); } }
		 * 
		 * System.out.println(map_prods);
		 * 
		 */
	}

}
