import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


public class WebListner extends AbstractWebDriverEventListener {

	public void afterClickOn(WebElement element, WebDriver driver){
		
		
		System.out.println("Clicking on an Element : "+element);
		
	}
	
	
	public void afterNavigateBack(WebDriver driver){
		
		System.out.println("Clicking on back button");
		
	}
}
