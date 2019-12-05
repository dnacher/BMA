package com.bma.domain.service.mappers;

import com.bma.api.dtos.OrganizationDTO;
import com.bma.persistence.model.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper implements AbstractMapper<Organization, OrganizationDTO>{


    @Override
    public Organization mapToEntity(OrganizationDTO dto) {
        Organization organization = new Organization();
        organization.setId(dto.getId());
        organization.setName(dto.getName());
        return organization;
    }

    @Override
    public OrganizationDTO mapToDTO(Organization entity) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setId(entity.getId());
        organizationDTO.setName(entity.getName());
        return organizationDTO;
    }
}
