package com.bma.persistence.dao;

import com.bma.domain.service.MemberService;
import com.bma.domain.service.mappers.MemberMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.model.Attendance;
import com.bma.persistence.model.Member;
import com.bma.persistence.repository.AttendanceRepository;
import com.bma.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AttendanceDAO {

    @Autowired
    private AttendanceRepository repository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

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
            return this.repository.save(attendance);
        }else{
            String msg = String.format("Cannot update an attendance without an Id");
            throw new BMAException(msg);
        }
    }

    public List<Attendance> createAttendance(){
        List<Member> members = this.memberMapper.mapToEntityList(this.memberService.getMembers());
        List<Attendance> attendances = new ArrayList<>();
        Date today = Utils.setDateToSave(Utils.setTodayDate());
        members.forEach(member -> {
            Attendance attendance = new Attendance();
            attendance.setAttended(false);
            attendance.setDate(today);
            attendance.setMember(member);
            attendances.add(attendance);
                });
        return attendances;
    }

    public List<Attendance> getAttendanceByDate(Date date){
        return this.repository.findAllByDate(date);
    }

}