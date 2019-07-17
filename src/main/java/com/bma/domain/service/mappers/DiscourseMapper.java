package com.bma.domain.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.api.dtos.DiscourseDTO;
import com.bma.persistence.model.Discourse;

@Component
public class DiscourseMapper implements AbstractMapper<Discourse, DiscourseDTO> {

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public Discourse mapToEntity(DiscourseDTO dto) {
        Discourse discourse = new Discourse();
        discourse.setId(dto.getId());
        discourse.setAssignedBy(memberMapper.mapToEntity(dto.getAssignedBy()));
        discourse.setDate(dto.getDate());
        discourse.setMember(memberMapper.mapToEntity(dto.getMemberDTO()));
        discourse.setTopic(dto.getTopic());
        return discourse;
    }

    @Override
    public DiscourseDTO mapToDTO(Discourse entity) {
        DiscourseDTO discourseDTO = new DiscourseDTO();
        discourseDTO.setId(entity.getId());
        discourseDTO.setMemberDTO(memberMapper.mapToDTO(entity.getMember()));
        discourseDTO.setTopic(entity.getTopic());
        discourseDTO.setDate(entity.getDate());
        discourseDTO.setAssignedBy(memberMapper.mapToDTO(entity.getAssignedBy()));
        return discourseDTO;
    }

    public List<Discourse> mapToEntityList(List<DiscourseDTO> dtos) {
        List<Discourse> discourses = new ArrayList<>();
        dtos.forEach(discourseDTO -> discourses.add(this.mapToEntity(discourseDTO)));
        return discourses;
    }

    public List<DiscourseDTO> mapToDTOList(List<Discourse> entities) {
        List<DiscourseDTO> discourseDTOList = new ArrayList<>();
        entities.forEach(discourse -> discourseDTOList.add(mapToDTO(discourse)));
        return discourseDTOList;
    }
}
