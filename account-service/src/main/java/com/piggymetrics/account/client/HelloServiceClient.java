package com.piggymetrics.account.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hello-service")
public interface HelloServiceClient {
    @GetMapping("/hello/hello-world")
    String getHelloFromHelloService();
}
