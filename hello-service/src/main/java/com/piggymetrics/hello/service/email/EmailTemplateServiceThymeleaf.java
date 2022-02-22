package com.piggymetrics.hello.service.email;

import com.piggymetrics.hello.dto.Letter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Profile("dev")
@Service
@AllArgsConstructor
public class EmailTemplateServiceThymeleaf implements EmailTemplateService {
    private final TemplateEngine templateEngine;

    @Override
    public String getEmailContent(Letter letter) {
        Context thymeleafContext = new Context();
        Map<String, Object> model = new HashMap<>();
        model.put("email", letter.getEmail());
        model.put("cash", letter.getCash());
        thymeleafContext.setVariables(model);
        return templateEngine.process("index.html", thymeleafContext);
    }
}
