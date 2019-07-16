package com.bma.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.bma.persistence.model.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
