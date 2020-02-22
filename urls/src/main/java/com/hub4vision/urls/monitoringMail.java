package com.hub4vision.urls;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class monitoringMail {

	public void sendMail(String mailServer, String from, String[] to, String subject, String messageBody, String[] attachmentPath, String attachmentName) throws MessagingException, AddressException
	{
		boolean debug = false;
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable","true");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.host", mailServer); 	
		props.put("mail.debug", "true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		props.setProperty("mail.smtp.socketFactory.fallback", "false");   
		props.setProperty("mail.smtp.port", "465");   
		props.setProperty("mail.smtp.socketFactory.port", "465"); 

		SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		session.setDebug(debug);

		try
		{

			Transport bus = session.getTransport("smtp");
			bus.connect();
			Message message = new MimeMessage(session);


			//X-Priority values are generally numbers like 1 (for highest priority), 3 (normal) and 5 (lowest).
			message.addHeader("X-Priority", "1");
			message.setFrom(new InternetAddress(from));
			InternetAddress[] addressTo = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++)
				addressTo[i] = new InternetAddress(to[i]);
				message.setRecipients(Message.RecipientType .TO, addressTo);
				message.setSubject(subject);

				BodyPart body = new MimeBodyPart();

				// body.setText(messageBody);
				body.setContent(messageBody,"text/html");

		        MimeMultipart multipart = new MimeMultipart();
		        multipart.addBodyPart(body);

		        // adds attachments
		        if (attachmentPath != null && attachmentPath.length > 0) {
		            for (String filePath : attachmentPath) {
		                MimeBodyPart attachPart = new MimeBodyPart();
		 
		                try {
		                    attachPart.attachFile(filePath);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		 
		                multipart.addBodyPart(attachPart);
		            }
		        }
				
				multipart.addBodyPart(body);
				message.setContent(multipart);
				Transport.send(message);
				System.out.println("Sucessfully Sent mail to All Users");
				bus.close();

		}
		catch (MessagingException mex)
		{
			mex.printStackTrace();
		}		
	} 

	public class SMTPAuthenticator extends javax.mail.Authenticator
	{

		public PasswordAuthentication getPasswordAuthentication()
		{
			String username = inputEmailConfiguration.from;
			String password = inputEmailConfiguration.password;
			return new PasswordAuthentication(username, password);
		}
	}
	
}