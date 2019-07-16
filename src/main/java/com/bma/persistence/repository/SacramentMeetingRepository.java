package com.bma.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.bma.persistence.model.SacramentMeeting;

public interface SacramentMeetingRepository extends CrudRepository<SacramentMeeting, Integer> {
}
