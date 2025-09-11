//video 60 and 61

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCheckbox {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[1]")).click();
//		 or
//		 driver.findElement(By.xpath("//label[@for='concessionBooking']")).click();

//		 count no.of checkboxes
		int CheckboxSize = 0;
		Assert.assertFalse(CheckboxSize != 0);

		CheckboxSize = driver.findElements(By.xpath("//label[@class='css-label_c t_c']")).size();
		System.out.println(CheckboxSize);

//		AssertionError: expected [true] but found [false] 
//		Assert.assertTrue(CheckboxSize!=4);

		Assert.assertEquals(CheckboxSize, 4);
	}

}
