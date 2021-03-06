package com.bma.domain.service.mappers;

import com.bma.persistence.model.ChurchMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bma.api.dtos.ChurchMemberDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChurchMemberMapper implements AbstractMapper<ChurchMember, ChurchMemberDTO> {

    @Autowired
    private CallingMapper callingMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public ChurchMember mapToEntity(ChurchMemberDTO dto) {
        ChurchMember member = new ChurchMember();
        member.setId(dto.getId());
        member.setName(dto.getName());
        member.setSurname(dto.getSurname());
        if(dto.getFullname()==null){
            member.setFullname(dto.getSurname() + ", " + dto.getName());
        }else {
            member.setFullname(dto.getFullname());
        }
        if (dto.getCalling() != null) {
            member.setCalling(callingMapper.mapToEntity(dto.getCalling()));
        }
        if (dto.getCalling() != null) {
            member.setOrganization(organizationMapper.mapToEntity(dto.getOrganization()));
        }
        return member;
    }

    @Override
    public ChurchMemberDTO mapToDTO(ChurchMember entity) {
        ChurchMemberDTO churchMemberDTO = new ChurchMemberDTO();
        churchMemberDTO.setId(entity.getId());
        churchMemberDTO.setName(entity.getName());
        churchMemberDTO.setSurname(entity.getSurname());
        churchMemberDTO.setFullname(entity.getFullname());
        if (entity.getCalling() != null) {
            churchMemberDTO.setCalling(callingMapper.mapToDTO(entity.getCalling()));
        }
        if (entity.getOrganization() != null) {
            churchMemberDTO.setOrganization(organizationMapper.mapToDTO(entity.getOrganization()));
        }
        return churchMemberDTO;
    }

    public List<ChurchMember> mapToEntityList(List<ChurchMemberDTO> dtos) {
        List<ChurchMember> churchMembers = new ArrayList<>();
        dtos.forEach(churchMemberDTO -> {
            churchMembers.add(mapToEntity(churchMemberDTO));
        });
        return churchMembers;
    }

    public List<ChurchMemberDTO> mapToDTOList(List<ChurchMember> churchMembers) {
        List<ChurchMemberDTO> churchMemberDTOS = new ArrayList<>();
        churchMembers.forEach(churchMember -> {
            churchMemberDTOS.add(mapToDTO(churchMember));
        });
        return churchMemberDTOS;
    }
}
