package com.hub4vision.urls;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTabsandPopups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

WebDriver driver = new FirefoxDriver();
		
		
		driver.navigate().to("http://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		System.out.println("------Generating window ids from first window------");
		
		
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> itrate = winids.iterator();
		
		String first_window = itrate.next(); //first window
		System.out.println(first_window);
		
		driver.findElement(By.xpath("//*[@id='loginsubmit']")).click();
		
		
	System.out.println("------Generating window ids from second window------");
	
		
		winids = driver.getWindowHandles();
		itrate = winids.iterator();
		
		System.out.println(itrate.next()); //first window
		String second_window = itrate.next(); //second window
		System.out.println(second_window);
		
		driver.switchTo().window(second_window);
		
		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/ul/li[3]/a")).click();
		
		
	System.out.println("------Generating window ids from third window------");
	
		
		winids = driver.getWindowHandles();
		itrate = winids.iterator();
		
		System.out.println(itrate.next()); //first window
		System.out.println(itrate.next()); 
		String third_window = itrate.next(); //third_window
		System.out.println(third_window);
		
		driver.switchTo().window(third_window);
		
		new Select(driver.findElement(By.xpath("//*[@id='eForm_form_applicantPlaceHolder_residenceCity_value']"))).selectByVisibleText("Noida");
		
		/*
		driver.close(); //3rd 
		driver.switchTo().window(second_window);
		
		*/
		
		driver.quit();
		
		
		Set<String> winidss = driver.getWindowHandles();
		Iterator<String> iterators = winidss.iterator();
		
		String firstwindow = iterators.next();
		driver.switchTo().window(firstwindow);
		
		
		winidss = driver.getWindowHandles();
		iterators = winidss.iterator();
		
		iterators.next();
		String second_Wind = iterators.next();
		driver.switchTo().window(second_Wind);
		
		
		
		
		
		
	}

}
