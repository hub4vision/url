import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestAuthenticateUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {



		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://grcdev:nearlythere@getproactiv-ca.stg01.grdev.com/");
		driver.manage().window().maximize();


	}

}
