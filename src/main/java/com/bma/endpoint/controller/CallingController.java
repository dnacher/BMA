package com.bma.endpoint.controller;

import java.util.List;

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

    @GetMapping(value = "/")
    public List<CallingDTO> getCalling(){
        return this.callingService.getCallings();
    }

    @GetMapping(value = "/{id}")
    public CallingDTO getCalling(@PathVariable Integer id){
        return this.callingService.getCallingById(id);
    }

    @PutMapping(value = "/{id}")
    public CallingDTO updateCalling(@RequestParam Integer id, @RequestBody CallingDTO callingDTO){
        String msg = String.format("The Calling Id %s is different from the Url Id",callingDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,callingDTO.getId(),msg);
        return this.callingService.updateCalling(callingDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCalling(@RequestParam Integer id, CallingDTO callingDTO){
        String msg = String.format("The Calling Id %s is different from the Url Id",callingDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,callingDTO.getId(),msg);
        this.callingService.deleteCalling(callingDTO);
    }

}
