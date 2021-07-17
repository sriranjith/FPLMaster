package com.fpl.fplmaster.email;

import com.fpl.fplmaster.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    private JavaMailSender emailSender;

    @Autowired
    public EmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sriranjith@zoho.com");
        message.setTo(email.getEmail());
        message.setSubject("FPLMaster");
        message.setText("You are successfully subscribed to FPLMaster");
        emailSender.send(message);
    }
}
