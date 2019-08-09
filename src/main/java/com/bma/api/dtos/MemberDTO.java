package com.bma.api.dtos;

import com.bma.persistence.model.Calling;

public class MemberDTO {

    private Integer id;

    private String name;

    private String surname;

    private String fullname;

    private CallingDTO calling;

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
}
