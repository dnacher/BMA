package com.bma.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.bma.persistence.model.Prayer;

public interface PrayerRepository extends CrudRepository<Prayer, Integer> {
}
