package com.bma.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bma.exception.BMAException;
import com.bma.persistence.model.SustainingRelease;
import com.bma.persistence.repository.SustainingReleaseRepository;

@Component
public class SustainingReleaseDAO {

    private SustainingReleaseRepository sustainingReleaseRepository;

    public List<SustainingRelease> getSustainingReleaseList(){
        List<SustainingRelease>sustainingReleaseList = new ArrayList<>();
        sustainingReleaseRepository.findAll().forEach(sustainingRelease -> sustainingReleaseList.add(sustainingRelease));
        return sustainingReleaseList;
    }

    public SustainingRelease getSustainingReleaseById(Integer id)throws BMAException{
//        return sustainingReleaseRepository.findById(id).get();
        return sustainingReleaseRepository.findById(id).orElseThrow(()->{
            String msg = String.format("The SustainingRelease id %s does not exist", id.toString());
            throw new BMAException(msg);
        });
    }

    public SustainingRelease saveSustainingRelease(SustainingRelease sustainingRelease){
        if(sustainingRelease.getId()!=null){
            String msg = String.format("Cannot save a SustainingRelease with Id");
            throw new BMAException(msg);
        }else{
            return sustainingReleaseRepository.save(sustainingRelease);
        }
    }

    public void deleteSustainingRelease(SustainingRelease sustainingRelease){
        sustainingReleaseRepository.delete(sustainingRelease);
    }

    public SustainingRelease updateSustainingRelease(SustainingRelease sustainingRelease){
        if(sustainingRelease.getId()!=null){
            return sustainingReleaseRepository.save(sustainingRelease);
        }else{
            String msg = String.format("Cannot update a SustainingRelease without an Id");
            throw new BMAException(msg);
        }
    }
}
