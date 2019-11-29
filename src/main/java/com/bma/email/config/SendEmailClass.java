package com.bma.email.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class SendEmailClass {

    private static Logger log = LoggerFactory.getLogger(SendEmailClass.class);

    @Autowired
    private EmailService emailService;

    public void sendingEmail() throws Exception {
        log.info("Sending Email with Freemarker HTML Template Example");

        Mail mail = new Mail();
        mail.setFrom("no-reply@gmail.com");
        mail.setTo("danielnacher@gmail.com");
        mail.setSubject("Sending Email with Freemarker HTML Template Example");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "Daniel Nacher");
        model.put("location", "Uruguay");
        model.put("signature", "This is a signature");
        mail.setModel(model);

        emailService.sendSimpleMessage(mail);
    }
}
