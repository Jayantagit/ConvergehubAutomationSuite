package com.ConvergeHub.Utilities;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail 
{
	public static void sendEmail()
	{
		
	      final String username = "january20.core@gmail.com";
	      final String password = "Wyndham-2022";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", true);
	      props.put("mail.smtp.starttls.enable", true);
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", "587");

	      Session session = Session.getInstance(props,
	              new javax.mail.Authenticator() {
	                  protected PasswordAuthentication getPasswordAuthentication() {
	                      return new PasswordAuthentication(username, password);
	                  }
	              });

	      try {

	          Message message = new MimeMessage(session);
	          message.setFrom(new InternetAddress("january20.core@gmail.com"));
	          message.setRecipients(Message.RecipientType.TO,
	                  InternetAddress.parse("to.mail.id@gmail.com"));
	          message.setSubject("Testing Subject");
	          message.setText("PFA");

	          MimeBodyPart messageBodyPart = new MimeBodyPart();

	          Multipart multipart = new MimeMultipart();

	          messageBodyPart = new MimeBodyPart();
	          String file = "D:\\AutomationTestScripts\\Workspace\\target\\surefire-reports\\html\\";
	          String fileName = "extent.thml";
	          DataSource source = new FileDataSource(file);
	          messageBodyPart.setDataHandler(new DataHandler(source));
	          messageBodyPart.setFileName(fileName);
	          multipart.addBodyPart(messageBodyPart);

	          message.setContent(multipart);

	          System.out.println("Sending");

	          Transport.send(message);

	          System.out.println("Done");

	      } catch (MessagingException e) {
	          e.printStackTrace();
	      }
	    }
	
	
}
