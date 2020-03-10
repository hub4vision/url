import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestExplicitWait {

	
	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://gmail.com");
		
		driver.findElement(By.id("Email")).sendKeys("sdfdsf");
		
		//WebDriverWait wait = new WebDriverWait(driver, 30L);
	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(10, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class)
			       .withMessage("setting the time out as 10seconds");

		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Paswd"))).sendKeys("sdfdsfd");
		
	


	}

}
