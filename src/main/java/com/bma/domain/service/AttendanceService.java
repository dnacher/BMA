package com.bma.domain.service;

import com.bma.api.dtos.AttendanceDTO;
import com.bma.domain.service.mappers.AttendanceMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.AttendanceDAO;
import com.bma.persistence.model.Attendance;
import com.bma.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class AttendanceService {

    private final AttendanceDAO attendanceDAO;
    private final AttendanceMapper attendanceMapper;

    @Autowired
    public AttendanceService(AttendanceDAO attendanceDAO, AttendanceMapper attendanceMapper){
        this.attendanceMapper = attendanceMapper;
        this.attendanceDAO = attendanceDAO;
    }

    public AttendanceDTO saveAttendance(AttendanceDTO attendanceDTO) throws BMAException{
        try {
            Attendance attendance = attendanceMapper.mapToEntity(attendanceDTO);
            return attendanceMapper.mapToDTO(this.attendanceDAO.saveAttendance(attendance));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteAttendance(AttendanceDTO attendanceDTO){

        this.attendanceDAO.deleteAttendance(attendanceMapper.mapToEntity(attendanceDTO));
    }

    public AttendanceDTO updateAttendance(AttendanceDTO attendanceDTO) throws BMAException{
        try {
            return this.attendanceMapper.mapToDTO(this.attendanceDAO.updateAttendance(attendanceMapper.mapToEntity(attendanceDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<AttendanceDTO> getAttendances(){
        List<Attendance> attendances = this.attendanceDAO.getAttendance();
        return attendances.stream().map(calling -> this.attendanceMapper.mapToDTO(calling)).collect(Collectors.toList());
    }

    public AttendanceDTO getAttendanceById(Integer id) throws BMAException{
        try {
            return this.attendanceMapper.mapToDTO(this.attendanceDAO.getAttendanceById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<AttendanceDTO> createOrGetAttendance(){
        Date today = Utils.setTodayDate();
        List<Attendance> attendances = this.attendanceDAO.getAttendanceByDate(today);
        if(attendances.size()==0){
            attendances = this.attendanceDAO.createAttendance();
        }
        return attendances.stream().map(attendance -> this.attendanceMapper.mapToDTO(attendance)).collect(Collectors.toList());
    }
}
