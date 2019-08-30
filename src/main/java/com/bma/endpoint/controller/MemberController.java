package com.bma.endpoint.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bma.api.dtos.AttendanceDTO;
import org.springframework.web.bind.annotation.*;

import com.bma.api.dtos.MemberDTO;
import com.bma.domain.service.MemberService;
import com.bma.domain.service.mappers.MemberMapper;
import com.bma.utils.Utils;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper){
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(value = "/")
    public MemberDTO saveMember(@RequestBody MemberDTO memberDTO){
        Utils.validateIdNull(memberDTO.getId(), String.format("A new Member cannot contains an Id"));
       return this.memberService.saveMember(memberDTO);
    }

    @PostMapping(value = "/mu")
    public List<MemberDTO> saveMembers(@RequestBody List<MemberDTO> memberDTOs){
        List<MemberDTO>finalMemberDTOs = new ArrayList<>();
        memberDTOs.forEach(memberDTO -> finalMemberDTOs.add(this.memberService.saveMember(memberDTO)));
        return finalMemberDTOs;
    }

    @GetMapping(value = "/")
    public List<MemberDTO> getMembers(){
        return this.memberService.getMembers();
    }

    @GetMapping(value = "/test")
    public List<AttendanceDTO> getMembersTest(){
        return this.memberService.getMembersTest();
    }

    @GetMapping(value = "/{id}")
    public MemberDTO getMember(@PathVariable("id") Integer id){
        return this.memberService.getMemberById(id);
    }
    
    @PutMapping(value = "/{id}")
    public MemberDTO updateMember(@PathVariable("id") int id, @RequestBody MemberDTO memberDTO){
        String msg = String.format("The Member Id %s is different from the Url Id",memberDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,memberDTO.getId(),msg);
        return this.memberService.updateMember(memberDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteMember(@PathVariable Integer id){
        String msg = String.format("The Member Id %s is different from the Url Id",id);
        this.memberService.deleteMember(id);
    }
    
}
