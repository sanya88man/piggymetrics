package com.piggymetrics.hello.service.hello;

import com.piggymetrics.hello.dto.Letter;

import javax.mail.MessagingException;
import java.io.IOException;

public interface HelloService {
    String getHello();

    void sendEmail();

    void sendEmailWithAttachment();
}
