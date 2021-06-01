package com.work.spring.utility;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class Mailsender {
	
	@Autowired
	JavaMailSenderImpl mailSenderImpl ;
	
	public void sendEmail(){
		
		String []bccs= {"nayangowda2695@gmail.com","naveenpawar10249@gmail.com","ajjuhospet96@gmail.com"};
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("hashsir0101@gmail.com");
		message.setTo("dostnew01@gmail.com");
		message.setCc("talkingnew01@gmail.com");
		message.setBcc(bccs);
		message.setSubject("demo java mailsender");
		message.setText("Hello all \n ali this side \n This is demo mail for java mailsender \n thanks and regaeds \n Xworkz");
				
		mailSenderImpl.send(message);
		
	}
}
