import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestProperties {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	
	public static void main(String[] args) throws IOException {


		Properties OR = new Properties();
		Properties Config = new Properties();
		
		System.out.println(System.getProperty("user.dir"));
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\OR.properties");
		OR.load(fis);
		log.debug("OR Properties file loaded");
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config.properties");
		Config.load(fis);
		
		log.debug("Config Properties file loaded");
		
		System.out.println(OR.getProperty("username"));
		System.out.println(Config.getProperty("testsiteurl"));
		
		if(Config.getProperty("browser").equals("firefox")){
			
			driver = new HtmlUnitDriver();
			
			log.debug("HtmlUnitDriver Launched");
			
		}else if(Config.getProperty("browser").equals("ie")){
			
			driver = new InternetExplorerDriver();
			
		}else if(Config.getProperty("browser").equals("chrome")){
			
			driver = new ChromeDriver();
			
		}
		
		driver.get(Config.getProperty("testsiteurl"));
		
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys("trainer@way2automation.com");
		log.debug("username entered");
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("sdfdfsd");
		log.debug("password entered");
		driver.findElement(By.xpath(OR.getProperty("signin"))).click();
		log.debug("clicked on sign in ");
		String text = driver.findElement(By.xpath(OR.getProperty("errormsg"))).getText();
		log.debug("Error message : "+text);
	
	}

}
