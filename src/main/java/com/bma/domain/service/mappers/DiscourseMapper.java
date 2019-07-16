package com.bma.domain.service.mappers;

import org.springframework.stereotype.Component;

import com.bma.api.dtos.DiscourseDTO;
import com.bma.persistence.model.Discourse;

@Component
public class DiscourseMapper implements AbstractMapper<Discourse, DiscourseDTO> {


    @Override
    public Discourse mapToEntity(DiscourseDTO dto) {
        Discourse discourse = new Discourse();
        discourse.setId(dto.getId());
        discourse.setAssignedBy(dto.getAssignedBy());
        discourse.setDate(dto.getDate());
        discourse.setMember(dto.getMemberDTO());
        discourse.setTopic(dto.getTopic());
        return discourse;
    }

    @Override
    public DiscourseDTO mapToDTO(Discourse entity) {
        DiscourseDTO discourseDTO = new DiscourseDTO();
        discourseDTO.setId(entity.getId());
        discourseDTO.setMemberDTO(entity.getMember());
        discourseDTO.setTopic(entity.getTopic());
        discourseDTO.setDate(entity.getDate());
        discourseDTO.setAssignedBy(entity.getAssignedBy());
        return discourseDTO;
    }
}
