package com.bma.domain.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.api.dtos.CallingDTO;
import com.bma.api.dtos.SustainingReleaseDTO;
import com.bma.persistence.model.Calling;
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
        sustainingRelease.setMember(this.memberMapper.mapToEntity(dto.getMemberDTO()));
        sustainingRelease.setCalling(this.callingMapper.mapToEntity(dto.getCallingDTO()));
        sustainingRelease.setInitDate(dto.getInitDate());
        sustainingRelease.setEndDate(dto.getEndDate());
        return  sustainingRelease;
    }

    @Override
    public SustainingReleaseDTO mapToDTO(SustainingRelease entity) {
        SustainingReleaseDTO sustainingReleaseDTO = new SustainingReleaseDTO();
        sustainingReleaseDTO.setId(entity.getId());
        sustainingReleaseDTO.setMemberDTO(this.memberMapper.mapToDTO(entity.getMember()));
        sustainingReleaseDTO.setCallingDTO(this.callingMapper.mapToDTO(entity.getCalling()));
        sustainingReleaseDTO.setInitDate(entity.getInitDate());
        sustainingReleaseDTO.setEndDate(entity.getEndDate());
        return sustainingReleaseDTO;
    }

    public List<SustainingRelease> mapToEntityList(List<SustainingReleaseDTO> dtos) {
        List<SustainingRelease> sustainingReleaseList = new ArrayList<>();
        dtos.forEach(sustainingReleaseDTO -> sustainingReleaseList.add(this.mapToEntity(sustainingReleaseDTO)));
        return sustainingReleaseList;
    }


    public List<SustainingReleaseDTO> mapToDTOList(List<SustainingRelease> entities) {
        List<SustainingReleaseDTO> sustainingReleaseDTOList = new ArrayList<>();
        entities.forEach(sustainingRelease -> sustainingReleaseDTOList.add(this.mapToDTO((sustainingRelease))));
        return sustainingReleaseDTOList;
    }
}
