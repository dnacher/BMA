package com.bma.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.exception.BMAException;
import com.bma.persistence.model.Discourse;
import com.bma.persistence.repository.DiscourseRepository;

@Component
public class DiscourseDAO {

    @Autowired
    private DiscourseRepository discourseRepository;

    public List<Discourse> getDiscourses(){
        List<Discourse>discourses = new ArrayList<>();
        discourseRepository.findAll().forEach(discourse -> discourses.add(discourse));
        return discourses;
    }

    public Discourse getDiscourseById(Integer id){
        return discourseRepository.findById(id).orElseThrow(()->{
            String msg = String.format("The Discourse id %s does not exist", id.toString());
            return new BMAException(msg);
        });
    }

    public Discourse saveDiscourse(Discourse discourse){
        if(discourse.getId()!=null){
            String msg = String.format("Cannot save a Discourse with Id");
            throw new BMAException(msg);
        }else{
            return discourseRepository.save(discourse);
        }
    }

    public void deleteDiscourse(Discourse discourse){
        discourseRepository.delete(discourse);
    }

    public void deleteDiscourseById(Integer id){ discourseRepository.deleteById(id);}

    public Discourse updateDiscourse(Discourse discourse){
        if(discourse.getId()!=null){
            return discourseRepository.save(discourse);
        }else{
            String msg = String.format("Cannot update a Discourse without an Id");
            throw new BMAException(msg);

        }
    }
}
