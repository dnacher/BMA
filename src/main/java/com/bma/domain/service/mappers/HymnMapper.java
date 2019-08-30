package com.bma.domain.service.mappers;
;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import com.bma.api.dtos.HymnDTO;
import com.bma.persistence.model.Hymn;

@Component
public class HymnMapper implements AbstractMapper<Hymn, HymnDTO> {


    @Override
    public Hymn mapToEntity(HymnDTO dto) {
        Hymn hymn = new Hymn();
        hymn.setId(dto.getId());
        hymn.setTitle(dto.getTitle());
        hymn.setNumber(dto.getNumber());
        hymn.setPianoNumber(dto.getPianoNumber());
        hymn.setTopic(dto.getTopic());
        return hymn;
    }

    @Override
    public HymnDTO mapToDTO(Hymn entity) {
        HymnDTO hymnDTO = new HymnDTO();
        hymnDTO.setId(entity.getId());
        hymnDTO.setTitle(entity.getTitle());
        hymnDTO.setNumber(entity.getNumber());
        hymnDTO.setPianoNumber(entity.getPianoNumber());
        hymnDTO.setTopic(entity.getTopic());
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
