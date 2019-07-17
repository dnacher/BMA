package com.bma.domain.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.api.dtos.CallingDTO;
import com.bma.api.dtos.PrayerDTO;
import com.bma.persistence.model.Calling;
import com.bma.persistence.model.Prayer;

@Component
public class PrayerMapper implements AbstractMapper<Prayer, PrayerDTO> {


    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Prayer mapToEntity(PrayerDTO dto) {
        Prayer prayer = new Prayer();
        prayer.setId(dto.getId());
        prayer.setDate(dto.getDate());
        prayer.setMember(memberMapper.mapToEntity(dto.getMemberDTO()));
        return prayer;
    }

    @Override
    public PrayerDTO mapToDTO(Prayer entity) {
        PrayerDTO prayerDTO = new PrayerDTO();
        prayerDTO.setId(entity.getId());
        prayerDTO.setDate(entity.getDate());
        prayerDTO.setMemberDTO(memberMapper.mapToDTO(entity.getMember()));
        return prayerDTO;
    }

    public List<Prayer> mapToEntityList(List<PrayerDTO> dtos) {
        List<Prayer> prayers = new ArrayList<>();
        dtos.forEach(prayerDTO -> prayers.add(mapToEntity(prayerDTO)));
        return prayers;
    }

    public List<PrayerDTO> mapToDTOList(List<Prayer> entities) {
        List<PrayerDTO> prayerDTOS = new ArrayList<>();
        entities.forEach(prayer -> prayerDTOS.add(this.mapToDTO(prayer)));
        return prayerDTOS;
    }
}
