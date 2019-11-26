package com.bma.endpoint.controller;

import com.bma.api.dtos.TopicDTO;
import com.bma.domain.service.TopicService;
import com.bma.domain.service.mappers.TopicMapper;
import com.bma.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;
    private final TopicMapper topicMapper;

    public TopicController(TopicService topicService, TopicMapper topicMapper){
        this.topicService = topicService;
        this.topicMapper = topicMapper;
    }

    @PostMapping(value = "/")
    public TopicDTO saveTopic(@RequestBody TopicDTO topicDTO){
        Utils.validateIdNull(topicDTO.getId(), String.format("A new Topic cannot contains an Id"));
       return this.topicService.saveTopic(topicDTO);
    }

    @PostMapping(value = "/mu")
    public List<TopicDTO> saveTopics(@RequestBody List<TopicDTO> topicDTOS){
        List<TopicDTO>finalTopicDTOs = new ArrayList<>();
        topicDTOS.forEach(topicDTO -> finalTopicDTOs.add(this.topicService.saveTopic(topicDTO)));
        return finalTopicDTOs;
    }

    @GetMapping(value = "/")
    public List<TopicDTO> getTopics(){
        return this.topicService.getTopics();
    }

    @GetMapping(value = "/{id}")
    public TopicDTO getTopicById(@PathVariable("id") Integer id){
        return this.topicService.getTopicById(id);
    }
    
    @PutMapping(value = "/{id}")
    public TopicDTO updateTopic(@PathVariable("id") int id, @RequestBody TopicDTO topicDTO){
        String msg = String.format("The Topic Id %s is different from the Url Id",topicDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,topicDTO.getId(),msg);
        return this.topicService.updateTopic(topicDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteTopic(@PathVariable Integer id){
        String msg = String.format("The Topic Id %s is different from the Url Id",id);
        this.topicService.deleteTopic(id);
    }
    
}
