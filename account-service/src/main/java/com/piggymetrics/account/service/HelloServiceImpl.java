package com.piggymetrics.account.service;

import com.piggymetrics.account.client.HelloServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    private final HelloServiceClient helloClient;

    @Autowired
    public HelloServiceImpl(HelloServiceClient helloClient) {
        this.helloClient = helloClient;
    }

    @Override
    public String getHello() {
        return helloClient.getHelloFromHelloService();
    }
}
