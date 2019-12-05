package com.bma.domain.service;

import com.bma.api.dtos.OrganizationDTO;
import com.bma.domain.service.mappers.OrganizationMapper;
import com.bma.exception.BMAException;
import com.bma.persistence.dao.OrganizationDAO;
import com.bma.persistence.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class OrganizationService {

    private final OrganizationDAO organizationDAO;
    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationService(OrganizationDAO organizationDAO, OrganizationMapper organizationMapper){
        this.organizationDAO = organizationDAO;
        this.organizationMapper = organizationMapper;
    }

    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) throws BMAException{
        try {
            Organization organization = organizationMapper.mapToEntity(organizationDTO);
            return organizationMapper.mapToDTO(this.organizationDAO.saveOrganization(organization));
        } catch (BMAException e) {
            throw new BMAException(e.getMessage());
        }
    }

    public void deleteOrganization(Integer organizationId){
        this.organizationDAO.deleteOrganization(organizationId);
    }

    public OrganizationDTO updateOrganization(OrganizationDTO organizationDTO) throws BMAException{
        try {
            return this.organizationMapper.mapToDTO(this.organizationDAO.updateOrganization(organizationMapper.mapToEntity(organizationDTO)));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }

    public List<OrganizationDTO> getOrganizations(){
        List<Organization> organizations = this.organizationDAO.getOrganizations();
        return organizations.stream().map(organization -> this.organizationMapper.mapToDTO(organization)).collect(Collectors.toList());
    }

    public OrganizationDTO getOrganizationById(Integer id) throws BMAException{
        try {
            return this.organizationMapper.mapToDTO(this.organizationDAO.getOrganizationById(id));
        }catch (BMAException e){
            throw new BMAException(e.getMessage());
        }
    }


}
