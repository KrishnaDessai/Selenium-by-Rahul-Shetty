import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

//      // Time used to put captcha manually
//		Thread.sleep(10000);
		
//		// Open a new tab
//		driver.switchTo().newWindow(WindowType.TAB);
//		// Navigate to the second URL in the new tab
//		driver.get("https://www.amazon.com");

		//Explicit waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
		Actions a = new Actions(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"span.a-button.a-spacing-top-base.a-button-base.glow-toaster-button.glow-toaster-button-dismiss")));
		driver.findElement(By.cssSelector(
				"span.a-button.a-spacing-top-base.a-button-base.glow-toaster-button.glow-toaster-button-dismiss"))
				.click();

		a.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search Amazon']"))).click()
				.keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		// Hover to specific element
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
				a.moveToElement(move).contextClick().build().perform();

	}

}
