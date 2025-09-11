package windowAndTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");//the get() method is used to navigate to a specified URL. By default, get() will wait for the page to be fully loaded before proceeding to the next step in your script. This behavior ensures that all elements on the page are available for interaction.
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");// Part of the navigation interface that allows more complex navigation actions such as moving forward or backward in the browser history.
		driver.navigate().back();
		driver.navigate().forward();
		
		
		

	}

}
