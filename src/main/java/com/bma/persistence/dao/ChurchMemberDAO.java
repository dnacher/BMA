package com.bma.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.exception.BMAException;
import com.bma.persistence.model.ChurchMember;
import com.bma.persistence.repository.ChurchMemberRepository;

@Component
public class ChurchMemberDAO {

    @Autowired
    private ChurchMemberRepository churchMemberRepository;

    public List<ChurchMember> getChurchMembers(){
        List<ChurchMember> ChurchMembers = new ArrayList<>();
        churchMemberRepository.findAllOrderBySurname().forEach(ChurchMember -> ChurchMembers.add(ChurchMember));
        return ChurchMembers;
    }

    public ChurchMember getChurchMemberById(Integer id) throws BMAException{
        ChurchMember ChurchMember = this.churchMemberRepository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The ChurchMember id %s does not exist", id.toString());
            return new BMAException(msg);
        });
        return ChurchMember;
    }

    public ChurchMember saveChurchMember(ChurchMember ChurchMember){
        if(ChurchMember.getId()!=null){
            String msg = String.format("Cannot save a ChurchMember with Id");
            throw new BMAException(msg);
        }else{
            return churchMemberRepository.save(ChurchMember);
        }
    }

    public void deleteChurchMember(Integer ChurchMemberId){
        churchMemberRepository.deleteById(ChurchMemberId);
    }

    public ChurchMember updateChurchMember(ChurchMember ChurchMember){
        if(ChurchMember.getId()!=null){
            return churchMemberRepository.save(ChurchMember);
        }else{
            String msg = String.format("Cannot update a ChurchMember without an Id");
            throw new BMAException(msg);
        }
    }

}
