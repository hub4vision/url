import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class TestSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		//driver.get("http://gmail.com");
		driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.navigate().to("http://gmail.com");
		
	/*	Options manage = driver.manage();
		Window win = manage.window();
		win.maximize();*/
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
	/*	WebElement element = driver.findElement(By.id("Email"));
		element.sendKeys("trainer@way2automation.com");

		element = driver.findElement(By.xpath("//*[@id='Passwd']"));
		element.sendKeys("dsfsdf");
		
		element = driver.findElement(By.name("signIn"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id='errormsg_0_Passwd']"));
		System.out.println(element.getText());*/
		
		driver.findElement(By.id("Email")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id='Paswd']")).sendKeys("dsfsdf");
		driver.findElement(By.name("signIn")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='errormsg_0_Passwd']")).getText());
		
	}

}
