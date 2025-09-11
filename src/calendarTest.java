import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class calendarTest {

	public static void main(String[] args) throws InterruptedException {
		
		String date="15";
		String monthNumber="10"; //October
		String year="2027";
		String expectedList[] = {monthNumber,date,year};
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".react-calendar__tile")).get(Integer.parseInt(monthNumber)-1).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
        List<WebElement> actualList = driver.findElements(By.className("react-date-picker__inputGroup__input"));
		for(int i=0;i<actualList.size();i++) {
			System.out.println(actualList.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
		}
	}

}
