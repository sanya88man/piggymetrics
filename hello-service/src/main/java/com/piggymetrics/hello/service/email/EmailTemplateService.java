package com.piggymetrics.hello.service.email;

import com.piggymetrics.hello.dto.Letter;

public interface EmailTemplateService {
    String getEmailContent(Letter letter);
}
