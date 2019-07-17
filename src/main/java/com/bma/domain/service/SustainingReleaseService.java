package com.bma.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.SustainingReleaseDTO;
import com.bma.domain.service.mappers.SustainingReleaseMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.SustainingReleaseDAO;
import com.bma.persistence.model.SustainingRelease;

@Service
public class SustainingReleaseService {

    private final SustainingReleaseDAO sustainingReleaseDAO;
    private final SustainingReleaseMapper sustainingReleaseMapper;

    @Autowired
    public SustainingReleaseService(SustainingReleaseDAO sustainingReleaseDAO, SustainingReleaseMapper sustainingReleaseMapper){
        this.sustainingReleaseMapper = sustainingReleaseMapper;
        this.sustainingReleaseDAO = sustainingReleaseDAO;
    }

    public SustainingReleaseDTO saveSustainingRelease(SustainingReleaseDTO sustainingReleaseDTO) throws BMAException{
        try {
            SustainingRelease sustainingRelease = sustainingReleaseMapper.mapToEntity(sustainingReleaseDTO);
            return sustainingReleaseMapper.mapToDTO(this.sustainingReleaseDAO.saveSustainingRelease(sustainingRelease));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteSustainingRelease(SustainingReleaseDTO sustainingReleaseDTO){

        this.sustainingReleaseDAO.deleteSustainingRelease(sustainingReleaseMapper.mapToEntity(sustainingReleaseDTO));
    }

    public SustainingReleaseDTO updateSustainingRelease(SustainingReleaseDTO sustainingReleaseDTO) throws BMAException{
        try {
            return this.sustainingReleaseMapper.mapToDTO(this.sustainingReleaseDAO.updateSustainingRelease(sustainingReleaseMapper.mapToEntity(sustainingReleaseDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<SustainingReleaseDTO> getSustainingReleases(){
        List<SustainingRelease> sustainingReleases = this.sustainingReleaseDAO.getSustainingReleaseList();
        return sustainingReleases.stream().map(sustainingRelease -> this.sustainingReleaseMapper.mapToDTO(sustainingRelease)).collect(Collectors.toList());
    }

    public SustainingReleaseDTO getSustainingReleaseById(Integer id) throws BMAException{
        try {
            return this.sustainingReleaseMapper.mapToDTO(this.sustainingReleaseDAO.getSustainingReleaseById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
