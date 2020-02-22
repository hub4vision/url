package com.hub4vision.urls;

public class inputEmailConfiguration extends Library{
	
	public static String server=config.getProperty("smtpServer");
	public static String from =config.getProperty("fromEmailId");
	public static String password =config.getProperty("emailIDPassword");
	public static String subject =config.getProperty("emailSubject");
	public static String messageBody =config.getProperty("emailmessageBody");
	public static String attachmentName=config.getProperty("nameofAttachedReport");
	
	//Please enter email address as required to send and give attachment file names.
	public static String[] to ={"testumeshkumarsingh@gmail.com","umeshkumarsingh@gmail.com"};
	public static String[] attachmentPath ={"F:/IDE3/workspace/urls/Today_Live_Website_URLs_Extent_Reports.html","F:/IDE3/workspace/urls/TestData.xlsx"};
	
}
