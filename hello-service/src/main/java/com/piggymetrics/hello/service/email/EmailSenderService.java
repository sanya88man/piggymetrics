package com.piggymetrics.hello.service.email;

import com.piggymetrics.hello.dto.Letter;

public interface EmailSenderService {
    void sendWinnerEmail(Letter letter);
}
