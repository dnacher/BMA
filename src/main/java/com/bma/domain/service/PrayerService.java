package com.bma.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.bma.persistence.model.ChurchMember;
import com.bma.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.PrayerDTO;
import com.bma.domain.service.mappers.ChurchMemberMapper;
import com.bma.domain.service.mappers.PrayerMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.ChurchMemberDAO;
import com.bma.persistence.dao.PrayerDAO;
import com.bma.persistence.model.Prayer;

@Transactional
@Service
public class PrayerService {

    private final PrayerDAO prayerDAO;
    private final ChurchMemberDAO churchMemberDAO;
    private final PrayerMapper prayerMapper;
    private final ChurchMemberMapper churchMemberMapper;

    @Autowired
    public PrayerService(PrayerDAO prayerDAO, PrayerMapper prayerMapper, ChurchMemberDAO churchMemberDAO, ChurchMemberMapper churchMemberMapper){
        this.prayerMapper = prayerMapper;
        this.prayerDAO = prayerDAO;
        this.churchMemberDAO = churchMemberDAO;
        this.churchMemberMapper = churchMemberMapper;
    }

    public PrayerDTO savePrayer(PrayerDTO prayerDTO) throws BMAException{
        try {
            if(prayerDTO.getChurchMember().getId()!=null){
                prayerDTO.setDate(Utils.setDateToSave(prayerDTO.getDate()));
                return savePrayerDTO(prayerDTO);
            }else{
                ChurchMember churchMember = this.churchMemberMapper.mapToEntity(prayerDTO.getChurchMember());
                churchMember = churchMemberDAO.saveChurchMember(churchMember);
                prayerDTO.setMember(churchMemberMapper.mapToDTO(churchMember));
                return savePrayerDTO(prayerDTO);
            }
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public PrayerDTO savePrayerDTO(PrayerDTO prayerDTO){
        Prayer prayer = prayerMapper.mapToEntity(prayerDTO);
        prayer = this.prayerDAO.savePrayer(prayer);
        return prayerMapper.mapToDTO(prayer);
    }

//    public void deletePrayer(PrayerDTO prayerDTO){
//
//        this.prayerDAO.deletePrayer(prayerMapper.mapToEntity(prayerDTO));
//    }

    public void deletePrayer(Integer id){
        this.prayerDAO.deletePrayer(id);
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
