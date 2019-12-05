package com.bma.persistence.dao;

import com.bma.exception.BMAException;
import com.bma.persistence.model.Organization;
import com.bma.persistence.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationDAO {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> getOrganizations(){
        List<Organization> organizations = new ArrayList<>();
        organizationRepository.findAllOrderByName().forEach(organization -> organizations.add(organization));
        return organizations;
    }

    public Organization getOrganizationById(Integer id) throws BMAException{
        Organization organization = this.organizationRepository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The organization id %s does not exist", id.toString());
            return new BMAException(msg);
        });
        return organization;
    }

    public Organization saveOrganization(Organization organization){
        if(organization.getId()!=null){
            String msg = String.format("Cannot save a organization with Id");
            throw new BMAException(msg);
        }else{
            return organizationRepository.save(organization);
        }
    }

    public void deleteOrganization(Integer organizationId){
        organizationRepository.deleteById(organizationId);
    }

    public Organization updateOrganization(Organization organization){
        if(organization.getId()!=null){
            return organizationRepository.save(organization);
        }else{
            String msg = String.format("Cannot update a Organization without an Id");
            throw new BMAException(msg);
        }
    }

}
