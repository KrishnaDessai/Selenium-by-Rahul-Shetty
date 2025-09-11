package assignment;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-menu-item div")));
		
		// Step 3: Capture all suggestions
        List<WebElement> suggestions = driver.findElements(By.cssSelector(".ui-menu-item div"));
        System.out.println("Total suggestions: " + suggestions.size());     
        Actions action= new Actions(driver);
        for (WebElement option : suggestions) {
            if (option.getText().equalsIgnoreCase("India")) {
            	System.out.println(option.getText());
            	action.moveToElement(option).perform();
                Thread.sleep(1000);
                option.click();
                break;
            }
        }
		
		}

}
