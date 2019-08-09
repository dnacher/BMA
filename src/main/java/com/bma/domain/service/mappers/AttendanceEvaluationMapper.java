package com.bma.domain.service.mappers;

import com.bma.api.dtos.AttendanceEvaluationDTO;
import com.bma.persistence.model.AttendanceEvaluation;
import org.springframework.stereotype.Component;

@Component
public class AttendanceEvaluationMapper implements AbstractMapper<AttendanceEvaluation, AttendanceEvaluationDTO>{

    @Override
    public AttendanceEvaluation mapToEntity(AttendanceEvaluationDTO dto) {
        AttendanceEvaluation attendanceEvaluation = new AttendanceEvaluation();
        attendanceEvaluation.setId(dto.getId());
        attendanceEvaluation.setAttended4(dto.getAttended4());
        attendanceEvaluation.setLastUpdate(dto.getLastUpdate());
        return attendanceEvaluation;
    }

    @Override
    public AttendanceEvaluationDTO mapToDTO(AttendanceEvaluation entity) {
        AttendanceEvaluationDTO attendanceEvaluationDTO = new AttendanceEvaluationDTO();
        attendanceEvaluationDTO.setId(entity.getId());
        attendanceEvaluationDTO.setAttended1(entity.getAttended1());
        attendanceEvaluationDTO.setAttended2(entity.getAttended2());
        attendanceEvaluationDTO.setAttended3(entity.getAttended3());
        attendanceEvaluationDTO.setAttended4(entity.getAttended4());
        attendanceEvaluationDTO.setLastUpdate(entity.getLastUpdate());
        return attendanceEvaluationDTO;
    }
}
