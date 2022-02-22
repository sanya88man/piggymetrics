package com.piggymetrics.hello.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "account-service")
public interface AccountServiceClient {
    @GetMapping("/accounts/hello")
    String getHelloFromAccountService();
}
