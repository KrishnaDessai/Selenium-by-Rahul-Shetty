package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {

		String name = "Krishna";

		WebDriver driver = new EdgeDriver();

		// implicit wait -5 seconds timeout ----implicit waits are used to show somthing
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String password = getPasssword(driver); // method call for static function
		driver.get("https://rahulshettyacademy.com/locatorspractice/");// hit the url
		driver.findElement(By.id("inputUsername")).sendKeys(name);// using "id" locater we have located the field and
																	// insert the value in it
//		driver.findElement(By.name("inputPassword")).sendKeys("");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();

		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());

		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");

		driver.findElement(By.xpath("//button[text()='Log Out']")).click();

		System.out.println("browser is getting closed because of'driver.close()'");
//        driver.close();
	}

	public static String getPasssword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String passwordArray[] = passwordText.split("'");

		// 0th index -please use temporary password
		// 1st index-rahulshettyacademy' to login
		// 2nd index- to login
//	System.out.println(passwordArray [1]);
		String password = passwordArray[1];

		return password;
	}
}

//String passwordText= driver.findElement(By.cssSelector("form p")).getText();
//String passwordArray []= passwordText.split("'");
//for(String s:passwordArray) {
//	System.out.println(s);
//}
