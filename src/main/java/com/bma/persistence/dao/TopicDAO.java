package com.bma.persistence.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//        Iterable<Member>it = memberRepository.findAll();
        memberRepository.findAllOrderBySurname().forEach(member -> members.add(member));
//        it.forEach(member -> members.add(member));
        return members;
    }

    public Member getMemberById(Integer id) throws BMAException{
        Member member = this.memberRepository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The member id %s does not exist", id.toString());
            return new BMAException(msg);
        });
        return member;
    }

    public Member saveMember(Member member){
        if(member.getId()!=null){
            String msg = String.format("Cannot save a Member with Id");
            throw new BMAException(msg);
        }else{
            return memberRepository.save(member);
        }
    }

    public void deleteMember(Integer memberId){
        memberRepository.deleteById(memberId);
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