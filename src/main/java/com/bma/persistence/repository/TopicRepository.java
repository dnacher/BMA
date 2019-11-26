package com.bma.persistence.repository;

import com.bma.persistence.model.Member;
import com.bma.persistence.model.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query("from Topic t order by t.name")
    List<Topic> findAllOrderByName();
}
