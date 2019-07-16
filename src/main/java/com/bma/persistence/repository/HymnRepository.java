package com.bma.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.bma.persistence.model.Hymn;

public interface HymnRepository extends CrudRepository<Hymn, Integer> {
}
