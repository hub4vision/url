package com.hub4vision.urls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MalformedURLExceptionExample extends Library{

	private static final String USER_AGENT = "Mozilla/5.0";
    private static final String URL = "http://examples.javacodegeeks.com/core-java/io/bufferedreader/how-to-get-the-standard-input-in-java/";
 
    public static void main(String[] args) {
    	
    	new Library();
		Library.driver.get(URL);
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
		
        try {
            System.out.println(sendGetRequest(URL));
 
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static String sendGetRequest(String urlString) throws IOException {
 
        URL obj = new URL(urlString);
        HttpURLConnection httpConnection = (HttpURLConnection) obj
                .openConnection();
 
        httpConnection.setRequestMethod("GET");
 
        httpConnection.setRequestProperty("User-Agent", USER_AGENT);
 
        int responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {
 
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(
                    httpConnection.getInputStream()));
             
            String responseLine;
            StringBuffer response = new StringBuffer();
 
            while ((responseLine = responseReader.readLine()) != null) {
                response.append(responseLine+"\n");
            }
            responseReader.close();
 
            // print result
            return response.toString();
        }
        return null;
 
    }
}
