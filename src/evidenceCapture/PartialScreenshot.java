//video 125
package evidenceCapture;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialScreenshot {

	public static void main(String[] args) throws IOException {

		WebDriver  driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//taking screenshot of required WebElement
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("partial Screenshot");
		File sourcefile =name.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(".\\screenshots\\logo.png");

		FileUtils.copyFile(sourcefile, targetFile);//don't forget to refresh package to see the screenshot
		
	
		

	}

	
}
