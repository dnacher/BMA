package com.bma.domain.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bma.api.dtos.CallingDTO;
import com.bma.api.dtos.HymnDTO;
import com.bma.persistence.model.Calling;
import com.bma.persistence.model.Hymn;

@Component
public class HymnMapper implements AbstractMapper<Hymn, HymnDTO> {


    @Override
    public Hymn mapToEntity(HymnDTO dto) {
        Hymn hymn = new Hymn();
        hymn.setId(dto.getId());
        hymn.setName(dto.getName());
        hymn.setNumber(dto.getNumber());
        hymn.setPianoNumber(dto.getPianoNumber());
        return hymn;
    }

    @Override
    public HymnDTO mapToDTO(Hymn entity) {
        HymnDTO hymnDTO = new HymnDTO();
        hymnDTO.setId(entity.getId());
        hymnDTO.setName(entity.getName());
        hymnDTO.setNumber(entity.getNumber());
        hymnDTO.setPianoNumber(entity.getPianoNumber());
        return hymnDTO;
    }

    public List<Hymn> mapToEntityList(List<HymnDTO> dtos) {
        List<Hymn>hymns = new ArrayList<>();
        dtos.forEach(hymnDTO -> hymns.add(this.mapToEntity(hymnDTO)));
        return hymns;
    }


    public List<HymnDTO> mapToDTOList(List<Hymn> entityList) {
        List<HymnDTO>dtos = new ArrayList<>();
        entityList.forEach(hymn -> dtos.add(this.mapToDTO(hymn)));
        return dtos;
    }


}
