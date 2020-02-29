package com.hub4vision.urls;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;


public class TestMouseOver {

	
	public static void main(String[] args) throws InterruptedException {


		ProfilesIni listProfile = new ProfilesIni();
		FirefoxProfile profile = listProfile.getProfile("default");

		WebDriver driver = new FirefoxDriver(profile);
		
		
		driver.navigate().to("http://www.jabong.com/");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	
		Thread.sleep(15000);
		
		((JavascriptExecutor) driver).executeScript("closePops('signIn')");
		
		/*driver.findElement(By.xpath("//*[@id='jab-vchr-cls']")).click();
		
		WebElement menu = driver.findElement(By.xpath("//*[@id='qa-main-men']"));

		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		
		driver.findElement(By.xpath("html/body/section/div[1]/div[1]/header/div[3]/div/nav/ul/li[3]/div/div[2]/a[4]")).click();
	*/	
		
		
		
		
		
	}

}
