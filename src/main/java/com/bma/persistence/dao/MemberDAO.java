package com.bma.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.exception.BMAException;
import com.bma.persistence.model.Member;
import com.bma.persistence.repository.MemberRepository;

@Component
public class MemberDAO {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMembers(){
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(member -> members.add(member));
        return members;
    }

    public Member getMemberById(Integer id){
        return memberRepository.findById(id).orElseThrow(()->{
            String msg = String.format("The member id %s does not exist", id.toString());
            throw new BMAException(msg);
        });
    }

    public Member saveMember(Member member){
        if(member.getId()!=null){
            String msg = String.format("Cannot save a Member with Id");
            throw new BMAException(msg);
        }else{
            return memberRepository.save(member);
        }
    }

    public void deleteMember(Member member){
        memberRepository.delete(member);
    }

    public Member updateMember(Member member){
        if(member.getId()!=null){
            return memberRepository.save(member);
        }else{
            String msg = String.format("Cannot update a Member without an Id");
            throw new BMAException(msg);
        }
    }

}
