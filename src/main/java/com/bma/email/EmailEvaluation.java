package com.bma.email;

import com.bma.api.dtos.AttendanceEvaluationDTO;
import com.bma.domain.service.AttendanceEvaluationService;
import com.bma.persistence.model.AttendanceEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailEvaluation {

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

    public EmailObject createEmailObject(){
        List<AttendanceEvaluationDTO> attendanceEvaluations = attendanceEvaluationService.getAttendanceEvaluations();
        EmailObject emailObject = new EmailObject();
        for(AttendanceEvaluationDTO attendanceEvaluation: attendanceEvaluations){
            if(!checkAttendance(attendanceEvaluation).equals(AttendanceConstant.NNNNN)){
                switch (checkAttendance(attendanceEvaluation).getEmailType()){
                    case "DownEmail":
                        emailObject.getDownEmail().add(attendanceEvaluation.getMember().getFullname());
                        break;
                    case "UpEmail":
                        emailObject.getUpEmail().add(attendanceEvaluation.getMember().getFullname());
                        break;
                    case "Z":
                        emailObject.getZ().add(attendanceEvaluation.getMember().getFullname());
                        break;
                    case "LastReminder":
                        emailObject.getLastReminder().add(attendanceEvaluation.getMember().getFullname());
                        break;
                }
            }
        }
        return emailObject;
    }
}