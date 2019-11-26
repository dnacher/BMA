package com.bma.domain.service;

import com.bma.api.dtos.TopicDTO;
import com.bma.domain.service.mappers.TopicMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.TopicDAO;
import com.bma.persistence.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TopicService {

    private final TopicDAO topicDAO;
    private final TopicMapper topicMapper;

    @Autowired
    public TopicService(TopicDAO topicDAO, TopicMapper topicMapper){
        this.topicDAO = topicDAO;
        this.topicMapper = topicMapper;
    }

    public TopicDTO saveTopic(TopicDTO topicDTO) throws BMAException{
        try {
            Topic topic = topicMapper.mapToEntity(topicDTO);
            return topicMapper.mapToDTO(this.topicDAO.saveTopic(topic));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteTopic(Integer topicId){
        this.topicDAO.deleteTopic(topicId);
    }

    public TopicDTO updateTopic(TopicDTO topicDTO) throws BMAException{
        try {
            return this.topicMapper.mapToDTO(this.topicDAO.updateTopic(topicMapper.mapToEntity(topicDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<TopicDTO> getTopics(){
        List<Topic> topics = this.topicDAO.getTopics();
        return topics.stream().map(member -> this.topicMapper.mapToDTO(member)).collect(Collectors.toList());
    }

    public TopicDTO getTopicById(Integer id) throws BMAException{
        try {
            return this.topicMapper.mapToDTO(this.topicDAO.getTopicById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
