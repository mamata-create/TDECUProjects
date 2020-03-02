package com.FrameworkComponents;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import org.jsoup.Jsoup;

public class Test {
	
	public static String fetchOutlookOTP() throws MessagingException, IOException{
		String hostName = "outlook.office365.com";
		String username = "divya.vagalaboina@eaglecrk.com";
		String password = "Saibaba@1234";
		int messageCount;
		int unreadMsgCount;
		String emailSubject;
		Message emailMessage;
		String ActOTP=null;

		Properties sysProps = System.getProperties();
		sysProps.setProperty("mail.store.protocol", "imaps");
		Session session = Session.getInstance(sysProps, null);
		Store store = session.getStore();
		store.connect(hostName, username, password);
		Folder emailInbox = store.getFolder("Inbox");
		emailInbox.open(Folder.READ_WRITE);
		messageCount = emailInbox.getMessageCount();
		System.out.println("Total Message Count: " + messageCount);

		unreadMsgCount = emailInbox.getNewMessageCount();
		System.out.println("Unread Emails count:" + unreadMsgCount);
		emailMessage = emailInbox.getMessage(messageCount);
		emailSubject = emailMessage.getSubject();
		
		 Message[] messages = emailInbox.search(new FlagTerm(new Flags(
                 Flags.Flag.SEEN), false));
	      System.out.println("messages.length---" + messages.length);
	     
	      for (int i = 0; i < messages.length; i++) {
	         Message message = messages[i];
	         System.out.println("---------------------------------");
	         System.out.println("Email Number " + (i + 1));
	         System.out.println("Subject: " + message.getSubject());
	         System.out.println("From: " + message.getFrom()[0]);
	         System.out.println("Text: " + message.getContent().toString());
	         try{
	        	 if(  message.getContent() instanceof MimeMultipart ){
		        	 System.out.println("From: " + message.getFrom()[0]);
		        	 MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
		        	 BodyPart  bp=mimeMultipart.getBodyPart(i);
		        	 System.out.println("BP content type is -"+bp.getContentType());
		        	 
		        	 if(bp.getContent().toString().contains("Your verification code")){
		        	 String htmlpart=(String)bp.getContent(); 
						String otp=Jsoup.parse(htmlpart).text();
						System.out.println("OTP messages are - "+otp);
		        	 }
		         }else{
		        	 System.out.println(message.getContent().toString());
		        	 if(message.getSubject().equalsIgnoreCase("One Time Passcode") && message.getContent().toString().contains("Your verification code")){
		        		 String val = Jsoup.parse(message.getContent().toString()).text();
		        		// System.out.println((val.substring(26, 32)));
		        		 ActOTP = val.substring(26, 32);
		        	 }
		        	 
		         }
	         }catch(Exception e){
	        	 
	         }
	         
	         

	      }

	      //close the store and folder objects
	      emailMessage.setFlag(Flags.Flag.SEEN, true);
	      emailInbox.close(false);
	      store.close();
		return ActOTP;	
		}
	
	public static void main(String[]arg) throws MessagingException, IOException{
		System.out.println(fetchOutlookOTP());
	}

}
