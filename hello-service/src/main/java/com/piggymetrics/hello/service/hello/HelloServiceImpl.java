package com.piggymetrics.hello.service.hello;

import com.piggymetrics.hello.client.AccountServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class HelloServiceImpl implements HelloService {
    private final JavaMailSender javaMailSender;
    private final AccountServiceClient accountClient;
    private final TemplateEngine templateEngine;

    @Override
    public String getHello() {
        return accountClient.getHelloFromAccountService();
    }

    @Override
    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("martysiuk.work@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);
    }

    @Override
    public void sendEmailWithAttachment() {
        MimeMessage msg = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo("martysiuk.work@gmail.com");
            helper.setSubject("Testing from Spring Boot");
            helper.setText("<h1>Check attachment for image!</h1>", true);
            helper.addAttachment("olechka_buzova.png", new ClassPathResource("olechka.png"));

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(msg);
    }
}