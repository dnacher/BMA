package com.bma.persistence.dao;

import com.bma.exception.BMAException;
import com.bma.persistence.model.AttendanceEvaluation;
import com.bma.persistence.repository.AttendanceEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttendanceEvaluationDAO {

    @Autowired
    private AttendanceEvaluationRepository repository;

    public List<AttendanceEvaluation> getAttendanceEvaluation(){
        List<AttendanceEvaluation> attendanceEvaluations = new ArrayList<>();
        this.repository.findAll().forEach(attendance -> attendanceEvaluations.add(attendance));
        return attendanceEvaluations;
    }

    public AttendanceEvaluation getAttendanceEvaluationById(Integer id) throws BMAException{
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The attendance Evaluation id %s does not exist", id.toString());
            return new BMAException(msg);
        });
    }

    public AttendanceEvaluation saveAttendanceEvaluation(AttendanceEvaluation attendanceEvaluation) throws BMAException{
        if(attendanceEvaluation.getId()!=null){
            String msg = String.format("Cannot save an Attendance Evaluation with Id");
            throw new BMAException(msg);
        }else{
            return this.repository.save(attendanceEvaluation);
        }
    }

    public void deleteAttendanceEvaluation(AttendanceEvaluation attendanceEvaluation){
        this.repository.delete(attendanceEvaluation);
    }

    public AttendanceEvaluation updateAttendanceEvaluation(AttendanceEvaluation attendanceEvaluation) throws BMAException{
        if(attendanceEvaluation.getId()!=null){
            return this.repository.save(attendanceEvaluation);
        }else{
            String msg = String.format("Cannot update an attendance Evaluation without an Id");
            throw new BMAException(msg);
        }
    }

}
