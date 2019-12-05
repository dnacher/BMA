package com.bma.email.config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Configuration freemarkerConfig;

    private static final String BMA_CANCEL = "templates/images/cancel.png";
    private static final String BMA_CHECKED = "templates/images/checked.png";
    private static final String BMA_LOADING = "templates/images/loading.png";

    public void sendSimpleMessage(Mail mail) throws MessagingException, IOException, TemplateException {
        MimeMessage message = this.emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Template t = this.freemarkerConfig.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());
        helper.setCc(InternetAddress.parse("danielnacher@gmail.com"));
        helper.setText(html, true);
        helper.addInline("cancel", new ClassPathResource(BMA_CANCEL));
        helper.addInline("loading", new ClassPathResource(BMA_LOADING));
        helper.addInline("checked", new ClassPathResource(BMA_CHECKED));
        helper.setSubject("Attendance status email");
        helper.setFrom(mail.getFrom());
        this.emailSender.send(message);
    }

}
