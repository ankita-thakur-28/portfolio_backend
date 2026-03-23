package com.codewithankita.portfolioproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("$app.mail.to")
    private String toEmail;

    @Async
    public void sendContactEmail(String name, String senderEmail, String message ) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(toEmail);
        mail.setSubject("Portfolio Contact form: " + name);
        mail.setText("Name: " + name + "\n" +
                "Email: " + senderEmail + "\n\n" +
                "Message: " + message
        );

        mail.setReplyTo(senderEmail);

        mailSender.send(mail);
    }

}
