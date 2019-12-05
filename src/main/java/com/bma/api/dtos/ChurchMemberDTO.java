package com.bma.api.dtos;

public class ChurchMemberDTO {

    private Integer id;

    private String name;

    private String surname;

    private String fullname;

    private CallingDTO calling;

    private OrganizationDTO organization;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public CallingDTO getCalling() {
        return calling;
    }

    public void setCalling(CallingDTO calling) {
        this.calling = calling;
    }

    public OrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDTO organization) {
        this.organization = organization;
    }
}
