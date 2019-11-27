package com.bma.persistence.dao;

import com.bma.domain.service.ChurchMemberService;
import com.bma.domain.service.mappers.ChurchMemberMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.model.Attendance;
import com.bma.persistence.model.ChurchMember;
import com.bma.persistence.repository.AttendanceRepository;
import com.bma.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Component
public class AttendanceDAO {

    @Autowired
    private AttendanceRepository repository;

    @Autowired
    private ChurchMemberService churchMemberService;

    @Autowired
    private ChurchMemberMapper churchMemberMapper;

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
        return this.repository.save(attendance);
    }

    public void deleteAttendance(Attendance attendance){
        this.repository.delete(attendance);
    }

    public Attendance updateAttendance(Attendance attendance) throws BMAException{
        if(attendance.getId()!=null){
            attendance.setDate(Utils.addHoursToJavaUtilDate(attendance.getDate()));
            attendance = this.repository.save(attendance);
            return attendance;
        }else{
            String msg = String.format("Cannot update an attendance without an Id");
            throw new BMAException(msg);
        }
    }

    public List<Attendance> createAttendance(){
        List<ChurchMember> members = this.churchMemberMapper.mapToEntityList(this.churchMemberService.getMembers());
        List<Attendance> attendances = new ArrayList<>();
        Date today = Utils.setDateToSave(Utils.setTodayDate());
        members.forEach(member -> {
            Attendance attendance = new Attendance();
            attendance.setAttended(false);
            attendance.setDate(today);
            attendance.setChurchMember(member);
            attendances.add(attendance);
                });
        return attendances;
    }

    public List<Attendance> getAttendanceByDate(Date date){
        date.setHours(16);
        return this.repository.findAllByDate(date);
    }
}
