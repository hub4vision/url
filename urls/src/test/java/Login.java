

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;






public class Login {
	//select browser name [firefox, ie, chrome]
	//http://crm.fursan.com.sa
	//http://124.124.38.154/cosmosfursan/index.aspx?ck=5EF69C69-15C0-4300-A5FB-A539424B9C20
	// QC >   ctl06$UserName    ,  ctl06$Password     ctl06$LoginButton		
	// UAT >  UserName			,  Password      ,    LoginButton
	
	public static WebDriver driver;
	public static String selectBrowserName ="firefox";
	public static String url ="http://crm.fursan.com.sa";  
	public static String luserName ="UserName";
	public static String lpassword ="Password";
	public static String lloginButton ="LoginButton";
	
	public static boolean isElementPresent(String xpath){
		
		try{
		driver.findElement(By.xpath(xpath));
		return true;
		}catch(Throwable t){
			
			return false;
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("In main");
		InitializeBrowser(selectBrowserName, url);
		Login("nonttsumesh", "nonttsumesh123");
		System.out.println("After call InitializeBrowserIn method");
		quitdriver();
	}

	public static void InitializeBrowser(String selectBrowserName, String url) throws Exception
	{
		ProfilesIni listProfile = new ProfilesIni();
		FirefoxProfile profile = listProfile.getProfile("default");
		if(selectBrowserName.equals("firefox")){
			driver = new FirefoxDriver(profile);
			System.out.println("In Firefox");
		}else if(selectBrowserName.equals("ie")){
			driver = new InternetExplorerDriver();
			System.out.println("In ie");
		}else if(selectBrowserName.equals("chrome")){
			driver = new ChromeDriver();
			System.out.println("In chrome");
		}
		else{
			System.out.println("The expected browser (firefox, ie, chrome) is not selected. " + "The browser name is "+ selectBrowserName );
		}
		System.out.println("After if condition");
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
	}
	public static void Login(String Username,String Password) throws InterruptedException
    {
            System.out.println("In Login Method");
			driver.navigate().to(url);
            driver.findElement(By.name(luserName)).sendKeys(Username);
            driver.findElement(By.name(lpassword)).sendKeys(Password);
            driver.findElement(By.name(lloginButton)).click();
            System.out.println("Clicked on Login link");
    
    		//alert.accept();
            //driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
            
            if (isElementPresent("//*[@id='ctl00_TOP_lblName']"))
            {
            	
            	System.out.println("Successfully loging");
            }
            else
            {
            		System.out.println("In else case");
            		Alert alert = driver.switchTo().alert();
            		System.out.println(alert.getText());
            		Thread.sleep(10000);
            		//alert.accept();
            }
            System.out.println("After If condition");
    }
	public static void quitdriver()
	{
	       driver.quit();
	}
}
