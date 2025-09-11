//video 112
//Automate broken link using soft assertion
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinkSoftAssertion {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver = new ChromeDriver(); 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		 //broken URL
		
		     List <WebElement>Links= driver.findElements(By.cssSelector(".gf-li a"));
		     
		     SoftAssert softAssert = new SoftAssert();
		     
		     for (WebElement Link:Links) {
		    	 String url=Link.getDomAttribute("href");
		    	 if (url == null || url.isEmpty() || url.startsWith("javascript") || url.equals("#")) {
		    	        System.out.println("invalid link(Skipping)=> "+ Link.getText() +" : "+ url);
		    	        continue;
		    	    }
		    	 
		 		//Java methods will call URL's and gets you the status codes
		    	 HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		    	    conn.setRequestMethod("HEAD");
		    	    conn.connect();
		    	    int respCode = conn.getResponseCode();

		    	    System.out.println(Link.getText() + " -> " + respCode);

               //if status code >400 then that url is not working-> link which tied to url is broken
		    	    softAssert.assertTrue(respCode<400,"Status code=>"+respCode+" | This Link is Broken : " + Link.getText()+" => "+url);
		     }
		     
		     softAssert.assertAll();
		
	}

}
