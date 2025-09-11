import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(2000);

		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BOM']")).click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

		
		driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i=1;
		while(i<4) { //we used this while loop to perform click operation multiple time (that is 3 times). that will select total 4 adult in dropdown
		driver.findElement(By.id("hrefIncAdt")).click();
		i++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		
		
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			
			Assert.assertTrue(true);
		}else {
			
			Assert.assertTrue(false);
		}
        
        Thread.sleep(2000);

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
