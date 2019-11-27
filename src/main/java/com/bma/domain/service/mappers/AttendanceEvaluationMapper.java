package com.bma.domain.service.mappers;

import com.bma.api.dtos.AttendanceEvaluationDTO;
import com.bma.persistence.model.AttendanceEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttendanceEvaluationMapper implements AbstractMapper<AttendanceEvaluation, AttendanceEvaluationDTO>{

    @Autowired
    public ChurchMemberMapper churchMemberMapper;

    @Override
    public AttendanceEvaluation mapToEntity(AttendanceEvaluationDTO dto) {
        AttendanceEvaluation entity = new AttendanceEvaluation();
        entity.setId(dto.getId());
        entity.setMember(churchMemberMapper.mapToEntity(dto.getMember()));
        entity.setAttended1(dto.getAttended1());
        entity.setAttended2(dto.getAttended2());
        entity.setAttended3(dto.getAttended3());
        entity.setAttended4(dto.getAttended4());
        entity.setLastUpdate(dto.getLastUpdate());
        entity.setAttendance(dto.getAttendance());
        return entity;
    }

    @Override
    public AttendanceEvaluationDTO mapToDTO(AttendanceEvaluation entity) {
        AttendanceEvaluationDTO attendanceEvaluationDTO = new AttendanceEvaluationDTO();
        attendanceEvaluationDTO.setId(entity.getId());
        attendanceEvaluationDTO.setMember(churchMemberMapper.mapToDTO(entity.getChurchMember()));
        attendanceEvaluationDTO.setAttended1(entity.getAttended1());
        attendanceEvaluationDTO.setAttended2(entity.getAttended2());
        attendanceEvaluationDTO.setAttended3(entity.getAttended3());
        attendanceEvaluationDTO.setAttended4(entity.getAttended4());
        attendanceEvaluationDTO.setLastUpdate(entity.getLastUpdate());
        attendanceEvaluationDTO.setAttendance(entity.getAttendance());
        return attendanceEvaluationDTO;
    }
}
