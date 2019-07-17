package com.bma.endpoint.controller;

import org.springframework.web.bind.annotation.*;

import com.bma.api.dtos.CallingDTO;
import com.bma.domain.service.mappers.CallingMapper;
import com.bma.domain.service.CallingService;
import com.bma.utils.Utils;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/callings")
public class CallingController {

    private final CallingService callingService;
    private final CallingMapper callingMapper;

    public CallingController(CallingService callingService, CallingMapper callingMapper){
        this.callingService = callingService;
        this.callingMapper = callingMapper;
    }

    @PostMapping(value = "/")
    public CallingDTO saveCalling(@RequestBody CallingDTO callingDTO){
        Utils.validateIdNull(callingDTO.getId(), String.format("A new Calling cannot contains an Id"));
       return this.callingService.saveCalling(callingDTO);
    }


}
