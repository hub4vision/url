package com.hub4vision.urls;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {

	public static void main(String[] arg){
		
	
		WebDriver driver = new FirefoxDriver();
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
		alert.sendKeys("Test");
		
		
		driver.switchTo().frame("iframe");
		
	}
}
