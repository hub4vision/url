package com.hub4vision.urls;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
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

public class VerifyLiveURLs extends Library{

	public static String excelPath;
	public static String username;
	public static String password;
	public static String cellData;
	public static String websiteURL;
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest extentTest;
	
	@BeforeSuite
	public void HomeSetup(){
		
		htmlReporter = new ExtentHtmlReporter(projectPath+"/"+config.getProperty("nameofAttachedReport"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	@Test(dataProvider = "urldata")
	public void LiveURLCheck(String websiteURL, String websiteXpath) throws Exception {
		extentTest = extent.createTest("Verify live wesite "+websiteURL, "Verify live wesite "+ websiteURL);
		driver.get(websiteURL);
		//driver.navigate().to(websiteURL);
		extentTest.log(Status.INFO,"The website URL is entered successfully. URL: ");
		extentTest.log(Status.INFO,"The website title is '" + driver.getTitle()+"'");
		
		if(isElementPresent(websiteXpath)==true){
			extentTest.log(Status.PASS, "Test Passed because expected webelement is found.", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());

		}
		else{
			extentTest.log(Status.FAIL, "Test Failed because expected webelement is found.", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		}
	}
	@DataProvider(name = "urldata")
	public static Object[][] getData(){
		excelPath = projectPath+"/"+config.getProperty("testDataFileName");
		Object data[][] = testData(excelPath, config.getProperty("worksheetName"));
		return data;
	}
	public static Object[][] testData(String excelPath, String sheetName){
		
		excelRead excel = new excelRead(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
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
		}
		extentTest.log(Status.INFO, "The live website URLs testing is done. Thanks!!!");
		extent.flush();
		quitedriver();
	} 
	
}