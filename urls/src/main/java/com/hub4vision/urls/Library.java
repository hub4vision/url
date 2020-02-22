package com.hub4vision.urls;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Library {
	
	public static WebDriver driver;
	public static WebElement element;
	public static Properties config;
	public static String projectPath;
	
	public Library(){
		config = new Properties();
		projectPath = System.getProperty("user.dir");
		
		if(driver==null){
			try {
				getConfigPropertiesData();
				
				if(config.getProperty("browser").equalsIgnoreCase("chrome")){
					
					System.setProperty("webdriver.chrome.driver",(projectPath+config.getProperty("chromedriverpath")));
					driver = new ChromeDriver();
					//driver.get(null);
					driver.manage().window().maximize();
				}
				else if( config.getProperty("browser").equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver",(projectPath+config.getProperty("firefoxdriverpath")));
					driver = new FirefoxDriver();
					//driver.get(null);
					driver.manage().window().maximize();
				}
				else if(config.getProperty("browser").equalsIgnoreCase("HeadLessChrome")){
					System.setProperty("webdriver.chrome.driver",(projectPath+config.getProperty("chromedriverpath")));
					ChromeOptions options = new ChromeOptions();
					options.addArguments("window-size=1400,800");
					options.addArguments("headless");
					driver = new ChromeDriver(options);
					//driver.get(null);
					driver.manage().window().maximize();
				}
				else{
					System.out.println("The browser name"+config.getProperty("browser")+ " is not exist as per expected.");
				}
				

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else{
			
		}
		
		
	}
	
	public void getConfigPropertiesData() throws IOException{
		FileInputStream fis = new FileInputStream(projectPath+"/config.Properties");
		config.load(fis);
	}
	
	public static boolean isElementPresent(String websiteXpath){
		try{
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			element = driver.findElement(By.xpath(websiteXpath));
			
			System.out.println("---------------element value---------------");
			System.out.println(element);
			System.out.println("------------------------------");
			return true;
		}
		catch(Exception t){
			t.printStackTrace();
			return false;
		}
		
	}

	public static void quitedriver(){
		driver.quit();
	}
}
