package com.vms.common;

import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
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

import org.springframework.stereotype.Service;

import com.vms.common.MailUtility.HTMLDataSource;

@Service
public class EmailService {
	
	@Value("${smtp.host}")
	private String smtpHost;
	
	@Value("${smtp.auth}")
	private String smtpAuth;
	
	@Value("${smtp.port}")
	private String smtpPort;
	
	@Value("${smtp.sender.mail}")
	private String senderEmail;
	
	
	public void sendMail(Email email, String path) throws Exception {

		
		/*
		 * Properties props = System.getProperties(); props.put("mail.smtp.auth",
		 * smtpAuth); props.put("mail.smtp.host", smtpHost); props.put("mail.smtp.port",
		 * smtpPort);
		 */
		
		String message = "";
		String mailFrom = "billingsupport@bitutech.net";
		String password = "Paragon@01";
		//String mailTo = "kathiravan@paragondynamics.in";
//		String mailTo = "tara@bitutech.net";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.port", smtpPort);
		properties.put("mail.smtp.auth", smtpAuth);
		properties.put("mail.smtp.starttls.enable", "true");

		
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailFrom, password);
			}
		};
		
		Session session = Session.getInstance(properties, auth);

		/*
		 * // Get a session Session session = Session.getInstance(properties);
		 */

		try {
			/*
			 * Transport bus = session.getTransport("smtp");
			 * bus.connect("smtp.sendgrid.net",25,"apikey",
			 * "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");
			 */
			/*
			 * Message msg = new MimeMessage(session);
			 * 
			 * // Set message attributes msg.setFrom(new InternetAddress(senderEmail));
			 * 
			 * int n = email.getToEmailAddress().length; InternetAddress[] address = new
			 * InternetAddress[n]; for (int i = 0; i < n; i++) { address[i] = new
			 * InternetAddress(email.getToEmailAddress()[i]); }
			 * msg.setRecipients(Message.RecipientType.TO, address);
			 * 
			 * if (email.getCcEmailAddress() != null) { int ccCount =
			 * email.getCcEmailAddress().length; InternetAddress[] ccAddress = new
			 * InternetAddress[ccCount]; for (int i = 0; i < ccCount; i++) { ccAddress[i] =
			 * new InternetAddress(email.getCcEmailAddress()[i]); }
			 * msg.setRecipients(Message.RecipientType.CC, ccAddress);
			 * 
			 * 
			 * }
			 * 
			 * msg.setSubject(email.getSubject()); msg.setSentDate(new Date());
			 */
			
			
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailFrom));
			//InternetAddress[] toAddresses = { new InternetAddress(mailTo) };
			//msg.setRecipients(Message.RecipientType.TO, toAddresses);
			
			 int n = email.getToEmailAddress().length; InternetAddress[] address = new
			 InternetAddress[n]; for (int i = 0; i < n; i++) { address[i] = new
			 InternetAddress(email.getToEmailAddress()[i]); }
			 msg.setRecipients(Message.RecipientType.TO, address);
					 
					 
			
			msg.setSubject(email.getSubject());
			msg.setSentDate(new Date());
			msg.setContent(message, "text/html");
			// sends the e-mail
		//	Transport.send(msg);			
			
			//With Attachment
			if (!path.isEmpty()) {
				setFileAsAttachmentWithHTML(msg, path, email.getBodyHtml());
				//bus.sendMessage(msg, address);
				Transport.send(msg);
				System.out.println("path");
				System.out.println("Mail Sent");
			}else {
				msg.setContent(email.getBodyHtml(), "text/html");
				Transport.send(msg);
				System.out.println("Mail Sent");
			}
			msg.saveChanges();
//			bus.sendMessage(msg, msg.getAllRecipients());
			//bus.close();

		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException))
					break;
				else
					mex = (MessagingException) ex;
			}
			throw mex;
		} finally {
			System.out.println( email.getSubject()+" Sent Successfully");
		}
	}
	
	private static void setFileAsAttachmentWithHTML(Message msg,
			String filename, String bodyhtml) throws MessagingException {
		// Create second part
		MimeBodyPart p1 = new MimeBodyPart();
		p1.setDataHandler(new DataHandler(new HTMLDataSource(bodyhtml)));

		MimeBodyPart p2 = new MimeBodyPart();

		// Put a file in the second part
		FileDataSource fds = new FileDataSource(filename);
		p2.setDataHandler(new DataHandler(fds));
		p2.setFileName(fds.getName());

		// Create the Multipart. Add BodyParts to it.
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(p1);
		mp.addBodyPart(p2);

		// Set Multipart as the message's content
		msg.setContent(mp);

	}
	
}
