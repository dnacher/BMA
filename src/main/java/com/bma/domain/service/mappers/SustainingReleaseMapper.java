package com.bma.domain.service.mappers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.api.dtos.SustainingReleaseDTO;
import com.bma.persistence.model.SustainingRelease;

@Component
public class SustainingReleaseMapper implements AbstractMapper<SustainingRelease, SustainingReleaseDTO> {


    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private CallingMapper callingMapper;

    @Override
    public SustainingRelease mapToEntity(SustainingReleaseDTO dto) {
        SustainingRelease sustainingRelease = new SustainingRelease();
        sustainingRelease.setId(dto.getId());
        sustainingRelease.setMember(this.memberMapper.mapToEntity(dto.getMember()));
        sustainingRelease.setCalling(this.callingMapper.mapToEntity(dto.getCalling()));
        sustainingRelease.setInitDate(dto.getInitDate());
        sustainingRelease.setEndDate(dto.getEndDate());
        return  sustainingRelease;
    }

    @Override
    public SustainingReleaseDTO mapToDTO(SustainingRelease entity) {
        SustainingReleaseDTO sustainingReleaseDTO = new SustainingReleaseDTO();
        sustainingReleaseDTO.setId(entity.getId());
        sustainingReleaseDTO.setMember(this.memberMapper.mapToDTO(entity.getMember()));
        sustainingReleaseDTO.setCalling(this.callingMapper.mapToDTO(entity.getCalling()));
        sustainingReleaseDTO.setInitDate(entity.getInitDate());
        sustainingReleaseDTO.setEndDate(entity.getEndDate());
        return sustainingReleaseDTO;
    }

    public Set<SustainingRelease> mapToEntitySet(Set<SustainingReleaseDTO> dtos) {
        Set<SustainingRelease> sustainingReleaseSet = new HashSet<>();
        dtos.forEach(sustainingReleaseDTO -> sustainingReleaseSet.add(this.mapToEntity(sustainingReleaseDTO)));
        return sustainingReleaseSet;
    }


    public Set<SustainingReleaseDTO> mapToDTOSet(Set<SustainingRelease> entities) {
        Set<SustainingReleaseDTO> sustainingReleaseDTOSet = new HashSet<>();
        entities.forEach(sustainingRelease -> sustainingReleaseDTOSet.add(this.mapToDTO((sustainingRelease))));
        return sustainingReleaseDTOSet;
    }
}
