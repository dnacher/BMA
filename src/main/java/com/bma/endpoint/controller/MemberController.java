package com.bma.endpoint.controller;

import java.util.ArrayList;
import java.util.List;

import com.bma.api.dtos.AttendanceDTO;
import org.springframework.web.bind.annotation.*;

import com.bma.api.dtos.ChurchMemberDTO;
import com.bma.domain.service.ChurchMemberService;
import com.bma.domain.service.mappers.ChurchMemberMapper;
import com.bma.utils.Utils;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/members")
public class MemberController {

    private final ChurchMemberService churchMemberService;
    private final ChurchMemberMapper churchMemberMapper;

    public MemberController(ChurchMemberService churchMemberService, ChurchMemberMapper churchMemberMapper){
        this.churchMemberService = churchMemberService;
        this.churchMemberMapper = churchMemberMapper;
    }

    @PostMapping(value = "/")
    public ChurchMemberDTO saveMember(@RequestBody ChurchMemberDTO churchMemberDTO){
        Utils.validateIdNull(churchMemberDTO.getId(), String.format("A new Member cannot contains an Id"));
       return this.churchMemberService.saveMember(churchMemberDTO);
    }

    @PostMapping(value = "/mu")
    public List<ChurchMemberDTO> saveMembers(@RequestBody List<ChurchMemberDTO> churchMemberDTOS){
        List<ChurchMemberDTO> finalChurchMemberDTOS = new ArrayList<>();
        churchMemberDTOS.forEach(memberDTO -> finalChurchMemberDTOS.add(this.churchMemberService.saveMember(memberDTO)));
        return finalChurchMemberDTOS;
    }

    @GetMapping(value = "/")
    public List<ChurchMemberDTO> getMembers(){
        return this.churchMemberService.getMembers();
    }

    @GetMapping(value = "/test")
    public List<AttendanceDTO> getMembersTest(){
        return this.churchMemberService.getMembersTest();
    }

    @GetMapping(value = "/{id}")
    public ChurchMemberDTO getMember(@PathVariable("id") Integer id){
        return this.churchMemberService.getMemberById(id);
    }
    
    @PutMapping(value = "/{id}")
    public ChurchMemberDTO updateMember(@PathVariable("id") int id, @RequestBody ChurchMemberDTO churchMemberDTO){
        String msg = String.format("The Member Id %s is different from the Url Id", churchMemberDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id, churchMemberDTO.getId(),msg);
        return this.churchMemberService.updateMember(churchMemberDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteMember(@PathVariable Integer id){
        String msg = String.format("The Member Id %s is different from the Url Id",id);
        this.churchMemberService.deleteMember(id);
    }
    
}
