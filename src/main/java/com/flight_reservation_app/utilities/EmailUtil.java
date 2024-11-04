package com.flight_reservation_app.utilities;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sender;

	public void sendItinerary(String email, String filepath1) {
MimeMessage message=sender.createMimeMessage();
try {
	MimeMessageHelper messageHelper=new MimeMessageHelper(message,true);
	messageHelper.setTo(email);
	System.out.println();
	messageHelper.setSubject("Itinerary of Flight");
	messageHelper.setText("Please Find the attachment");
	messageHelper.addAttachment("Itinerary", new File(filepath1));
	sender.send(message);
} catch (Exception e) {
	e.printStackTrace();
}
	}

	


}
