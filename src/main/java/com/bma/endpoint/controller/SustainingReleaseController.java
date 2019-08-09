package com.bma.endpoint.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bma.api.dtos.SustainingReleaseDTO;
import com.bma.domain.service.SustainingReleaseService;
import com.bma.domain.service.mappers.SustainingReleaseMapper;
import com.bma.utils.Utils;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sustaining_releases")
public class SustainingReleaseController {

    private final SustainingReleaseService sustainingReleaseService;
    private final SustainingReleaseMapper sustainingReleaseMapper;

    public SustainingReleaseController(SustainingReleaseService sustainingReleaseService, SustainingReleaseMapper sustainingReleaseMapper){
        this.sustainingReleaseService = sustainingReleaseService;
        this.sustainingReleaseMapper = sustainingReleaseMapper;
    }

    @PostMapping(value = "/")
    public SustainingReleaseDTO saveSustainingRelease(@RequestBody SustainingReleaseDTO sustainingReleaseDTO){
        Utils.validateIdNull(sustainingReleaseDTO.getId(), String.format("A new SustainingRelease cannot contains an Id"));
       return this.sustainingReleaseService.saveSustainingRelease(sustainingReleaseDTO);
    }

    @GetMapping(value = "/")
    public List<SustainingReleaseDTO> getSustainingReleases(){
        return this.sustainingReleaseService.getSustainingReleases();
    }

    @GetMapping(value = "/{id}")
    public SustainingReleaseDTO getSustainingRelease(@PathVariable Integer id){
        return this.sustainingReleaseService.getSustainingReleaseById(id);
    }
    
    @PutMapping(value = "/{id}")
    public SustainingReleaseDTO updateSustainingRelease(@PathVariable Integer id, @RequestBody SustainingReleaseDTO sustainingReleaseDTO){
        String msg = String.format("The SustainingRelease Id %s is different from the Url Id",sustainingReleaseDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,sustainingReleaseDTO.getId(),msg);
        return this.sustainingReleaseService.updateSustainingRelease(sustainingReleaseDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteSustainingRelease(@PathVariable Integer id,@RequestBody SustainingReleaseDTO sustainingReleaseDTO){
        String msg = String.format("The SustainingRelease Id %s is different from the Url Id",sustainingReleaseDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,sustainingReleaseDTO.getId(),msg);
        this.sustainingReleaseService.deleteSustainingRelease(sustainingReleaseDTO);
    }
    
}
