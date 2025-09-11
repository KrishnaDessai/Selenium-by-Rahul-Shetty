import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int sum = 0;
		//page scroll
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		//component scroll
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
		
		List<WebElement> value = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(WebElement val:value) {
			sum+=Integer.parseInt( val.getText());
		}
//		System.out.println(sum);
		int displayedCalculation=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());		
		Assert.assertEquals(sum, displayedCalculation);
	}

}
