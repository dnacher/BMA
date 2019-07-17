package com.bma.endpoint.controller;

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


}
