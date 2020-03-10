package com.hub4vision.urls;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestLoginClass extends LoginClass{
	public static String websiteURL;
	public static String status ;
	public static DateFormat sdf ;
	 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LoginClass loginClass = new LoginClass();

		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		status = "Status on " + sdf.format(date);

		Xls_Reader reader = new Xls_Reader("F:/IDE3/workspace/url/urls/Login.xlsx");
		int rowCount = reader.getRowCount("Login");
		
		
		reader.addColumn("Login", status);
		
		
		websiteURL= "https://opensource-demo.orangehrmlive.com/";
		driver.get(websiteURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for(int rowNum = 2 ; rowNum <= rowCount; rowNum++)
		{
			String exlsUserName = reader.getCellData("Login", "UserName", rowNum);
			String exlsPassword = reader.getCellData("Login", "Password", rowNum);
			System.out.println("'" + exlsUserName + "' " + " '" + exlsPassword + "'");
			
			
			loginClass.doLogin(exlsUserName, exlsPassword);
			reader.setCellData("Login", status, rowNum, "Pass");
			System.out.println("----------------------------------------------------");
		}
		driver.quit();
	}
}
