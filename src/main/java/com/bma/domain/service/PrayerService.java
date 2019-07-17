package com.bma.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.PrayerDTO;
import com.bma.domain.service.mappers.PrayerMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.PrayerDAO;
import com.bma.persistence.model.Prayer;

@Service
public class PrayerService {

    private final PrayerDAO prayerDAO;
    private final PrayerMapper prayerMapper;

    @Autowired
    public PrayerService(PrayerDAO prayerDAO, PrayerMapper prayerMapper){
        this.prayerMapper = prayerMapper;
        this.prayerDAO = prayerDAO;
    }

    public PrayerDTO savePrayer(PrayerDTO prayerDTO) throws BMAException{
        try {
            Prayer prayer = prayerMapper.mapToEntity(prayerDTO);
            return prayerMapper.mapToDTO(this.prayerDAO.savePrayer(prayer));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deletePrayer(PrayerDTO prayerDTO){

        this.prayerDAO.deletePrayer(prayerMapper.mapToEntity(prayerDTO));
    }

    public PrayerDTO updatePrayer(PrayerDTO prayerDTO) throws BMAException{
        try {
            return this.prayerMapper.mapToDTO(this.prayerDAO.updatePrayer(prayerMapper.mapToEntity(prayerDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<PrayerDTO> getPrayers(){
        List<Prayer> prayers = this.prayerDAO.getPrayers();
        return prayers.stream().map(prayer -> this.prayerMapper.mapToDTO(prayer)).collect(Collectors.toList());
    }

    public PrayerDTO getPrayerById(Integer id) throws BMAException{
        try {
            return this.prayerMapper.mapToDTO(this.prayerDAO.getPrayerById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
