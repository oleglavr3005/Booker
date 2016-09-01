package com.epam.task.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	
	public static void send(String subject, String text, String toEmail) {

		try {
			MimeMessage message = new MimeMessage(MailInit.session);

			message.setFrom(new InternetAddress(MailInit.username));

			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmail));

			message.setSubject(subject);

			message.setContent(text, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}