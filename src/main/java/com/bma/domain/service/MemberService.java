package com.bma.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.bma.api.dtos.AttendanceDTO;
import com.bma.domain.service.mappers.AttendanceMapper;
import com.bma.persistence.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.MemberDTO;
import com.bma.domain.service.mappers.MemberMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.MemberDAO;
import com.bma.persistence.model.Member;

@Transactional
@Service
public class MemberService {

    private final MemberDAO memberDAO;
    private final MemberMapper memberMapper;
    private final AttendanceMapper attendanceMapper;

    @Autowired
    public MemberService(MemberDAO memberDAO, MemberMapper memberMapper, AttendanceMapper attendanceMapper){
        this.memberDAO = memberDAO;
        this.memberMapper = memberMapper;
        this.attendanceMapper = attendanceMapper;
    }

    public MemberDTO saveMember(MemberDTO memberDTO) throws BMAException{
        try {
            Member member = memberMapper.mapToEntity(memberDTO);
            return memberMapper.mapToDTO(this.memberDAO.saveMember(member));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteMember(MemberDTO memberDTO){

        this.memberDAO.deleteMember(memberMapper.mapToEntity(memberDTO));
    }

    public MemberDTO updateMember(MemberDTO memberDTO) throws BMAException{
        try {
            return this.memberMapper.mapToDTO(this.memberDAO.updateMember(memberMapper.mapToEntity(memberDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<MemberDTO> getMembers(){
        List<Member> members = this.memberDAO.getMembers();
        return members.stream().map(member -> this.memberMapper.mapToDTO(member)).collect(Collectors.toList());
    }

    public List<AttendanceDTO> getMembersTest(){
        List<Member> members = this.memberDAO.getMembers().stream().limit(10).collect(Collectors.toList());
        List<Attendance> attendances = new ArrayList<>();
        Date date = new Date();
        members.forEach(member -> {
            Attendance attendance = new Attendance();
            attendance.setMember(member);
            attendance.setDate(date);
            attendance.setAttended(false);
            attendances.add(attendance);
        });
        List<AttendanceDTO>attendanceDTOS = attendances.stream().map(attendance -> this.attendanceMapper.mapToDTO(attendance)).collect(Collectors.toList());
        return attendanceDTOS;
    }

    public MemberDTO getMemberById(Integer id) throws BMAException{
        try {
            return this.memberMapper.mapToDTO(this.memberDAO.getMemberById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
