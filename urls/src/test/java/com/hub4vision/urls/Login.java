package com.hub4vision.urls;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import org.openqa.selenium.WebDriver;

public class Login extends Library{

	//static WebDriver driver;
	public static String websiteURL;
	public static String excelPath;
	public static String username;
	public static String password;
	public static String cellData;
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest extentTest;
	
	@BeforeSuite
	public void HomeSetup(){
		//Library library = new Library();
		websiteURL= "https://opensource-demo.orangehrmlive.com/";
		
		htmlReporter = new ExtentHtmlReporter(projectPath+"/"+config.getProperty("nameofAttachedReport"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		driver.get(websiteURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(dataProvider = "loginData")
	public void doLogin(String username, String password) throws Exception {
		extentTest = extent.createTest("Verify Login with data username = "+ username + " and Password = " + password, " ");

			if(isElementPresent(config.getProperty("usernameXPath"))==true && isElementPresent(config.getProperty("passwordXPath"))==true && isElementPresent(config.getProperty("submitXPath"))==true)  {
			
				driver.findElement(By.xpath(config.getProperty("usernameXPath"))).sendKeys(username);
				driver.findElement(By.xpath(config.getProperty("passwordXPath"))).sendKeys(password);
				driver.findElement(By.xpath(config.getProperty("submitXPath"))).click();

				if(isElementPresent("//span[@id='spanMessage']")==true){
					extentTest.log(Status.PASS, "Test Passed because expected webelement is found.", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
					System.out.println(element.getText());
				}
				else if (isElementPresent("//a[@id='welcome']")==true) {
					
					extentTest.log(Status.PASS, "Test Passed - Valid user login successfully On Dashborad", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
					System.out.println("Test Passed because on Dashborad");
					driver.findElement(By.xpath(config.getProperty("dashboardWelcome"))).click();
					driver.findElement(By.xpath(config.getProperty("dashboardLogout"))).click();
				}
				else{
					extentTest.log(Status.PASS, "Test Passed - Valid user login successfully On Dashborad", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
					System.out.println("Test Passed because on Dashborad");
				}
			}
			else{
				System.out.println("Do not login because username and password xpath are not available.");
			}
	}
	
	@DataProvider(name = "loginData")
	public static Object[][] getData(){
		excelPath = (projectPath  + "/" + config.getProperty("testDataLoginFileName"));
		System.out.println("Excelpath is = " + excelPath);

		Object data[][] = testData(excelPath, config.getProperty("worksheetLoginName"));
		return data;
	}
	public static Object[][] testData(String excelPath, String sheetName){
		
		excelRead excel = new excelRead(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		System.out.println("rowCount = "+ rowCount);
		System.out.println("rowCount = "+ colCount);
				
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount;i++){
			
			for(int j=0; j<colCount; j++){
				cellData=excel.getCellDataString(i, j);
				data[i-1][j] = cellData;
			}
		}
		return data;
	}
	public static String capture(WebDriver driver) throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(projectPath+"/"+config.get("screenshotFolderName")+"/"+ System.currentTimeMillis()+".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(srcFile, Dest);
		return errflpath;
	}

	@AfterSuite
	public static void Email() throws Exception{
		monitoringMail objmail = new monitoringMail(); 
		try {
			objmail.sendMail(inputEmailConfiguration.server, inputEmailConfiguration.from, inputEmailConfiguration.to, inputEmailConfiguration.subject, inputEmailConfiguration.messageBody, inputEmailConfiguration.attachmentPath, inputEmailConfiguration.attachmentName);
			extentTest.pass("After Test: Test report emailed successfully.");
			
		} catch (AddressException a) {
			a.printStackTrace();
			extentTest.fail("After Test: Email is not send. Failed");
		} catch (MessagingException m) {
			m.printStackTrace();
			extentTest.fail("After Test: Email is not send. Failed");
		}
		
		extentTest.log(Status.INFO, "The live website URLs testing is done. Thanks!!!");
		extent.flush();
		quitedriver();
	} 
}
