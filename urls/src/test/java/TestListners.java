import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

public class TestListners {

	
	public static void main(String[] args) {


		WebDriver webdriver = new FirefoxDriver();
		
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		WebListner listner = new WebListner();
		driver.register(listner);
		
		
		driver.get("http://google.com");
		
		EventFiringMouse mouse = new EventFiringMouse(driver, listner);
		Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div[1]/div[2]/a"));
		Coordinates cord = hoverItem.getCoordinates();
		mouse.mouseMove(cord);
		
		/*driver.findElement(By.xpath("//*[@id='fsl']/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='testimonial']/div[1]/div[2]/p/a")).click();
		
		driver.navigate().back();*/
		
		
	}

}
