package com.bma.endpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bma.api.dtos.HymnDTO;
import com.bma.domain.service.HymnService;
import com.bma.domain.service.mappers.HymnMapper;
import com.bma.utils.Utils;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hymns")
public class HymnController {

    private final HymnService hymnService;
    private final HymnMapper hymnMapper;

    public HymnController(HymnService hymnService, HymnMapper hymnMapper){
        this.hymnService = hymnService;
        this.hymnMapper = hymnMapper;
    }

    @PostMapping(value = "/")
    public HymnDTO saveHymn(@RequestBody HymnDTO hymnDTO){
        Utils.validateIdNull(hymnDTO.getId(), String.format("A new Hymn cannot contains an Id"));
       return this.hymnService.saveHymn(hymnDTO);
    }

    @PostMapping(value = "/mul")
    public List<HymnDTO> saveHymn(@RequestBody List<HymnDTO> hymnDTOs){
        List<HymnDTO> finalList = new ArrayList<>();
         hymnDTOs.forEach( hymnDTO -> finalList.add(this.hymnService.saveHymn(hymnDTO)));
        return finalList;
    }

    @GetMapping(value = "/")
    public List<HymnDTO> getHymns(){
        return this.hymnService.getHymns();
    }

    @GetMapping(value = "/{id}")
    public HymnDTO getHymn(@PathVariable Integer id){
        return this.hymnService.getHymnById(id);
    }
    
    @PutMapping(value = "/{id}")
    public HymnDTO updateHymn(@PathVariable Integer id, @RequestBody HymnDTO hymnDTO){
        String msg = String.format("The Hymn Id %s is different from the Url Id",hymnDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,hymnDTO.getId(),msg);
        return this.hymnService.updateHymn(hymnDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteHymn(@PathVariable Integer id, HymnDTO hymnDTO){
        String msg = String.format("The Hymn Id %s is different from the Url Id",hymnDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,hymnDTO.getId(),msg);
        this.hymnService.deleteHymn(hymnDTO);
    }
    
}
