package com.hub4vision.urls;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginClass extends Library{
	
	public static String websiteURL;
	public static String excelPath;
	public static String username;
	public static String password;
	public static String cellData;
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest extentTest;
	
	
	public LoginClass(){
		
		//Library library = new Library();
		
		
		//System.out.println("In LoginClass class contructor");
		//LoginClass loginClass = new LoginClass();
		htmlReporter = new ExtentHtmlReporter(projectPath+"/"+ config.getProperty("nameofAttachedReport"));
		//System.out.println("Library.config.getProperty nameofAttachedReport " + config.getProperty("nameofAttachedReport"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		
		System.out.println("loginClass.config.getProperty usernameXPath " + config.getProperty("usernameXPath"));
	}

	public void doLogin(String username, String password) throws Exception {
		extentTest = extent.createTest("Verify Login with data username = '"+ username + "' and Password = '" + password, "' ");
			//System.out.println("Library.config.getProperty usernameXPath " + config.getProperty("usernameXPath"));
			
			if(isElementPresent(config.getProperty("usernameXPath"))==true && isElementPresent(config.getProperty("passwordXPath"))==true && isElementPresent(config.getProperty("submitXPath"))==true)  
			{
			
				element(config.getProperty("usernameXPath")).clear();
				element(config.getProperty("usernameXPath"));
				sendKeys(driver, element, 1, username);
				
				element(config.getProperty("passwordXPath")).clear();
				element(config.getProperty("passwordXPath"));
				sendKeys(driver, element, 1, password);
				
				element(config.getProperty("submitXPath"));
				clickOn(driver, element, 20);
				
				//driver.findElement(By.xpath(Library.config.getProperty("usernameXPath"))).getText();
				//driver.findElement(By.xpath(Library.config.getProperty("usernameXPath"))).sendKeys(username);
				//driver.findElement(By.xpath(Library.config.getProperty("passwordXPath"))).sendKeys(password);
				//driver.findElement(By.xpath(Library.config.getProperty("submitXPath"))).click();
				
				Thread.sleep(100);
				//List<WebElement> ls = driver.findElements(By.xpath(Library.config.getProperty("LoginErrorMessage")));
				//List<WebElement> lsH = driver.findElements(By.xpath("//a[@id='welcome']"));
				
				//if(ls.size() > 0){
					
				
								
				if(isElementPresent(config.getProperty("LoginErrorMessage"))==true){
				
				//if(ls.size() > 0){
					extentTest.log(Status.PASS, "Test Passed because expected webelement is found.", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
					extentTest.log(Status.PASS, element.getText(), MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
					System.out.println("'" +element.getText() + "' > " + "It is Validation Message");
				
				}
				//else if (isElementPresent(config.getProperty("dashboardWelcome"))==true) {
					
					//extentTest.log(Status.PASS, "Test Passed - Valid user login successfully On Dashborad", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
					//System.out.println("Test Passed because on Dashborad");
					//driver.findElement(By.xpath(config.getProperty("dashboardWelcome"))).click();
					//driver.findElement(By.xpath(config.getProperty("dashboardLogout"))).click();
				//}
				else{
					
					if (isElementPresent(config.getProperty("dashboardWelcome"))==true) {
					//if(lsH.size() > 0){
						extentTest.log(Status.PASS, "Test Passed - Valid user login successfully On Dashborad", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
						System.out.println("Test Passed because on Dashborad");
						driver.findElement(By.xpath(config.getProperty("dashboardWelcome"))).click();
						//driver.findElement(By.xpath(config.getProperty("dashboardLogout"))).click();
						element(config.getProperty("dashboardLogout"));
						clickOn(driver, element, 10);
					}
					
					//extentTest.log(Status.PASS, "LoginErrorMessage element is not found.", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
					System.out.println("LoginErrorMessage element is not found.");
				}
			}
			else{
				extentTest.log(Status.FAIL, "Do not login because username, password and submit button xpath's are not available.", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
				System.out.println("Do not login because username, password and submit button xpath's are not available.");
			}
	}

}
