package com.hub4vision.urls;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestAlerts {

	
	public static void main(String[] args) throws InterruptedException {


		

		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")).click();
		driver.findElement(By.cssSelector("#Email"));
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(1000);
		alert.accept();
	//	alert.sendKeys("sdsfds");
		
	}

}
