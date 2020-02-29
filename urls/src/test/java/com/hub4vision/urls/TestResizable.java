package com.hub4vision.urls;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestResizable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		
		
		driver.navigate().to("http://jqueryui.com/resources/demos/resizable/default.html");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		WebElement slider = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 100, 300).perform();
		
		
	

	}

}
