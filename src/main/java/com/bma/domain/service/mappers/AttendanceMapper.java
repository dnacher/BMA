package com.bma.domain.service.mappers;

import com.bma.persistence.model.Attendance;
import com.bma.api.dtos.AttendanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper implements AbstractMapper<Attendance, AttendanceDTO>{

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Attendance mapToEntity(AttendanceDTO dto) {
        Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
        attendance.setMember(memberMapper.mapToEntity(dto.getMember()));
        attendance.setAttended(dto.isAttended());
        attendance.setDate(dto.getDate());
        return attendance;
    }

    @Override
    public AttendanceDTO mapToDTO(Attendance entity) {
        AttendanceDTO attendanceDTO = new AttendanceDTO();
        attendanceDTO.setId(entity.getId());
        attendanceDTO.setMember(memberMapper.mapToDTO(entity.getMember()));
        attendanceDTO.setAttended(entity.isAttended());
        attendanceDTO.setDate(entity.getDate());
        return attendanceDTO;
    }
}
