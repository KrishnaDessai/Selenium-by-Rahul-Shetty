package evidenceCapture;
//video 107,108
//maximize window , delete cookies ,take screenshot

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//delete all cookies
		driver.manage().deleteAllCookies();

//		delete particular cookie by providing its name 
//		driver.manage().deleteCookieNamed("sessionKey");
		
		
		driver.get("http://google.com");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(".\\screenshots\\screenshot.png");
        FileUtils.copyFile(sourceFile, targetFile);
		

	}

}
