package com.bma.domain.service.mappers;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.api.dtos.DiscourseDTO;
import com.bma.persistence.model.Discourse;

@Component
public class DiscourseMapper implements AbstractMapper<Discourse, DiscourseDTO> {

    @Autowired
    private MemberMapper memberMapper;

    public static final Integer GMT = -3;


    @Override
    public Discourse mapToEntity(DiscourseDTO dto) {
        Discourse discourse = new Discourse();
        discourse.setId(dto.getId());
        discourse.setAssignedBy(memberMapper.mapToEntity(dto.getAssignedBy()));
        discourse.setDate(setDateToSave(dto.getDate(),GMT));
        discourse.setMember(memberMapper.mapToEntity(dto.getMember()));
        discourse.setTopic(dto.getTopic());
        return discourse;
    }

    @Override
    public DiscourseDTO mapToDTO(Discourse entity) {
        DiscourseDTO discourseDTO = new DiscourseDTO();
        discourseDTO.setId(entity.getId());
        discourseDTO.setMember(memberMapper.mapToDTO(entity.getMember()));
        discourseDTO.setTopic(entity.getTopic());
        discourseDTO.setDate(this.setDateToGet(entity.getDate(),GMT));
        discourseDTO.setAssignedBy(memberMapper.mapToDTO(entity.getAssignedBy()));
        return discourseDTO;
    }

    public Set<Discourse> mapToEntitySet(Set<DiscourseDTO> dtos) {
        Set<Discourse> discourses = new HashSet<>();
        dtos.forEach(discourseDTO -> discourses.add(this.mapToEntity(discourseDTO)));
        return discourses;
    }

    public Set<DiscourseDTO> mapToDTOSet(Set<Discourse> entities) {
        Set<DiscourseDTO> discourseDTOSet = new HashSet<>();
        entities.forEach(discourse -> discourseDTOSet.add(mapToDTO(discourse)));
        return discourseDTOSet;
    }

    public Date setDateToSave(Date date, Integer GMTTime){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, (GMTTime*-1));
        return cal.getTime();
    }

    public Date setDateToGet(Date date, Integer GMTTime){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, GMTTime);
        return cal.getTime();
    }
}
