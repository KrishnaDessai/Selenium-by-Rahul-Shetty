//video 125
package windowAndTabs;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) {
		
		WebDriver  driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
//		driver.switchTo().newWindow(WindowType.TAB);//for new TAB
		driver.switchTo().newWindow(WindowType.WINDOW);//for new WINDOW

		Set<String>handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
//		System.out.println(courseName);
	
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.name("name")).sendKeys(courseName);
		
		


	}

}
