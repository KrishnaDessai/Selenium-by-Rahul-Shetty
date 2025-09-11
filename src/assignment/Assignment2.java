package assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().fullscreen();

		//name
		driver.findElement(By.name("name")).sendKeys("Krishna");
		
		//email
		driver.findElement(By.name("email")).sendKeys("Krish2@gmail.com");
		
		//password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234qwerty");
		
		//checkbox
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		
		//static dropdown
		WebElement genderDropdown=driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender=new Select(genderDropdown);
		gender.selectByVisibleText("Female");
		
		//radio button 
		driver.findElement(By.id("inlineRadio1")).click();
		
		//calender
		driver.findElement(By.name("bday")).sendKeys("06/05/1996");

        
        //Submit button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        //Get success text and print in console
        System.out.println( driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
        
		//close browser after operations
//		driver.quit();
		

		
		
		
	}

}
