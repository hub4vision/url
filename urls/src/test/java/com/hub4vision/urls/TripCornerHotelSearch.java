package com.hub4vision.urls;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TripCornerHotelSearch extends Library{
	
	public static String websiteURL = "https://tripcorner.com/";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		new Library();
		Library.driver.get(websiteURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[contains(text(),'Hotels')]")).click();
		driver.findElement(By.xpath("//div[@class='form-group']//button[@class='btn btn-primary btn-block btn-primary-search'][contains(text(),'Search')]")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		WebElement element = driver.findElement(By.xpath("//input[@id='CityFrom']"));
		element.sendKeys("delhi");
		Thread.sleep(3000);
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		
		element = driver.findElement(By.xpath("//input[@id='checkInDate']"));
		element.getText();
		System.out.println(element.getText());
		element.sendKeys("3-May-2020");
		element.getAttribute("date").;
		//element.sendKeys(arg0);
		
		//driver.quit();
		
		
		
		
	}

}
