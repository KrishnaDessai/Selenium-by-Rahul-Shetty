package locators;
//video 122,123
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;//import this lib manually


public class RelativeLocator {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//relative locators are introduced from selenium 4.0
	   //RelativeLocator=>above
	   WebElement nameEditBox = driver.findElement(By.name("name"));
       System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
       
       //RelativeLocator=>below
       WebElement emailLabel = driver.findElement(By.xpath("//label[text()='Email']"));
       WebElement emailInput = driver.findElement(with(By.cssSelector("input[name='email']")).below(emailLabel));
       emailInput.sendKeys("krishnadessai8@gmail.com");

       
//		//RelativeLocator=>near - finds an <tag> that is close in the visual layout (within ~50px).
//       WebElement emailLabel = driver.findElement(By.xpath("//label[text()='Email']"));       
//       driver.findElement(with(By.tagName("input")).near(emailLabel)).sendKeys("krishnadessai8@gmail.com");

       //RelativeLocator=> toLeftOf
       WebElement iceCreamLabel =driver.findElement(By.cssSelector("[for='exampleCheck1']"));  
       driver.findElement(with (By.tagName("input")).toLeftOf(iceCreamLabel)).click();
       
       //RelativeLocator=> toRightOf
       WebElement studentRadioButton=driver.findElement(By.id("inlineRadio1"));
       WebElement studentRadiolabel=driver.findElement(with(By.tagName("label")).toRightOf(studentRadioButton));
       System.out.println(studentRadiolabel.getText());
	}

}
