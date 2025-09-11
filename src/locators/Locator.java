package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver();
		
		// implicit wait -5 seconds timeout ----implicit waits are used to show somthing
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");//hit the url
		
		driver.findElement(By.id("inputUsername")).sendKeys("krishna");//using "id" locater we have  located the field and insert the value in it
		
		driver.findElement(By.name("inputPassword")).sendKeys("admin");
		
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
	
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		
		//when application is changing views we might run into interception error to overcome that problem we applied wait and after that it is working as expected
		
		Thread.sleep(1000);//used so that something can get in stable state 
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("krishna");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("krish@gmail.com");
//		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
//		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("krishna@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("984672970");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		String passwordText= driver.findElement(By.cssSelector("form p")).getText();
		
		
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("krishna");
//		driver.findElement(By.cssSelector("//inputUsername")).sendKeys("krishna");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");//regular expression for css selector
		
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
		
		
	}

}
