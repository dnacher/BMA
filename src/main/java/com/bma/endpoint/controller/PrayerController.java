package com.bma.endpoint.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bma.api.dtos.PrayerDTO;
import com.bma.domain.service.PrayerService;
import com.bma.domain.service.mappers.PrayerMapper;
import com.bma.utils.Utils;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prayers")
public class PrayerController {

    private final PrayerService prayerService;
    private final PrayerMapper prayerMapper;

    public PrayerController(PrayerService prayerService, PrayerMapper prayerMapper){
        this.prayerService = prayerService;
        this.prayerMapper = prayerMapper;
    }

    @PostMapping(value = "/")
    public PrayerDTO savePrayer(@RequestBody PrayerDTO prayerDTO){
        Utils.validateIdNull(prayerDTO.getId(), String.format("A new Prayer cannot contains an Id"));
       return this.prayerService.savePrayer(prayerDTO);
    }

    @GetMapping(value = "/")
    public List<PrayerDTO> getPrayers(){
        return this.prayerService.getPrayers();
    }

    @GetMapping(value = "/{id}")
    public PrayerDTO getPrayer(@PathVariable Integer id){
        return this.prayerService.getPrayerById(id);
    }
    
    @PutMapping(value = "/{id}")
    public PrayerDTO updatePrayer(@PathVariable Integer id, @RequestBody PrayerDTO prayerDTO){
        String msg = String.format("The Prayer Id %s is different from the Url Id",prayerDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,prayerDTO.getId(),msg);
        return this.prayerService.updatePrayer(prayerDTO);
    }
    
//    @DeleteMapping(value = "/{id}")
//    public void deletePrayer(@PathVariable Integer id,@RequestBody PrayerDTO prayerDTO){
//        String msg = String.format("The Prayer Id %s is different from the Url Id",prayerDTO.getId());
//        Utils.validateUrlIdEqualsBodyId(id,prayerDTO.getId(),msg);
//        this.prayerService.deletePrayer(prayerDTO);
//    }

    @DeleteMapping(value = "/{id}")
    public void deletePrayer(@PathVariable Integer id){
        this.prayerService.deletePrayer(id);
    }
    
}
