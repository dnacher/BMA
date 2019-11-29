package com.bma.domain.service.mappers;

import com.bma.persistence.model.Attendance;
import com.bma.api.dtos.AttendanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttendanceMapper implements AbstractMapper<Attendance, AttendanceDTO>{

    @Autowired
    private ChurchMemberMapper churchMemberMapper;

    @Override
    public Attendance mapToEntity(AttendanceDTO dto) {
        Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
        attendance.setChurchMember(churchMemberMapper.mapToEntity(dto.getChurchMember()));
        attendance.setAttended(dto.isAttended());
        attendance.setDate(dto.getDate());
        return attendance;
    }

    public List<Attendance> mapToEntityList(List<AttendanceDTO> dtos) {
        List<Attendance> attendances = new ArrayList<>();
        dtos.forEach(attendanceDTO -> {
            attendances.add(mapToEntity(attendanceDTO));
        });
        return attendances;
    }

    @Override
    public AttendanceDTO mapToDTO(Attendance entity) {
        AttendanceDTO attendanceDTO = new AttendanceDTO();
        attendanceDTO.setId(entity.getId());
        attendanceDTO.setChurchMember(churchMemberMapper.mapToDTO(entity.getChurchMember()));
        attendanceDTO.setAttended(entity.isAttended());
        attendanceDTO.setDate(entity.getDate());
        return attendanceDTO;
    }

    public List<AttendanceDTO> mapToDTOList(List<Attendance> entities) {
        List<AttendanceDTO> attendanceDTOs = new ArrayList<>();
        entities.forEach(entity -> {
            attendanceDTOs.add(mapToDTO(entity));
        });
        return attendanceDTOs;
    }
}
