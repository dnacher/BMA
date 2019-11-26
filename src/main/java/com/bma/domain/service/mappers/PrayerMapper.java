package com.bma.domain.service.mappers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.api.dtos.PrayerDTO;
import com.bma.persistence.model.Prayer;

@Component
public class PrayerMapper implements AbstractMapper<Prayer, PrayerDTO> {


    @Autowired
    private ChurchMemberMapper churchMemberMapper;

    @Override
    public Prayer mapToEntity(PrayerDTO dto) {
        Prayer prayer = new Prayer();
        prayer.setId(dto.getId());
        prayer.setDate(dto.getDate());
        if(dto.getChurchMember()!=null) {
            prayer.setMember(churchMemberMapper.mapToEntity(dto.getChurchMember()));
        }
        return prayer;
    }

    @Override
    public PrayerDTO mapToDTO(Prayer entity) {
        PrayerDTO prayerDTO = new PrayerDTO();
        prayerDTO.setId(entity.getId());
        prayerDTO.setDate(entity.getDate());
        if(entity.getMember()!=null) {
            prayerDTO.setMember(churchMemberMapper.mapToDTO(entity.getMember()));
        }
        return prayerDTO;
    }

    public Set<Prayer> mapToEntitySet(Set<PrayerDTO> dtos) {
        Set<Prayer> prayers = new HashSet<>();
        dtos.forEach(prayerDTO -> prayers.add(mapToEntity(prayerDTO)));
        return prayers;
    }

    public Set<PrayerDTO> mapToDTOSet(Set<Prayer> entities) {
        Set<PrayerDTO> prayerDTOS = new HashSet<>();
        entities.forEach(prayer -> prayerDTOS.add(this.mapToDTO(prayer)));
        return prayerDTOS;
    }
}
