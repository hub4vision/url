import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TestDropdown {

	
	public static void main(String[] args) {


		
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.wikipedia.org/");
		driver.manage().window().maximize();

		
		//driver.findElement(By.xpath("//*[@id='searchLanguage']")).sendKeys("Dansk");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchLanguage']"));
		Select select = new Select(dropdown);
		
		select.selectByValue("hi");
		
		
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		
		System.out.println(values.size());
		
		for(int i=0; i<values.size(); i++){
			
			System.out.println(values.get(i).getAttribute("lang"));			
		}
		
		System.out.println("-----Printing all links-----------");
		
		WebElement block = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[12]"));
	
		
		
		List<WebElement> links = block.findElements(By.tagName("a"));
				System.out.println(links.size());
		
		for(int i=0; i<links.size(); i++){
			
			System.out.println(links.get(i).getAttribute("href"));			
		}
		
		
		
	}

}
