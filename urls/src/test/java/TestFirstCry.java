import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class TestFirstCry {

	
	public static void main(String[] args) {
		
		ProfilesIni listProfile = new ProfilesIni();
		FirefoxProfile profile = listProfile.getProfile("default");

		WebDriver driver = new FirefoxDriver(profile);
		driver.navigate().to("http://beta.firstcry.com/");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();

		
		
		
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div[2]/span[6]")).click();
	
		
		
		driver.switchTo().frame("iframe_Login");
		
		driver.findElement(By.xpath("//*[@id='txtLUNm']")).sendKeys("trainer@way2automation.com");
		
		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		
		System.out.println(frames.size());
		
		for(int i=0; i<frames.size(); i++){
			
			System.out.println(frames.get(i).getAttribute("id"));
			
		}
		
		
		
	}

}
