package com.hub4vision.urls;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrokenLinks extends Library{

	public static String websiteURL = "https://tripcorner.com/";
	//public static String websiteURL ="https://www.amazon.co.uk/";	
	public static void main(String[] args) throws Exception {

		new Library();
		Library.driver.get(websiteURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//https://www.youtube.com/watch?v=f_8yUC52g34
		//gitRepository
		//https://github.com/naveenanimation20
		//Interview q - How to find broken links & Images using Selenium Webdriver
		//*https://stackoverflow.com/questions/59929164/exception-in-thread-main-java-net-malformedurlexception-no-protocol-error-whi
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		
		//List<WebElement> linksList = driver.findElements(By.xpath("//a[contains (@href, '/')]"));
		//linksList.addAll(driver.findElements(By.xpath("//img[contains (@src, '/')]")));
		
		List<WebElement> activeLinks = new ArrayList<WebElement>(); //driver.findElements(By.tagName("")); 
		
		System.out.println("Size of full links and images >>>> " + linksList.size());
		
		int z = 0;
		for(int i=0; i<linksList.size();i++){
			
			//System.out.println(linksList.get(i).getAttribute("href"));
			
			//if (!linksList.get(i).getAttribute("href").contains("javascript")){
			
				if(linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript")) ){ //&& (!linksList.get(i).getAttribute("href").contains("javascript"))
					
					activeLinks.add(linksList.get(i));
					System.out.println("activeLinks " + z + " '" + linksList.get(i).getAttribute("href") +"'");
					//System.out.println("activeLinks " + z + " " + i);
					z = z + 1;
				}
				else if (linksList.get(i).getAttribute("href") == "") {
					//System.out.println("In else " + linksList.get(i).getAttribute("href"));
				}
			//}
		}
		
		
		System.out.println("Size of active links and Images >>" + activeLinks.size());
		
		for(int j=0; j < activeLinks.size(); j++){
			
			//if (activeLinks.get(j).getAttribute("href") != null){
				HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
				connection.connect();
				Thread.sleep(100);
				String response = connection.getResponseMessage();
				int responseCode = connection.getResponseCode();
				connection.disconnect();
				
				if (responseCode > 400){
					
					System.out.println(j + " > response : " + responseCode +  " response : " + response + " - is a broken link " + activeLinks.get(j).getAttribute("href"));
					
				}
				else{
					System.out.println(j +" > response : " + responseCode +  " response : " + response + " - is a valid link " + activeLinks.get(j).getAttribute("href") );
				}
					
				//System.out.println("This is the active links "  + j + " " + activeLinks.get(j).getAttribute("href") + " --->" + responseCode +  " : " + response);
			//}
			//else{
				//System.out.println(j + " > " + " Not valid URL: "  + activeLinks.get(j).getAttribute("href") );
			//}
				
		}
		
	}

}
