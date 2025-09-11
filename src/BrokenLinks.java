//video 109,110,111
//automate broken link using open connection method and use of hard assertion


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver = new ChromeDriver(); 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		 //broken URL

		 //Step 1 - IS to get all url's tied up to the links using Selenium
//		String url=driver.findElement(By.cssSelector("a[href*=brokenlink]")).getDomAttribute("href");
//		HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
//		 conn.setRequestMethod("HEAD");
//		conn.connect();
//		int respCode =  conn.getResponseCode();
//		System.out.println(respCode);
		
		     List <WebElement>Links= driver.findElements(By.cssSelector(".gf-li a"));
		    
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
		    	 // System.out.println(Link.getText()+" and "+respCode);
		    	    
		    	    //skip 403 if we are using hard assertion
		    	    if (respCode == 403) {
		    	        System.out.println("Skipping forbidden link for " + Link.getText() + " : 403 Forbidden");
		    	        continue;
		    	    }

		    	    System.out.println(Link.getText() + " -> " + respCode);

               //if status code >400 then that url is not working-> link which tied to url is broken
		    	    Assert.assertTrue(respCode<400,"Status code=>"+respCode+" | This Link is Broken : " + Link.getText()+" => "+url);
////		 	        	or
		 		if(respCode>400) {
		 			System.out.println("This Link is Broken : " + Link.getText()+" => "+url);
		 	        Assert.assertTrue(false,"Broken link: " +url);
		 		}
		     }
		     
		   
		
	}

}
