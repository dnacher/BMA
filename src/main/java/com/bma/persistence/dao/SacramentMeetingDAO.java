package com.bma.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.exception.BMAException;
import com.bma.persistence.model.SacramentMeeting;
import com.bma.persistence.repository.SacramentMeetingRepository;

@Component
public class SacramentMeetingDAO {

    @Autowired
    private SacramentMeetingRepository sacramentMeetingRepository;

    public SacramentMeeting getSacramentMeetingById(Integer id)throws BMAException{
        return sacramentMeetingRepository.findById(id).orElseThrow(()->{
            String msg = String.format("The Sacrament Meeting id %s does not exist", id.toString());
            return new BMAException(msg);
        });
    }

    public SacramentMeeting saveSacramentMeeting(SacramentMeeting sacramentMeeting){
        if(sacramentMeeting.getId()!=null){
            String msg = String.format("Cannot save a Sacrament Meeting with an Id");
            throw new BMAException(msg);
        }else{
            return sacramentMeetingRepository.save(sacramentMeeting);
        }
    }

    public void deleteSacramentMeeting(SacramentMeeting sacramentMeeting){
        sacramentMeetingRepository.delete(sacramentMeeting);
    }

    public SacramentMeeting updateSacramentMeeting(SacramentMeeting sacramentMeeting){
        if(sacramentMeeting.getId()!=null){
            return sacramentMeetingRepository.save(sacramentMeeting);
        }else{
            String msg = String.format("Cannot update a Sacrament Meeting without an Id");
            throw new BMAException(msg);
        }
    }
}
