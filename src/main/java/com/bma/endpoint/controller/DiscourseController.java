package com.bma.endpoint.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bma.api.dtos.DiscourseDTO;
import com.bma.domain.service.DiscourseService;
import com.bma.domain.service.mappers.DiscourseMapper;
import com.bma.utils.Utils;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/discourses")
public class DiscourseController {

    private final DiscourseService discourseService;
    private final DiscourseMapper discourseMapper;

    public DiscourseController(DiscourseService discourseService, DiscourseMapper discourseMapper){
        this.discourseService = discourseService;
        this.discourseMapper = discourseMapper;
    }

    @PostMapping(value = "/")
    public DiscourseDTO saveDiscourse(@RequestBody DiscourseDTO discourseDTO){
        Utils.validateIdNull(discourseDTO.getId(), String.format("A new Discourse cannot contains an Id"));
       return this.discourseService.saveDiscourse(discourseDTO);
    }

    @GetMapping(value = "/")
    public List<DiscourseDTO> getDiscourses(){
        return this.discourseService.getDiscourses();
    }

    @GetMapping(value = "/{id}")
    public DiscourseDTO getDiscourse(@PathVariable Integer id){
        return this.discourseService.getDiscourseById(id);
    }
    
    @PutMapping(value = "/{id}")
    public DiscourseDTO updateDiscourse(@PathVariable Integer id, @RequestBody DiscourseDTO discourseDTO){
        String msg = String.format("The Discourse Id %s is different from the Url Id",discourseDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,discourseDTO.getId(),msg);
        return this.discourseService.updateDiscourse(discourseDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteDiscourse(@PathVariable Integer id,@RequestBody DiscourseDTO discourseDTO){
        String msg = String.format("The Discourse Id %s is different from the Url Id",discourseDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,discourseDTO.getId(),msg);
        this.discourseService.deleteDiscourse(discourseDTO);
    }
    
}
