
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Automate3 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\M1073013\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.eazydiner.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver.findElement(By.id("webpush-onsite")).isDisplayed()){
	    driver.switchTo().frame(driver.findElement(By.id("webpush-onsite")));
		driver.findElement(By.id("allow")).click();
		driver.switchTo().defaultContent();
		}
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		WebElement help = driver.findElement(By.id("help"));
		
		 jse.executeScript("arguments[0].click()", help);
		   try {
			if(driver.findElement(By.id("webpush-onsite")).isDisplayed()){
			    driver.switchTo().frame(driver.findElement(By.id("webpush-onsite")));
				driver.findElement(By.id("allow")).click();
				driver.switchTo().defaultContent();
				}
		   }catch(Exception e ) {
			   System.out.println("no");
		   }
		if(driver.findElement(By.xpath("//h1[text()='Contact Us']")).getText().equalsIgnoreCase("contact us")) {
			
			System.out.println("test is paseed 1");
			
			if(driver.findElement(By.xpath("//div[contains(@class , 'margin-t-30')] //p[2]")).getText().contains(".com")) {
				System.out.println("test is paseed");
			}
			
		}
	
		
	}
}
