package com.bma.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.SacramentMeetingDTO;
import com.bma.domain.service.mappers.SacramentMeetingMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.SacramentMeetingDAO;
import com.bma.persistence.model.SacramentMeeting;

@Service
public class SacramentMeetingService {

    private final SacramentMeetingDAO sacramentMeetingDAO;
    private final SacramentMeetingMapper sacramentMeetingMapper;

    @Autowired
    public SacramentMeetingService(SacramentMeetingDAO sacramentMeetingDAO, SacramentMeetingMapper sacramentMeetingMapper){
        this.sacramentMeetingMapper = sacramentMeetingMapper;
        this.sacramentMeetingDAO = sacramentMeetingDAO;
    }

    public SacramentMeetingDTO saveSacramentMeeting(SacramentMeetingDTO sacramentMeetingDTO) throws BMAException{
        try {
            SacramentMeeting sacramentMeeting = sacramentMeetingMapper.mapToEntity(sacramentMeetingDTO);
            return sacramentMeetingMapper.mapToDTO(this.sacramentMeetingDAO.saveSacramentMeeting(sacramentMeeting));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteSacramentMeeting(SacramentMeetingDTO sacramentMeetingDTO){

        this.sacramentMeetingDAO.deleteSacramentMeeting(sacramentMeetingMapper.mapToEntity(sacramentMeetingDTO));
    }

    public SacramentMeetingDTO updateSacramentMeeting(SacramentMeetingDTO sacramentMeetingDTO) throws BMAException{
        try {
            return this.sacramentMeetingMapper.mapToDTO(this.sacramentMeetingDAO.updateSacramentMeeting(sacramentMeetingMapper.mapToEntity(sacramentMeetingDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public SacramentMeetingDTO getSacramentMeetingById(Integer id) throws BMAException{
        try {
            return this.sacramentMeetingMapper.mapToDTO(this.sacramentMeetingDAO.getSacramentMeetingById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
