import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestSliders {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new FirefoxDriver();
		
		
		driver.navigate().to("http://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 400, 0).perform();
		
		Thread.sleep(3000);
		
		action.dragAndDropBy(slider, -200, 0).perform();

		

	}

}
