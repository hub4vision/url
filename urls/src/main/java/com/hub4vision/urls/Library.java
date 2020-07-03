package com.hub4vision.urls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		//System.out.println("config path " + projectPath+"/config.Properties");
		config.load(fis);
	}
	
	public static boolean isElementPresent(String elementXpath){
		try{
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			element = driver.findElement(By.xpath(elementXpath));
			//System.out.println("elementXpath is " + elementXpath);
			//System.out.println("element name is " + element + " and it is found.");
			return true;
		}
		catch(Exception t){
			t.printStackTrace();
			//System.out.println("elementXpath is" + elementXpath);
			//System.out.println(elementXpath + " element is not found.");
			return false;
		}
		
	}
	
	public static WebElement element(String locator)
	{
		
		element = driver.findElement(By.xpath(locator));
		//System.out.println("locator value is " + locator);
		//System.out.println("Element value is " + element);
		return element;
	}

	public static String capture(WebDriver driver) throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(projectPath+"/"+config.get("screenshotFolderName")+"/"+ System.currentTimeMillis()+".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(srcFile, Dest);
		return errflpath;
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		//System.out.println("sendKeys value is " + value);
		
	//call his method like senKeys(driver, element, 10, "Tom");

	}

	public static void clickOn(WebDriver driver, WebElement element, int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		//System.out.println("clickOn click() " + element);
	//call his method like clickOn(driver, element, 10);

	}
	public static void quitedriver(){
		driver.quit();
	}
}
