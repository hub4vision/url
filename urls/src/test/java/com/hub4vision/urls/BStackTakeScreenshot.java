package com.hub4vision.urls;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class BStackTakeScreenshot {

	@Test
	public void testBStackTakeScreenShot() throws Exception{

	WebDriver driver ;
	System.setProperty("webdriver.gecko.driver","F:/IDE3/workspace/url/urls/Drivers/geckodriver/geckodriver.exe"); //webdriver.gecko.driver
	driver = new FirefoxDriver();
	//goto url
	driver.get("https://www.browserstack.com");
	//Call take screenshot function
	BStackTakeScreenshot.takeSnapShot(driver, "F:/IDE3/workspace/url/urls/screenshots/test.png") ;
	
	}
	/**
	* This function will take screenshot
	* @param webdriver
	* @param fileWithPath
	* @throws Exception
	*/

	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
}
