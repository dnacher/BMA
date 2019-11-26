package com.bma.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.exception.BMAException;
import com.bma.persistence.model.Hymn;
import com.bma.persistence.repository.HymnRepository;

@Component
public class HymnDAO {

    @Autowired
    private HymnRepository hymnRepository;

    public List<Hymn> getHymns(){
        List<Hymn> hymns = new ArrayList<>();
        hymnRepository.findAll().forEach(hymn -> hymns.add(hymn));
        return hymns;
    }

    public Hymn getHymnById(Integer id) throws BMAException{
//        return hymnRepository.findById(id).get();
        return hymnRepository.findById(id).<BMAException>orElseThrow (()-> {
            String msg = String.format("The Hymn id %s does not exist", id.toString());
            throw new BMAException(HttpStatus.INTERNAL_SERVER_ERROR_500,msg);
        });
    }

    public Hymn saveHymn(Hymn hymn) throws BMAException{
        if(hymn.getId()!=null){
            String msg = String.format("Cannot save a Hymn with Id");
            throw new BMAException(msg);
        }else{
            return hymnRepository.save(hymn);
        }
    }

    public void deleteHymn(Hymn hymn){
        hymnRepository.delete(hymn);
    }

    public Hymn updateHymn(Hymn hymn) throws BMAException{
        if(hymn.getId()!=null){
            return hymnRepository.save(hymn);
        }else{
            String msg = String.format("Cannot update a Hymn without an Id");
            throw new BMAException(msg);
        }
    }
}
