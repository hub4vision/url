import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestKeyboardEvents {

	
	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		
		
		driver.navigate().to("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.findElement(By.id("Email")).sendKeys("sdfdsf");
		driver.findElement(By.id("Passwd")).sendKeys("sdfdsf");
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]")).click();
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		driver.findElement(By.xpath("//*[@id='Email']")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
	//	action.sendKeys(Keys.ENTER).perform();
		
		
		
		

	}

}
