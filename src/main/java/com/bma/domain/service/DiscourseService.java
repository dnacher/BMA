package com.bma.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bma.api.dtos.DiscourseDTO;
import com.bma.domain.service.mappers.DiscourseMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.DiscourseDAO;
import com.bma.persistence.model.Discourse;

@Transactional
@Service
public class DiscourseService {

    private final DiscourseDAO discourseDAO;
    private final DiscourseMapper discourseMapper;

    @Autowired
    public DiscourseService(DiscourseDAO discourseDAO, DiscourseMapper discourseMapper){
        this.discourseDAO = discourseDAO;
        this.discourseMapper = discourseMapper;
    }

    public DiscourseDTO saveDiscourse(DiscourseDTO discourseDTO) throws BMAException{
        try {
            Discourse discourse = discourseMapper.mapToEntity(discourseDTO);
            discourse = this.discourseDAO.saveDiscourse(discourse);
            discourseDTO = discourseMapper.mapToDTO(discourse);
            return discourseDTO;
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteDiscourse(DiscourseDTO discourseDTO){

        this.discourseDAO.deleteDiscourse(discourseMapper.mapToEntity(discourseDTO));
    }

    public void deleteDiscourse(Integer id){
        this.discourseDAO.deleteDiscourseById(id);
    }

    public DiscourseDTO updateDiscourse(DiscourseDTO discourseDTO) throws BMAException{
        try {
            return this.discourseMapper.mapToDTO(this.discourseDAO.updateDiscourse(discourseMapper.mapToEntity(discourseDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<DiscourseDTO> getDiscourses(){
        List<Discourse> discourses = this.discourseDAO.getDiscourses();
        return discourses.stream().map(calling -> this.discourseMapper.mapToDTO(calling)).collect(Collectors.toList());
    }

    public DiscourseDTO getDiscourseById(Integer id) throws BMAException{
        try {
            return this.discourseMapper.mapToDTO(this.discourseDAO.getDiscourseById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }
}
