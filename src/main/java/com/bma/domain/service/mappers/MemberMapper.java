package com.bma.domain.service.mappers;

import org.springframework.stereotype.Component;

import com.bma.api.dtos.CallingDTO;
import com.bma.api.dtos.MemberDTO;
import com.bma.persistence.model.Calling;
import com.bma.persistence.model.Member;

@Component
public class MemberMapper implements AbstractMapper<Member, MemberDTO> {


    @Override
    public Member mapToEntity(MemberDTO dto) {
        Member member = new Member();
        member.setId(dto.getId());
        member.setName(dto.getName());
        member.setSurname(dto.getSurname());
        member.setCalling(dto.getCalling());
        return  member;
    }

    @Override
    public MemberDTO mapToDTO(Member entity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(entity.getId());
        memberDTO.setName(entity.getName());
        memberDTO.setSurname(entity.getSurname());
        memberDTO.setCalling(entity.getCalling());
        return memberDTO;
    }
}
