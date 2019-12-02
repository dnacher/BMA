package com.bma.email;

import com.bma.api.dtos.AttendanceEvaluationDTO;
import com.bma.domain.service.AttendanceEvaluationService;
import com.bma.email.config.EmailService;
import com.bma.email.config.Mail;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmailEvaluation {

    private static Logger log = LoggerFactory.getLogger(EmailEvaluation.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    public AttendanceEvaluationService attendanceEvaluationService;

    public AttendanceConstant checkAttendance(AttendanceEvaluationDTO attendanceEvaluation){
        for(AttendanceConstant value: AttendanceConstant.values()){
            if(attendanceEvaluation.getAttendance().equals(value.getAttendance())){
                return value;
            }
        }
        return AttendanceConstant.NNNNN;
    }

    public void createEmailObject(){
        List<AttendanceEvaluationDTO> attendanceEvaluations = attendanceEvaluationService.getAttendanceEvaluations();
        EmailObject emailObject = new EmailObject();
        for(AttendanceEvaluationDTO attendanceEvaluation: attendanceEvaluations){
            if(!checkAttendance(attendanceEvaluation).equals(AttendanceConstant.NNNNN)){
                EmailItem emailItem = new EmailItem();
                emailItem.setFullName(attendanceEvaluation.getMember().getFullname());
                emailItem.setAttendance(attendanceEvaluation.getAttendance());
                switch (checkAttendance(attendanceEvaluation).getEmailType()){
                    case "DownEmail":
                        emailObject.getDownEmail().add(emailItem);
                        break;
                    case "UpEmail":
                        emailObject.getUpEmail().add(emailItem);
                        break;
                    case "Z":
                        emailObject.getZ().add(emailItem);
                        break;
                    case "LastReminder":
                        emailObject.getLastReminder().add(emailItem);
                        break;
                }
            }
        }

        sendEmail(emailObject);
    }

    public void sendEmail(EmailObject emailObject){
        Mail mail = new Mail();
        mail.setFrom("no-reply@gmail.com");
        mail.setTo("danielnacher@gmail.com");
        mail.setSubject("Attendance status email");

        Map<String, Object> model = new HashMap<>();
        model.put("emailObject", emailObject);
        mail.setModel(model);

        try {
            emailService.sendSimpleMessage(mail);
        } catch (MessagingException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (TemplateException e) {
            log.error(e.getMessage());
        }
    }
}