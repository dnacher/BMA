package com.bma.persistence.repository;

import com.bma.persistence.model.Organization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {

    @Query("from Organization o order by o.name")
    List<Organization> findAllOrderByName();
}
