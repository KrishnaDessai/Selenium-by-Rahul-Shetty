
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i = 1;
		while (i < 4) { // we used this while loop to perform click operation multiple time (that is 3
						// times). that will select total 4 adult in dropdown
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {

			System.out.println("Its enabled");
//			Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style"),"display: block; opacity: 1;");

			Assert.assertTrue(true);
		} else {
			System.out.println("Its disabled");
//			Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style"),"display: block; opacity: 0.5;");
			Assert.assertTrue(false);
		}

//		driver.quit();

	}

}
