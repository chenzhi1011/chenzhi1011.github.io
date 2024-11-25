package com.example.service.serviceImpl;

import com.example.dto.msgDTO;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;

    public void sendHtmlEmail(msgDTO msgDto) throws MessagingException, jakarta.mail.MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        //from SMTP（address）
        message.setFrom(new InternetAddress("chinshiasahi@gmail.com"));
        //to my personl address
        message.setRecipients(MimeMessage.RecipientType.TO, "chenzhifresh@gmail.com");
//        message.setRecipients(MimeMessage.RecipientType.CC, "zhengqihui0317@gmail.com");
        message.setSubject(msgDto.getTheme());

        String htmlContent = "<html>" +
                "<body>" +
                "<h2>您收到了来自 <span style='color: #007bff;'>" + msgDto.getName() + "</span> 的邮件：</h2>" +
                "<p style='font-size: 16px;'>" + msgDto.getMsgContent() + "</p>" +
                "<p>感兴趣的话请联系：<a href='mailto:" + msgDto.getEmail() + "'>" + msgDto.getEmail() + "</a></p>" +
                "<hr>" +
                "<p style='font-size: 12px; color: #888;'>这是一封系统自动发送的邮件，请勿直接回复。</p>" +
                "</body>" +
                "</html>";
        message.setContent(htmlContent, "text/html; charset=utf-8");

        mailSender.send(message);
    }
}

