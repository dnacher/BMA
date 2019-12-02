package com.bma.domain.service;

import com.bma.api.dtos.AttendanceDTO;
import com.bma.api.dtos.AttendanceEvaluationDTO;
import com.bma.domain.service.mappers.AttendanceEvaluationMapper;
import com.bma.domain.service.mappers.AttendanceMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.AttendanceDAO;
import com.bma.persistence.dao.AttendanceEvaluationDAO;
import com.bma.persistence.model.Attendance;
import com.bma.persistence.model.AttendanceEvaluation;
import com.bma.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    private final AttendanceDAO attendanceDAO;
    private final AttendanceEvaluationDAO attendanceEvaluationDAO;
    private final AttendanceMapper attendanceMapper;
    private final AttendanceEvaluationMapper attendanceEvaluationMapper;

    @Autowired
    public AttendanceService(AttendanceDAO attendanceDAO, AttendanceMapper attendanceMapper, AttendanceEvaluationDAO attendanceEvaluationDAO, AttendanceEvaluationMapper attendanceEvaluationMapper){
        this.attendanceMapper = attendanceMapper;
        this.attendanceDAO = attendanceDAO;
        this.attendanceEvaluationDAO = attendanceEvaluationDAO;
        this.attendanceEvaluationMapper= attendanceEvaluationMapper;
    }

    public List<AttendanceDTO> saveAttendances(List<AttendanceDTO> attendanceDTOList){
        attendanceDTOList.stream().forEach(attendanceDTO -> {
            attendanceDTO.setDate(Utils.setTodayDate());
        });
        attendanceDTOList = attendanceMapper.mapToDTOList(this.attendanceDAO.saveAttendances(attendanceMapper.mapToEntityList(attendanceDTOList)));
        saveAttendanceEvaluationList(attendanceMapper.mapToEntityList(attendanceDTOList));
        return attendanceDTOList;
    }

    public AttendanceDTO saveAttendance(AttendanceDTO attendanceDTO) throws BMAException{
        try {
            attendanceDTO.setDate(Utils.setTodayDate());
            Attendance attendance = attendanceMapper.mapToEntity(attendanceDTO);
            AttendanceEvaluation attendanceEvaluation = this.attendanceEvaluationDAO.getAttendanceEvaluationByChurchMember(attendance.getChurchMember());
            if(attendanceEvaluation!=null){
                AttendanceEvaluationDTO attendanceEvaluationDTO = attendanceEvaluationMapper.mapToDTO(attendanceEvaluation);
                attendanceEvaluationDTO.setAttendedValue(attendanceDTO.getAttendanceValue());
                attendanceEvaluation = this.attendanceEvaluationMapper.mapToEntity(attendanceEvaluationDTO);
                attendanceEvaluationDAO.updateAttendanceEvaluation(attendanceEvaluation);
            }else{
                this.saveAttendanceEvaluation(attendanceDTO);
            }
            attendanceDTO = attendanceMapper.mapToDTO(this.attendanceDAO.saveAttendance(attendance));
            return attendanceDTO;
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteAttendance(AttendanceDTO attendanceDTO){
        this.attendanceDAO.deleteAttendance(attendanceMapper.mapToEntity(attendanceDTO));
    }

    public AttendanceDTO updateAttendance(AttendanceDTO attendanceDTO) throws BMAException{
        try {
            Attendance attendance = this.attendanceDAO.updateAttendance(attendanceMapper.mapToEntity(attendanceDTO));
            attendanceDTO = this.attendanceMapper.mapToDTO(attendance);
            AttendanceEvaluation attendanceEvaluation = this.attendanceEvaluationDAO.getAttendanceEvaluationByChurchMember(attendance.getChurchMember());
            AttendanceEvaluationDTO attendanceEvaluationDTO = attendanceEvaluationMapper.mapToDTO(attendanceEvaluation);
            attendanceEvaluationDTO.setAttended1(attendance.getAttendanceValue());
            attendanceEvaluation = this.attendanceEvaluationMapper.mapToEntity(attendanceEvaluationDTO);
            attendanceEvaluationDAO.updateAttendanceEvaluation(attendanceEvaluation);
            return attendanceDTO;
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

    public void saveAttendanceEvaluation(AttendanceDTO attendance){
        AttendanceEvaluationDTO attendanceEvaluationDTO = new AttendanceEvaluationDTO();
        attendanceEvaluationDTO.setMember(attendance.getChurchMember());
        attendanceEvaluationDTO.setLastUpdate(attendance.getDate());
        attendanceEvaluationDTO.setAttended1(attendance.getAttendanceValue());
        attendanceEvaluationDTO.getAttendanceValueEvaluation();
        attendanceEvaluationDAO.saveAttendanceEvaluation(this.attendanceEvaluationMapper.mapToEntity(attendanceEvaluationDTO));
    }

    public void saveAttendanceEvaluationList(List<Attendance> attendances){
        attendances.forEach(attendance -> {
            AttendanceEvaluation attendanceEvaluation = this.attendanceEvaluationDAO.getAttendanceEvaluationByChurchMember(attendance.getChurchMember());
            AttendanceEvaluationDTO attendanceEvaluationDTO = attendanceEvaluationMapper.mapToDTO(attendanceEvaluation);
            attendanceEvaluationDTO.setAttended1(attendance.getAttendanceValue());
            attendanceEvaluation = this.attendanceEvaluationMapper.mapToEntity(attendanceEvaluationDTO);
            attendanceEvaluationDAO.updateAttendanceEvaluation(attendanceEvaluation);
        });
    }
}
