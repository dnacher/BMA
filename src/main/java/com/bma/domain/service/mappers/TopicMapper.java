package com.bma.domain.service.mappers;

import com.bma.api.dtos.TopicDTO;
import com.bma.persistence.model.Topic;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper implements AbstractMapper<Topic, TopicDTO>{


    @Override
    public Topic mapToEntity(TopicDTO dto) {
        Topic topic = new Topic();
        topic.setId(dto.getId());
        topic.setName(dto.getName());
        return topic;
    }

    @Override
    public TopicDTO mapToDTO(Topic entity) {
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setId(entity.getId());
        topicDTO.setName(entity.getName());
        return topicDTO;
    }
}
