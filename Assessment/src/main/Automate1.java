import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Automate1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\M1073013\\msedgedriver.exe");
	
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.eazydiner.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   try {
				if(driver.findElement(By.id("webpush-onsite")).isDisplayed()){
				    driver.switchTo().frame(driver.findElement(By.id("webpush-onsite")));
					driver.findElement(By.id("allow")).click();
					driver.switchTo().defaultContent();
					}
			   }catch(Exception e ) {
				   System.out.println(" ");
			   }
		
	
		WebElement city = driver.findElement(By.id("main-city"));
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].click()", city);
//		act.moveToElement(city).click().build().perform();
	    List<WebElement> list = driver.findElements(By.xpath("//div[@id = 'search_city_content'] //ul[@class='list']//li"));
	    Iterator<WebElement> it = list.iterator();
	    int size = list.size();
	    Actions act = new Actions(driver);
	    for(int i =0;i<=size;i++) {
	    	if(it.hasNext()) {
	    		WebElement location = it.next();
	    	if(location.getText().contains("Mumbai")) {
	    		
	    		
	    		act.moveToElement(location).click().build().perform();
	    		
	    		break;
	    	}
	    		
	    	}
	    }
	    
		   try {
				if(driver.findElement(By.id("webpush-onsite")).isDisplayed()){
				    driver.switchTo().frame(driver.findElement(By.id("webpush-onsite")));
					driver.findElement(By.id("allow")).click();
					driver.switchTo().defaultContent();
					}
			   }catch(Exception e ) {
				   System.out.println(" ");
			   }
	    WebElement book = driver.findElement(By.xpath("//span[text()='Book a Table']"));
	    act.moveToElement(book).click().build().perform();
	    
	    if(driver.findElement(By.tagName("h1")).getText().contains("Mumbai")) {
	    	System.out.println("Test case is passed");
	    }
	}

}
