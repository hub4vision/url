import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestJavaScript {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new FirefoxDriver();
		
		
		driver.navigate().to("http://www.espncricinfo.com/icc-womens-championship-2014-16/content/series/772563.html");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.partialLinkText("Series"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",
		           element, "color: red; border: 3px solid red;");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,250);");
	/*
		for(int i=0; i<=13; i++){
		((JavascriptExecutor) driver).executeScript("mopen('m"+i+"')");
		Thread.sleep(500);
		}*/

	}

}
