package com.bma.persistence.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bma.persistence.model.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {

    @Query("from Member m order by m.surname")
    List<Member> findAllOrderBySurname();
}
