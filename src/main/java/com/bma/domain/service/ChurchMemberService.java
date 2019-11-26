package com.bma.domain.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.bma.api.dtos.AttendanceDTO;
import com.bma.domain.service.mappers.AttendanceMapper;
import com.bma.persistence.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.ChurchMemberDTO;
import com.bma.domain.service.mappers.ChurchMemberMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.ChurchMemberDAO;
import com.bma.persistence.model.ChurchMember;

@Transactional
@Service
public class ChurchMemberService {

    private final ChurchMemberDAO churchMemberDAO;
    private final ChurchMemberMapper churchMemberMapper;
    private final AttendanceMapper attendanceMapper;

    @Autowired
    public ChurchMemberService(ChurchMemberMapper churchMemberMapper, AttendanceMapper attendanceMapper, ChurchMemberDAO churchMemberDAO){
        this.churchMemberDAO = churchMemberDAO;
        this.churchMemberMapper = churchMemberMapper;
        this.attendanceMapper = attendanceMapper;
    }

    public ChurchMemberDTO saveMember(ChurchMemberDTO churchMemberDTO) throws BMAException{
        try {
            ChurchMember churchMember = churchMemberMapper.mapToEntity(churchMemberDTO);
            return churchMemberMapper.mapToDTO(this.churchMemberDAO.saveChurchMember(churchMember));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteMember(Integer memberId){
        this.churchMemberDAO.deleteChurchMember(memberId);
    }

    public ChurchMemberDTO updateMember(ChurchMemberDTO churchMemberDTO) throws BMAException{
        try {
            return this.churchMemberMapper.mapToDTO(this.churchMemberDAO.updateChurchMember(churchMemberMapper.mapToEntity(churchMemberDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<ChurchMemberDTO> getMembers(){
        List<ChurchMember> members = this.churchMemberDAO.getChurchMembers();
        return members.stream().map(member -> this.churchMemberMapper.mapToDTO(member)).collect(Collectors.toList());
    }

    public List<AttendanceDTO> getMembersTest(){
        List<ChurchMember> members = this.churchMemberDAO.getChurchMembers();
        List<Attendance> attendances = members.stream().map(churchMember -> {
            Date date = new Date();
            Attendance attendance = new Attendance();
            attendance.setChurchMember(churchMember);
            attendance.setDate(date);
            attendance.setAttended(false);
            return attendance;
        }).collect(Collectors.toList());
        List<AttendanceDTO>attendanceDTOS = attendances.stream().map(attendance -> this.attendanceMapper.mapToDTO(attendance)).collect(Collectors.toList());
        return attendanceDTOS;
    }

    public ChurchMemberDTO getMemberById(Integer id) throws BMAException{
        try {
            return this.churchMemberMapper.mapToDTO(this.churchMemberDAO.getChurchMemberById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
