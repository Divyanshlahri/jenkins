import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automate2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\M1073013\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		
		driver.get("https://www.eazydiner.com");
//		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
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
	    
//		Thread.sleep(5000);
		
		   try {
				if(driver.findElement(By.id("webpush-onsite")).isDisplayed()){
				    driver.switchTo().frame(driver.findElement(By.id("webpush-onsite")));
					driver.findElement(By.id("allow")).click();
					driver.switchTo().defaultContent();
					}
			   }catch(Exception e ) {
				   System.out.println(" ");
			   }
		
	    driver.findElement(By.id("home-search")).sendKeys("Vista");
	    WebElement homesearch = driver.findElement(By.id("home-search"));
	    WebDriverWait wait = new WebDriverWait(driver,6);
	    wait.until(ExpectedConditions.elementToBeClickable(homesearch)).click();
	    
	    WebElement search = driver.findElement(By.xpath("//button[@id ='apxor_search'] //*[name()='path']"));
	    
	    wait.until(ExpectedConditions.elementToBeClickable(search));
	    act.moveToElement(search).click().build().perform();

//	    act.moveToElement(search).sendKeys(Keys.ENTER);
	    
	   
	    
	    if(driver.findElement(By.xpath("//h2[text()='Vista']")).getText().contentEquals("Vista")) 
	    {
	    	
	    	System.out.println("Test Case is passed");
	    	
        }
	    

	}

}
