package com.disney.springboot.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class emailService {

	@Value("${app.sendgrid.templateId}")
	private String templateId;
	@Autowired
	SendGrid sendGrid;
	public String sendEmail(String email) {
		
		try {
		Mail mail = prepareMail(email);
		
		Request request = new Request();
		
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());
		
		Response response = sendGrid.api(request);
		
		if(response!=null) {
			System.out.println("response from"+ response);
		}
	}
		catch(IOException e) {
			e.printStackTrace();
			return "error in send";
			}
		return "mail has been send";
		}
	
	
	public Mail prepareMail(String email) {
		Mail mail = new Mail();
		Email fromEmail = new Email();
		fromEmail.setEmail("katyvenegasmlv@gmail.com");
		Email to = new Email();
		to.setEmail(email);
		
		Personalization personalization = new Personalization();
		personalization.addTo(to);
		
		mail.setTemplateId(templateId);
		
		return mail;
		
	}
	
	
}
