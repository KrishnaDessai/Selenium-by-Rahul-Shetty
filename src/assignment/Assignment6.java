package assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		
		String checkboxText =driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();

		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));

		Select select = new Select(dropdown);
				

		// Now select, after trimming

		select.selectByVisibleText(checkboxText);
		
		
		driver.findElement(By.id("name")).sendKeys(checkboxText);
		
		driver.findElement(By.id("alertbtn")).click();
//		System.out.println(driver.switchTo().alert().getText());
		String alertText = driver.switchTo().alert().getText();
		
		String parts = alertText.split(" ")[1].replace(",", "");
		System.out.println(parts);
		
		if(alertText.contains(checkboxText)) {
			 System.out.println("Alert message success");
		}else {
		    System.out.println("Something wrong with execution");

		}
//		driver.switchTo().alert().accept();

		

		
		
	}

}
