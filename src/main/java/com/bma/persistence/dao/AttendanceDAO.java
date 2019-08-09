package com.bma.persistence.dao;

import com.bma.exception.BMAException;
import com.bma.persistence.model.Attendance;
import com.bma.persistence.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttendanceDAO {

    @Autowired
    private AttendanceRepository repository;

    public List<Attendance> getAttendance(){
        List<Attendance> attendances = new ArrayList<>();
        this.repository.findAll().forEach(attendance -> attendances.add(attendance));
        return attendances;
    }

    public Attendance getAttendanceById(Integer id) throws BMAException{
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The attendance id %s does not exist", id.toString());
            return new BMAException(msg);
        });
    }

    public Attendance saveAttendance(Attendance attendance) throws BMAException{
        if(attendance.getId()!=null){
            String msg = String.format("Cannot save an Attendance with Id");
            throw new BMAException(msg);
        }else{
            return this.repository.save(attendance);
        }
    }

    public void deleteAttendance(Attendance attendance){
        this.repository.delete(attendance);
    }

    public Attendance updateAttendance(Attendance attendance) throws BMAException{
        if(attendance.getId()!=null){
            return this.repository.save(attendance);
        }else{
            String msg = String.format("Cannot update an attendance without an Id");
            throw new BMAException(msg);
        }
    }

}
