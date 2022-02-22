package com.piggymetrics.account.controller;

import com.piggymetrics.account.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello-world from account-service!";
    }

    @GetMapping("/greet")
    public String greet() {
        return helloService.getHello();
    }
}
