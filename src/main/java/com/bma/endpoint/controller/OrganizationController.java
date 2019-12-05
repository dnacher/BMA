package com.bma.endpoint.controller;

import com.bma.api.dtos.OrganizationDTO;
import com.bma.domain.service.OrganizationService;
import com.bma.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @PostMapping(value = "/")
    public OrganizationDTO saveOrganization(@RequestBody OrganizationDTO organizationDTO){
        Utils.validateIdNull(organizationDTO.getId(), String.format("A new Organization cannot contains an Id"));
       return this.organizationService.saveOrganization(organizationDTO);
    }

    @PostMapping(value = "/mu")
    public List<OrganizationDTO> saveOrganizations(@RequestBody List<OrganizationDTO> organizationDTOS){
        List<OrganizationDTO>finalOrganizationDTOs = new ArrayList<>();
        organizationDTOS.forEach(organizationDTO -> finalOrganizationDTOs.add(this.organizationService.saveOrganization(organizationDTO)));
        return finalOrganizationDTOs;
    }

    @GetMapping(value = "/")
    public List<OrganizationDTO> getOrganizations(){
        return this.organizationService.getOrganizations();
    }

    @GetMapping(value = "/{id}")
    public OrganizationDTO getOrganizationById(@PathVariable("id") Integer id){
        return this.organizationService.getOrganizationById(id);
    }
    
    @PutMapping(value = "/{id}")
    public OrganizationDTO updateTopic(@PathVariable("id") int id, @RequestBody OrganizationDTO organizationDTO){
        String msg = String.format("The Organization Id %s is different from the Url Id",organizationDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,organizationDTO.getId(),msg);
        return this.organizationService.updateOrganization(organizationDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteTopic(@PathVariable Integer id){
        this.organizationService.deleteOrganization(id);
    }
    
}
