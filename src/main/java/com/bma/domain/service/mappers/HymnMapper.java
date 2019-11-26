package com.bma.domain.service.mappers;
;
import java.util.HashSet;
import java.util.Set;

import com.bma.persistence.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bma.api.dtos.HymnDTO;
import com.bma.persistence.model.Hymn;

@Component
public class HymnMapper implements AbstractMapper<Hymn, HymnDTO> {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public Hymn mapToEntity(HymnDTO dto) {
        Hymn hymn = new Hymn();
        hymn.setId(dto.getId());
        hymn.setTitle(dto.getTitle());
        hymn.setNumber(dto.getNumber());
        hymn.setPianoNumber(dto.getPianoNumber());
        if(dto.getTopic()!=null){
            hymn.setTopic(topicMapper.mapToEntity(dto.getTopic()));
        }
        return hymn;
    }

    @Override
    public HymnDTO mapToDTO(Hymn entity) {
        HymnDTO hymnDTO = new HymnDTO();
        hymnDTO.setId(entity.getId());
        hymnDTO.setTitle(entity.getTitle());
        hymnDTO.setNumber(entity.getNumber());
        hymnDTO.setPianoNumber(entity.getPianoNumber());
        if(entity.getTopic()!=null){
            hymnDTO.setTopic(topicMapper.mapToDTO(entity.getTopic()));
        }
        return hymnDTO;
    }

    public Set<Hymn> mapToEntitySet(Set<HymnDTO> dtos) {
        Set<Hymn>hymns = new HashSet<>();
        dtos.forEach(hymnDTO -> hymns.add(this.mapToEntity(hymnDTO)));
        return hymns;
    }


    public Set<HymnDTO> mapToDTOSet(Set<Hymn> entitySet) {
        Set<HymnDTO>dtos = new HashSet<>();
        entitySet.forEach(hymn -> dtos.add(this.mapToDTO(hymn)));
        return dtos;
    }


}
