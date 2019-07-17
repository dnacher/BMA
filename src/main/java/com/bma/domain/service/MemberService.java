package com.bma.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.MemberDTO;
import com.bma.domain.service.mappers.MemberMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.MemberDAO;
import com.bma.persistence.model.Member;

@Service
public class MemberService {

    private final MemberDAO memberDAO;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberDAO memberDAO, MemberMapper memberMapper){
        this.memberDAO = memberDAO;
        this.memberMapper = memberMapper;
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

    public MemberDTO getMemberById(Integer id) throws BMAException{
        try {
            return this.memberMapper.mapToDTO(this.memberDAO.getMemberById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
