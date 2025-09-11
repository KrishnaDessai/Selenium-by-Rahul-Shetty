//video 126

package uxValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class captureDimention {


		public static void main(String[] args) {

			WebDriver  driver= new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			WebElement name = driver.findElement(By.name("name"));
						
			//get height and width of the input box of "Name"
			System.out.println("height: "+name.getRect().getDimension().getHeight());
			System.out.println("Width: "+name.getRect().getDimension().getWidth());
			
			

		

		
	}

}
