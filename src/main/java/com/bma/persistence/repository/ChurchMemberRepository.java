package com.bma.persistence.repository;

import java.util.List;

import com.bma.persistence.model.ChurchMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ChurchMemberRepository extends CrudRepository<ChurchMember, Integer> {

    @Query("from ChurchMember m order by m.surname")
    List<ChurchMember> findAllOrderBySurname();
}
