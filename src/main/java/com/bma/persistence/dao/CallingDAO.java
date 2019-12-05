package com.bma.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.exception.BMAException;
import com.bma.persistence.model.Calling;
import com.bma.persistence.repository.CallingRepository;

@Component
public class CallingDAO {

    @Autowired
    private CallingRepository repository;

    public List<Calling> getCallings(){
        List<Calling> callings = new ArrayList<>();
        this.repository.findAll().forEach(calling -> callings.add(calling));
        return callings;
    }

    public Calling getCallingById(Integer id) throws BMAException{
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The calling id %s does not exist", id.toString());
            return new BMAException(msg);
        });
    }

    public Calling saveCalling(Calling calling) throws BMAException{
        if(calling.getId()!=null){
            String msg = String.format("Cannot save a Calling with Id");
            throw new BMAException(msg);
        }else{
            return this.repository.save(calling);
        }
    }

    public void deleteCalling(Calling calling){
        this.repository.delete(calling);
    }

    public void deleteCalling(Integer id){
        this.repository.deleteById(id);
    }

    public Calling updateCalling(Calling calling) throws BMAException{
        if(calling.getId()!=null){
            return this.repository.save(calling);
        }else{
            String msg = String.format("Cannot update a calling without an Id");
            throw new BMAException(msg);
        }
    }



}
