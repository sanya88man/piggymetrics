package com.piggymetrics.hello.controller;

import com.piggymetrics.hello.service.hello.HelloService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class HelloController {
    private final HelloService helloService;

    @GetMapping("/hello-world")
    public String sayHello() {
        return "Hello world from hello-service!";
    }

    @GetMapping("/greet")
    public String greet() {
        return helloService.getHello();
    }

    @GetMapping("/mail")
    public String sendEmail() {
        helloService.sendEmail();
        return "Email sent successfully!";
    }

    @GetMapping("/mail1")
    public String sendEmailWithAttach() {
        helloService.sendEmailWithAttachment();
        return "Email with attach sent successfully!";
    }
}
