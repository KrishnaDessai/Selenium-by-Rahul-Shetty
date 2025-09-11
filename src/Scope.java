import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Total no. links :"+driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //limiting webdriver scope
		
		System.out.println("Total no. links present in footer :"+footerDriver.findElements(By.tagName("a")).size());
		
		WebElement footerFristSectionDriver=footerDriver.findElement(By.xpath("(//ul)[1]"));
		
		System.out.println("Total no. of links present in First Section of footer :"+footerFristSectionDriver.findElements(By.tagName("a")).size());
		
		for(int i =1;i<footerFristSectionDriver.findElements(By.tagName("a")).size();i++) {
			
			String clickOnLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER); // it acts as ctrl Enter(open in new tab)
			
			footerFristSectionDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			
		    Thread.sleep(3000);
		    
		}//open all the tabs
			Set<String>windows =driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
			while(it.hasNext())
			{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			}
		
	}

}
