package com.epam.task.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class MailInit {
	public static final String username = "100dilko.da@gmail.com";
	private static final String password = "Danulo1995power";
	private static final Properties props = new Properties();

	static {
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	}

	public static final Session session = Session.getInstance(props,
			new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
	
	public static Session initializeSession(){
		return session;
	}

}
