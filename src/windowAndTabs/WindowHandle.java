package windowAndTabs;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		// this will get Id's of all your tabs/windows opened by automation
		Set<String> windows= driver.getWindowHandles(); //[parentId,childId,.....]-> depending on no. of tabs/windows the child/subchild  will increase 
		
//		System.out.println(windows);
		Iterator<String>it =windows.iterator();
		String parentID =it.next();//1st window(parent window)
		String childID =it.next();//2nd window
		driver.switchTo().window(childID);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		
		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
		

	}

}
