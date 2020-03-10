import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestCaptureScreenshot {

	
	public static void main(String[] args) throws IOException {


		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://gmail.com");
		
		driver.findElement(By.id("Email")).sendKeys("sdfdsf");
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	FileUtils.copyFile(scrFile, new File("c:\\screenshot\\abcd.jpg"));
		
	 
	}

}
