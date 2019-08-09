package com.bma.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.CallingDTO;
import com.bma.domain.service.mappers.CallingMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.CallingDAO;
import com.bma.persistence.model.Calling;

@Transactional
@Service
public class CallingService {

    private final CallingDAO callingDAO;
    private final CallingMapper callingMapper;

    @Autowired
    public CallingService(CallingDAO callingDAO, CallingMapper callingMapper){
        this.callingMapper = callingMapper;
        this.callingDAO = callingDAO;
    }

    public CallingDTO saveCalling(CallingDTO callingDTO) throws BMAException{
        try {
            Calling calling = callingMapper.mapToEntity(callingDTO);
            return callingMapper.mapToDTO(this.callingDAO.saveCalling(calling));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteCalling(CallingDTO callingDTO){

        this.callingDAO.deleteCalling(callingMapper.mapToEntity(callingDTO));
    }

    public CallingDTO updateCalling(CallingDTO callingDTO) throws BMAException{
        try {
            return this.callingMapper.mapToDTO(this.callingDAO.updateCalling(callingMapper.mapToEntity(callingDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<CallingDTO> getCallings(){
        List<Calling> callings = this.callingDAO.getCallings();
        return callings.stream().map(calling -> this.callingMapper.mapToDTO(calling)).collect(Collectors.toList());
    }

    public CallingDTO getCallingById(Integer id) throws BMAException{
        try {
            return this.callingMapper.mapToDTO(this.callingDAO.getCallingById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
