package com.bma.endpoint.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bma.api.dtos.SacramentMeetingDTO;
import com.bma.domain.service.SacramentMeetingService;
import com.bma.domain.service.mappers.SacramentMeetingMapper;
import com.bma.utils.Utils;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sacrament_meetings")
public class SacramentMeetingController {

    private final SacramentMeetingService sacramentMeetingService;
    private final SacramentMeetingMapper sacramentMeetingMapper;

    public SacramentMeetingController(SacramentMeetingService sacramentMeetingService, SacramentMeetingMapper sacramentMeetingMapper){
        this.sacramentMeetingService = sacramentMeetingService;
        this.sacramentMeetingMapper = sacramentMeetingMapper;
    }

    @PostMapping(value = "/")
    public SacramentMeetingDTO saveSacramentMeeting(@RequestBody SacramentMeetingDTO sacramentMeetingDTO){
        Utils.validateIdNull(sacramentMeetingDTO.getId(), String.format("A new SacramentMeeting cannot contains an Id"));
       return this.sacramentMeetingService.saveSacramentMeeting(sacramentMeetingDTO);
    }

    @GetMapping(value = "/{id}")
    public SacramentMeetingDTO getSacramentMeeting(@PathVariable Integer id){
        return this.sacramentMeetingService.getSacramentMeetingById(id);
    }
    
    @PutMapping(value = "/{id}")
    public SacramentMeetingDTO updateSacramentMeeting(@PathVariable Integer id, @RequestBody SacramentMeetingDTO sacramentMeetingDTO){
        String msg = String.format("The SacramentMeeting Id %s is different from the Url Id",sacramentMeetingDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,sacramentMeetingDTO.getId(),msg);
        return this.sacramentMeetingService.updateSacramentMeeting(sacramentMeetingDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteSacramentMeeting(@PathVariable Integer id,@RequestBody SacramentMeetingDTO sacramentMeetingDTO){
        String msg = String.format("The SacramentMeeting Id %s is different from the Url Id",sacramentMeetingDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,sacramentMeetingDTO.getId(),msg);
        this.sacramentMeetingService.deleteSacramentMeeting(sacramentMeetingDTO);
    }
    
}
