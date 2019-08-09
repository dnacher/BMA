package com.bma.domain.service;

import com.bma.api.dtos.AttendanceEvaluationDTO;
import com.bma.domain.service.mappers.AttendanceEvaluationMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.AttendanceEvaluationDAO;
import com.bma.persistence.model.AttendanceEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class AttendanceEvaluationService {

    private final AttendanceEvaluationDAO attendanceEvaluationDAO;
    private final AttendanceEvaluationMapper attendanceEvaluationMapper;

    @Autowired
    public AttendanceEvaluationService(AttendanceEvaluationDAO attendanceEvaluationDAO, AttendanceEvaluationMapper attendanceEvaluationMapper){
        this.attendanceEvaluationMapper = attendanceEvaluationMapper;
        this.attendanceEvaluationDAO = attendanceEvaluationDAO;
    }

    public AttendanceEvaluationDTO saveCalling(AttendanceEvaluationDTO attendanceEvaluationDTO) throws BMAException{
        try {
            AttendanceEvaluation attendanceEvaluation = attendanceEvaluationMapper.mapToEntity(attendanceEvaluationDTO);
            return attendanceEvaluationMapper.mapToDTO(this.attendanceEvaluationDAO.saveAttendanceEvaluation(attendanceEvaluation));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteAttendanceEvaluation(AttendanceEvaluationDTO attendanceEvaluationDTO){

        this.attendanceEvaluationDAO.deleteAttendanceEvaluation(attendanceEvaluationMapper.mapToEntity(attendanceEvaluationDTO));
    }

    public AttendanceEvaluationDTO updateAttendanceEvaluation(AttendanceEvaluationDTO attendanceEvaluationDTO) throws BMAException{
        try {
            return this.attendanceEvaluationMapper.mapToDTO(this.attendanceEvaluationDAO.updateAttendanceEvaluation(attendanceEvaluationMapper.mapToEntity(attendanceEvaluationDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<AttendanceEvaluationDTO> getAttendanceEvaluations(){
        List<AttendanceEvaluation> attendanceEvaluations = this.attendanceEvaluationDAO.getAttendanceEvaluation();
        return attendanceEvaluations.stream().map(calling -> this.attendanceEvaluationMapper.mapToDTO(calling)).collect(Collectors.toList());
    }

    public AttendanceEvaluationDTO getAttendanceById(Integer id) throws BMAException{
        try {
            return this.attendanceEvaluationMapper.mapToDTO(this.attendanceEvaluationDAO.getAttendanceEvaluationById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
