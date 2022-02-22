package com.piggymetrics.hello.service.email;

import com.piggymetrics.hello.dto.Letter;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender javaMailSender;
    private final EmailTemplateService emailTemplateService;

    @Override
    public void sendWinnerEmail(Letter letter) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true, "UTF-8");
            helper.setTo(letter.getEmail());
            helper.setSubject(letter.getEmail() + ", you won in lottery!");
            String emailContent = emailTemplateService.getEmailContent(letter);
            helper.setText(emailContent, true);
            helper.addInline("image-1.png", new ClassPathResource("image-1.png"));
            helper.addInline("image-2.png", new ClassPathResource("image-2.png"));
            helper.addInline("image-3.png", new ClassPathResource("image-3.png"));
            helper.addInline("image-4.png", new ClassPathResource("image-4.png"));
            helper.addInline("image-5.png", new ClassPathResource("image-5.png"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
