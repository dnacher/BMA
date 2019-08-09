package com.bma.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.exception.BMAException;
import com.bma.persistence.model.Prayer;
import com.bma.persistence.repository.PrayerRepository;

@Component
public class PrayerDAO {

    @Autowired
    private PrayerRepository prayerRepository;

    public List<Prayer> getPrayers(){
        List<Prayer>prayers = new ArrayList<>();
        prayerRepository.findAll().forEach(prayer -> prayers.add(prayer));
        return prayers;
    }

    public Prayer getPrayerById(Integer id){
        return prayerRepository.findById(id).get();
//        return  prayerRepository.findById(id).orElseThrow(()->{
//            String msg = String.format("The Prayer id %s does not exist", id.toString());
//            throw new BMAException(msg);
//        });
    }

    public Prayer savePrayer(Prayer prayer){
        if(prayer.getId()!=null){
            String msg = String.format("Cannot save a Prayer with Id");
            throw new BMAException(msg);
        }else {
            return prayerRepository.save(prayer);
        }
    }

    public void deletePrayer(Prayer prayer){
        prayerRepository.delete(prayer);
    }

    public Prayer updatePrayer(Prayer prayer){
        if(prayer.getId()!=null){
            return prayerRepository.save(prayer);
        }else {
            String msg = String.format("Cannot update a Prayer without an Id");
            throw new BMAException(msg);
        }
    }
}
