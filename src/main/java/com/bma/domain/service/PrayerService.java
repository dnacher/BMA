package com.bma.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.PrayerDTO;
import com.bma.domain.service.mappers.MemberMapper;
import com.bma.domain.service.mappers.PrayerMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.MemberDAO;
import com.bma.persistence.dao.PrayerDAO;
import com.bma.persistence.model.Member;
import com.bma.persistence.model.Prayer;

@Transactional
@Service
public class PrayerService {

    private final PrayerDAO prayerDAO;
    private final MemberDAO memberDAO;
    private final PrayerMapper prayerMapper;
    private final MemberMapper memberMapper;

    @Autowired
    public PrayerService(PrayerDAO prayerDAO, PrayerMapper prayerMapper, MemberDAO memberDAO, MemberMapper memberMapper){
        this.prayerMapper = prayerMapper;
        this.prayerDAO = prayerDAO;
        this.memberDAO = memberDAO;
        this.memberMapper = memberMapper;
    }

    public PrayerDTO savePrayer(PrayerDTO prayerDTO) throws BMAException{
        try {
            if(prayerDTO.getMember().getId()!=null){
                return savePrayerDTO(prayerDTO);
            }else{
                Member member = this.memberMapper.mapToEntity(prayerDTO.getMember());
                member = memberDAO.saveMember(member);
                prayerDTO.setMember(memberMapper.mapToDTO(member));
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
