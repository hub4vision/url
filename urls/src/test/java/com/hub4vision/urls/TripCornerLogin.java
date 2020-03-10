package com.hub4vision.urls;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripCornerLogin extends Library{
	
	public static String websiteURL = "https://tripcorner.com/";
	
	
	public static void main(String[] arg) throws Exception{
		
		new Library();
		Library.driver.get(websiteURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='linkSignin']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register Here')]")).click();

		//Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		
		WebElement element = driver.findElement(By.xpath("//input[@id='txtemailaddressr']"));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtemailaddress']")));
		element = wait.until(ExpectedConditions.vi .visibilityOfElementLocated(By.xpath("//input[@id='txtemailaddress']")));
		
		element.sendKeys("exceluks@gmail.com");

		element = driver.findElement(By.xpath("//div[@class='email-signup loginform-wrapper']//select[@id='ddlmobileISDCode']"));
		Select select = new Select(element);
		
		List<WebElement> values = element.findElements(By.tagName("option"));
		
		for(int i=0; i<values.size(); i++){

			String str = values.get(i).getAttribute("value");
			String countrycode = "+91";
			
			if (str.equals(countrycode)){
				select.selectByIndex(i);
				
				System.out.println("Country is selected on index no. " + i);
				
			}
		}
		
		driver.findElement(By.xpath("//input[@id='txtmobile']")).sendKeys("9818747473");
		driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Test@123");
		element = driver.findElement(By.tagName("//input[@id='ReceivePromotion']"));

		//element = driver.findElement(By.tagName("input"));
		//element.isSelected();
		//element.getAttribute("checked");
		//element.isSelected();
		
		System.out.println(element.isSelected());
		boolean getChech;
		getChech = element.isSelected();
		
		if ((getChech) && (false))
		{
			element.click();
		}
		else{
			
		}
		
		//Error Messages
		//Email Id is required / Valid Email Id is required
		//Dailling code is required / Mobile number is required
		//Password is required


		

		
	}
}


