package com.bma.domain.service.mappers;

import com.bma.persistence.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bma.api.dtos.MemberDTO;
import com.bma.persistence.model.Member;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberMapper implements AbstractMapper<Member, MemberDTO> {

    @Autowired
    private CallingMapper callingMapper;

    @Override
    public Member mapToEntity(MemberDTO dto) {
        Member member = new Member();
        member.setId(dto.getId());
        member.setName(dto.getName());
        member.setSurname(dto.getSurname());
        member.setFullname(dto.getFullname());
        if(dto.getCalling()!=null) {
            member.setCalling(callingMapper.mapToEntity(dto.getCalling()));
        }
        if(dto.getCalling()!=null){
            member.setOrganization(Organization.valueOf(dto.getOrganization()));
        }
        return  member;
    }

    @Override
    public MemberDTO mapToDTO(Member entity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(entity.getId());
        memberDTO.setName(entity.getName());
        memberDTO.setSurname(entity.getSurname());
        memberDTO.setFullname(entity.getFullname());
        if(entity.getCalling()!=null) {
            memberDTO.setCalling(callingMapper.mapToDTO(entity.getCalling()));
        }
        if(entity.getOrganization()!=null){
            memberDTO.setOrganization(entity.getOrganization().toString());
        }
        return memberDTO;
    }

    public List<Member> mapToEntityList(List<MemberDTO> dtos){
        List<Member> members = new ArrayList<>();
        dtos.forEach(memberDTO -> {
            members.add(mapToEntity(memberDTO));
        });
        return members;
    }

    public List<MemberDTO> mapToDTOList(List<Member> members){
        List<MemberDTO> memberDTOS = new ArrayList<>();
        members.forEach(member -> {
            memberDTOS.add(mapToDTO(member));
        });
        return memberDTOS;
    }
}
