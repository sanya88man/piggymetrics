package com.piggymetrics.hello.service.email;

import com.piggymetrics.hello.dto.Letter;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

//@Profile("dev")
@Service
@AllArgsConstructor
public class EmailTemplateServiceFreemarker implements EmailTemplateService {
    private final Configuration configuration;

    public String getEmailContent(Letter letter) {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("email", letter.getEmail());
        model.put("cash", letter.getCash());
        try {
            configuration.getTemplate("index1.ftl").process(model, stringWriter);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
        return stringWriter.getBuffer().toString();
    }
}
