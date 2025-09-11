package assignment;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(null);
		
		driver.switchTo().window(null);
		
		Set<String> windows = driver.getWindowHandles();
		
		
		
		
		
	}

}
