package com.hub4vision.urls;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestRightClick {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		
		
		driver.navigate().to("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	
		WebElement image = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));

		
		Actions action = new Actions(driver);
		action.contextClick(image).perform();
		
	}

}
