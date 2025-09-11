

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {

         
		//Invoking browser
		
		//ChromeDriver driver= new ChromeDriver();
		
		//chromedriver.exe->Chrome browser's Selenium Manager
		//System.setProperty("webdriver.chrome.driver","/Users/Anup Dessai/Desktop/30-8-2024 automation_testing/chrome-headless-shell-win64.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");//to hit URL
		System.out.println("Titile is "+driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();//closes a window opened directly by url
		//driver.quit();// closes all the windows and tabs opened in the process
		
	}

}
