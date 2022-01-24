package com.disney.springboot.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//import com.disney.springboot.Model.User;



@Service
public class EmailService {
	@Value("${spring.mail.username}")
	private String from;	
	
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public String enviarMail(String toEmail, String body, String subject) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(toEmail);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		
	
		
		javaMailSender.send(mailMessage);
		
		return "correo enviado";
	}

	
}