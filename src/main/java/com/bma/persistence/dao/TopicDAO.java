package com.bma.persistence.dao;

import com.bma.exception.BMAException;
import com.bma.persistence.model.Topic;
import com.bma.persistence.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TopicDAO {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAllOrderByName().forEach(topic -> topics.add(topic));
        return topics;
    }

    public Topic getTopicById(Integer id) throws BMAException{
        Topic topic = this.topicRepository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The topic id %s does not exist", id.toString());
            return new BMAException(msg);
        });
        return topic;
    }

    public Topic saveTopic(Topic topic){
        if(topic.getId()!=null){
            String msg = String.format("Cannot save a topic with Id");
            throw new BMAException(msg);
        }else{
            return topicRepository.save(topic);
        }
    }

    public void deleteTopic(Integer topicId){
        topicRepository.deleteById(topicId);
    }

    public Topic updateTopic(Topic topic){
        if(topic.getId()!=null){
            return topicRepository.save(topic);
        }else{
            String msg = String.format("Cannot update a Topic without an Id");
            throw new BMAException(msg);
        }
    }

}
