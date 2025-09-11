package assignment;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		
     WebDriver driver = new ChromeDriver();
     JavascriptExecutor js=(JavascriptExecutor)driver;
     
     driver.get("https://rahulshettyacademy.com/AutomationPractice/");
     Thread.sleep(1000);
     js.executeScript("window.scrollBy(0,500)");
     
     //row count
    List<WebElement> rowCount= driver.findElements(By.cssSelector(".table-display tbody tr"));
    System.out.println("Row count "+rowCount.size());
    
    //column count
    List<WebElement> colCount= rowCount.get(0).findElements(By.tagName("th"));
    System.out.println("column count "+ colCount.size());
    
     //print second row
     WebElement cell= rowCount.get(2);
     List<WebElement> cells = cell.findElements(By.tagName("td"));
     for(WebElement rowData:cells) {
    	System.out.println(rowData.getText());
     }
     
	}

}
