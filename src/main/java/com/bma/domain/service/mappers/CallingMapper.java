package com.bma.domain.service.mappers;

import org.springframework.stereotype.Component;

import com.bma.api.dtos.CallingDTO;
import com.bma.persistence.model.Calling;

@Component
public class CallingMapper implements AbstractMapper<Calling, CallingDTO> {


    @Override
    public Calling mapToEntity(CallingDTO dto) {
        Calling calling = new Calling();
        calling.setId(dto.getId());
        calling.setName(dto.getName());
        return calling;
    }

    @Override
    public CallingDTO mapToDTO(Calling entity) {
        CallingDTO callingDTO = new CallingDTO();
        callingDTO.setId(entity.getId());
        callingDTO.setName(entity.getName());
        return callingDTO;
    }
}
