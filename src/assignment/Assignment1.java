package assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver(); 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
        //Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
		driver.findElement(By.id("checkBoxOption2")).click(); 
		System.out.println(driver.findElement(By.id("checkBoxOption2")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.id("checkBoxOption2")).click(); 
		System.out.println(driver.findElement(By.id("checkBoxOption2")).isSelected());
		
		
        //How to get the Count of number of check boxes present in the page
		int checkboxSize=driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		Assert.assertEquals(checkboxSize,3);
		
		System.out.println("size:"+ checkboxSize);
		
		driver.quit();
	}

}
