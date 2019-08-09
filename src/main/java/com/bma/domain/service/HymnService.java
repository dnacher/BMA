package com.bma.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.HymnDTO;
import com.bma.domain.service.mappers.HymnMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.HymnDAO;
import com.bma.persistence.model.Hymn;

@Transactional
@Service
public class HymnService {

    private final HymnDAO hymnDAO;
    private final HymnMapper hymnMapper;

    @Autowired
    public HymnService(HymnDAO hymnDAO, HymnMapper hymnMapper){
        this.hymnDAO = hymnDAO;
        this.hymnMapper = hymnMapper;
    }

    public HymnDTO saveHymn(HymnDTO hymnDTO) throws BMAException{
        try {
            Hymn hymn = hymnMapper.mapToEntity(hymnDTO);
            return hymnMapper.mapToDTO(this.hymnDAO.saveHymn(hymn));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteHymn(HymnDTO hymnDTO){

        this.hymnDAO.deleteHymn(hymnMapper.mapToEntity(hymnDTO));
    }

    public HymnDTO updateHymn(HymnDTO hymnDTO) throws BMAException{
        try {
            return this.hymnMapper.mapToDTO(this.hymnDAO.updateHymn(hymnMapper.mapToEntity(hymnDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<HymnDTO> getHymns(){
        List<Hymn> hymns = this.hymnDAO.getHymns();
        return hymns.stream().map(hymn -> this.hymnMapper.mapToDTO(hymn)).collect(Collectors.toList());
    }

    public HymnDTO getHymnById(Integer id) throws BMAException{
        try {
            return this.hymnMapper.mapToDTO(this.hymnDAO.getHymnById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
