//implicit wait
// reffer video no. 71,72,73,74,75
//implicit and explicit 80,,81
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GreenKartShoppingSiteDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Explicit Wait
		WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

		
		String[] itemNeeded = { "Cucumber", "Brocolli", "Beetroot", "Tomato", "Brinjal" };

//		by creating object 
//		GreenKartShoppingSiteDemo gkssd = new GreenKartShoppingSiteDemo();
//		gkssd.addItem(driver,itemNeeded,);

//		using static method
		addItem(driver, itemNeeded,explicitWait);

	}

	public static void addItem(WebDriver driver, String[] itemNeeded,WebDriverWait explicitWait) {

		List<WebElement> products = (List<WebElement>) driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			// Brocolli

//			System.out.println( products.get(i).getText());

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// format it to get actual vegetable name
			// convert array into array list for easy search
			// check whether name you extracted is present in array list or not

			List itemNeededList = Arrays.asList(itemNeeded);

			int j = 0;

			if (itemNeededList.contains(formattedName)) {

				j++;

				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();

				if (j == itemNeeded.length) {
					break;
				}
			}

		}

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

//		unsuccessful
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshetty");

		driver.findElement(By.cssSelector("button.promoBtn")).click();
//		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		String invalidCode = driver.findElement(By.cssSelector("span.promoInfo")).getText();

		if (invalidCode != "rahulshettyacademy") {

			driver.findElement(By.xpath("//input[@class='promoCode']")).clear();
//			successful
			driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
			
			driver.findElement(By.cssSelector("button.promoBtn")).click();
			

		}
				
		//Explicit Wait
//		WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.promoInfo"),"Code applied ..!"));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		WebElement dropdown = driver.findElement(By.tagName("select"));

		Select select = new Select(dropdown);
		select.selectByVisibleText("India");

		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}
}
