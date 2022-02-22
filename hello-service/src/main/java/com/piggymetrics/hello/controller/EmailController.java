package com.piggymetrics.hello.controller;

import com.piggymetrics.hello.dto.Letter;
import com.piggymetrics.hello.service.email.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class EmailController {
    private final EmailSenderService emailSenderService;

    @GetMapping("/mail3")
    public String sendWinnerLetter(@RequestBody Letter letter) {
        emailSenderService.sendWinnerEmail(letter);
        return "Winner letter sent successfully!";
    }
}
