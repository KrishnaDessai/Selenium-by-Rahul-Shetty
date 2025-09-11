package assignment;
//Explicit wait (that is "WebDriverWait") is used here
import java.lang.reflect.Array;
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

public class Assignment3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Explict Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Login
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

		// Wait for modal pop up to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-footer")));
		
		// or
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancelBtn")));
		// Interact with the modal buttons
		WebElement okButton = driver.findElement(By.id("okayBtn"));
		okButton.click();

		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));

		Select option = new Select(dropdown);
		option.selectByValue("consult");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.linkText("terms and conditions")).click();

		System.out.println(driver.findElement(By.linkText("terms and conditions")).getText());

		driver.findElement(By.id("signInBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("container")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("app-card")));

		// Fetch all product cards

//		List<WebElement> mobileList= driver.findElements(By.xpath("//button[text()='Add ']"));
//		List<WebElement> mobileList= driver.findElements(By.cssSelector("app-card.col-lg-3.col-md-6.mb-3"));

		// title
		List<WebElement> mobileTitle = driver.findElements(By.cssSelector("h4.card-title"));

		for (int i = 0; i < mobileTitle.size(); i++) {
			// Find and click the corresponding "Add" button for the product
			driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();

		}

		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

		System.out.println("All desired products have been added to the cart.");
//		  driver.quit();

	}

}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//...............code if u want to select only the desired product using array................................................

// Products you want to add
//String[] mobileArray = { "iphone", "Samsung", "Nokia", "Blackberry" };
//List<String> mobileNeedList = Arrays.asList(mobileArray);

//for (int i = 0; i < mobileTitle.size(); i++) {
//	System.out.println(mobileTitle.get(i).getText());
//	String productName = mobileTitle.get(i).getText().split(" ")[0].trim();

//	System.out.println( productName);

//	int j = 0;

// Check if the product is in the desired list
//	if (mobileNeedList.contains(productName)) {
//		j++;
//		
//		driver.findElement(By.xpath("//button[text()='Add ']")).click();   //select 1st product multiple time

// Find and click the corresponding "Add" button for the product
//		driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();

//		if (j == mobileArray.length) {
//			break;
//		}
//	}
